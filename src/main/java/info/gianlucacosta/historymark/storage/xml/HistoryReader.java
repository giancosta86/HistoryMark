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

import info.gianlucacosta.historymark.model.Age;
import info.gianlucacosta.historymark.model.Pin;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.List;

public class HistoryReader implements AutoCloseable {
    private final Reader source;

    public HistoryReader(Reader source) {
        this.source = source;
    }

    public List<Age> readAges() {
        AgeBundle ageBundle =
                readObject();

        return ageBundle.getAges();
    }


    public Collection<Pin> readPins() {
        PinBundle pinBundle =
                readObject();

        return pinBundle.getPins();
    }

    @SuppressWarnings("unchecked")
    private <T> T readObject() {
        return (T) HistoryXStream.getInstance().fromXML(source);
    }


    @Override
    public void close() throws IOException {
        source.close();
    }
}
