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

package info.gianlucacosta.historymark.gui.util;

import info.gianlucacosta.historymark.model.Location;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.FlowLayout;


public class LocationEditor extends JPanel {
    private static final String COORDINATE_FORMAT_STRING = "%.3f";

    private final JTextField latitudeField =
            new JTextField(7);

    private final JTextField longitudeField =
            new JTextField(7);


    public LocationEditor() {
        setLayout(new FlowLayout());

        add(
                new JLabel("Latitude:")
        );

        add(
                latitudeField
        );


        add(
                new JLabel("Longitude:")
        );


        add(
                longitudeField
        );
    }


    public Location getLocationValue() {
        double latitude =
                Double.parseDouble(latitudeField.getText());

        double longitude =
                Double.parseDouble(longitudeField.getText());

        return new Location(latitude, longitude);
    }


    public void setLocationValue(Location location) {
        latitudeField.setText(
                String.format(COORDINATE_FORMAT_STRING, location.getLatitude())
        );


        longitudeField.setText(
                String.format(COORDINATE_FORMAT_STRING, location.getLongitude())
        );
    }
}
