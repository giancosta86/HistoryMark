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
import org.jxmapviewer.viewer.GeoPosition;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class LocationTest {
    private final double LATITUDE = 34.8;
    private final double LONGITUDE = 156.7;


    private final Location referenceLocation =
            new Location(
                    LATITUDE,
                    LONGITUDE
            );


    private final GeoPosition referencePosition =
            new GeoPosition(
                    LATITUDE,
                    LONGITUDE
            );


    @Test
    public void gettersShouldWork() {
        assertThat(
                referenceLocation.getLatitude(),
                equalTo(LATITUDE)
        );

        assertThat(
                referenceLocation.getLongitude(),
                equalTo(LONGITUDE)
        );
    }


    @Test
    public void conversionFromPositionShouldWork() {
        Location convertedLocation =
                new Location(referencePosition);

        assertThat(
                convertedLocation,
                equalTo(referenceLocation)
        );
    }


    @Test
    public void conversionToPositionShouldWork() {
        GeoPosition convertedPosition =
                referenceLocation.toPosition();

        assertThat(
                convertedPosition,
                equalTo(referencePosition)
        );
    }
}
