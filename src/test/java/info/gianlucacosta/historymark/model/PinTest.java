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

package info.gianlucacosta.historymark.model;

import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class PinTest {
    private final Pin referencePin =
            TestObjects.alphaPin;


    @Test(expected = IllegalArgumentException.class)
    public void emptyTitlesShouldNotBeAccepted() {
        new Pin(
                "",
                referencePin.getLocation(),
                referencePin.getDate(),
                referencePin.getEncodedColor()
        );
    }


    @Test(expected = IllegalArgumentException.class)
    public void titlesHavingOnlySpacesShouldNotBeAccepted() {
        new Pin(
                "  \t      \t  ",
                referencePin.getLocation(),
                referencePin.getDate(),
                referencePin.getEncodedColor()
        );
    }


    @Test
    public void titlesShouldBeTrimmed() {
        Pin testPin =
                new Pin(
                        "   Example  ",
                        referencePin.getLocation(),
                        referencePin.getDate(),
                        referencePin.getEncodedColor()
                );

        assertThat(
                testPin.getTitle(),
                equalTo("Example")
        );
    }
}
