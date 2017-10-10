/*^
  ===========================================================================
  HistoryMark
  ===========================================================================
  Copyright (C) 2017 Gianluca Costa
  ===========================================================================
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  ===========================================================================
*/

package info.gianlucacosta.historymark.storage.xml;

import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import info.gianlucacosta.historymark.model.Age;
import info.gianlucacosta.historymark.model.Pin;

import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;

public class HistoryWriter implements AutoCloseable {
    private final Writer target;

    public HistoryWriter(Writer target) {
        this.target = target;
    }


    public void writeAges(List<Age> ages) {
        writeObject(new AgeBundle(ages));
    }


    public void writePins(Collection<Pin> pins) {
        writeObject(new PinBundle(pins));
    }


    private void writeObject(Object object) {
        PrettyPrintWriter prettyPrintWriter =
                new PrettyPrintWriter(target);

        HistoryXStream.getInstance().marshal(object, prettyPrintWriter);
    }


    @Override
    public void close() throws IOException {
        target.close();
    }
}
