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

import info.gianlucacosta.zephyros.swing.graphics.Colors;

import java.awt.Color;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface TestObjects {
    Age alphaAge =
            new Age(
                    "Alpha age",
                    LocalDate.of(100, 1, 1),
                    LocalDate.of(200, 1, 1)
            );


    Age betaAge =
            new Age(
                    "Beta age",
                    LocalDate.of(800, 1, 1),
                    LocalDate.of(900, 1, 1)
            );


    List<Age> ages =
            Arrays.asList(
                    alphaAge,
                    betaAge
            );


    Pin alphaPin =
            new Pin(
                    "Alpha pin",
                    new Location(6, 14),
                    LocalDate.of(150, 2, 28),
                    Colors.encode(Color.BLUE)
            );


    Pin betaPin =
            new Pin(
                    "Beta pin",
                    new Location(87.4, 11.9),
                    LocalDate.of(432, 4, 5),
                    Colors.encode(Color.GREEN)
            );


    Set<Pin> pins =
            new HashSet<>(
                    Arrays.asList(
                            alphaPin,
                            betaPin
                    )
            );
}
