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

import info.gianlucacosta.historymark.model.Pin;
import info.gianlucacosta.historymark.model.TestObjects;

import java.util.Collection;

public class HistoryWriterReaderForPinTest extends HistoryWriterReaderTestBase<Collection<Pin>> {
    @Override
    protected Collection<Pin> createTestObject() {
        return TestObjects.pins;
    }

    @Override
    protected void writeTestObject(HistoryWriter historyWriter, Collection<Pin> testPins) {
        historyWriter.writePins(testPins);
    }

    @Override
    protected Collection<Pin> readTestObject(HistoryReader historyReader) {
        return historyReader.readPins();
    }
}
