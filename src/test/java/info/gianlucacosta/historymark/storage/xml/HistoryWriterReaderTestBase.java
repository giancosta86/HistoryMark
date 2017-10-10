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

import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public abstract class HistoryWriterReaderTestBase<T> {
    protected abstract T createTestObject();

    protected abstract void writeTestObject(HistoryWriter historyWriter, T testObject);

    protected abstract T readTestObject(HistoryReader historyReader);


    @Test
    public void writingAndThenReadingShouldReturnTheInitialObject() throws Exception {
        StringWriter stringWriter =
                new StringWriter();

        T initialObject =
                createTestObject();


        try (HistoryWriter historyWriter =
                     new HistoryWriter(stringWriter)) {

            writeTestObject(
                    historyWriter,
                    initialObject
            );
        }


        String xmlString =
                stringWriter.toString();


        System.out.println("\n---------------------");
        System.out.println(xmlString);
        System.out.println("---------------------\n");


        try (HistoryReader historyReader =
                     new HistoryReader(
                             new StringReader(
                                     xmlString
                             )
                     )
        ) {
            T retrievedObject =
                    readTestObject(historyReader);

            assertThat(
                    retrievedObject,
                    equalTo(initialObject)
            );
        }
    }
}
