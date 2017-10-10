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
import org.jxmapviewer.viewer.GeoPosition;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class GeoPositionDialog extends HistoryObjectDialog<GeoPosition> {
    private LocationEditor locationEditor;

    public GeoPositionDialog() {
        super();
    }


    public GeoPositionDialog(GeoPosition valueToedit) {
        super(valueToedit);
    }


    @Override
    protected String getDialogTitle(boolean hasInitialValue) {
        return "Set position...";
    }


    @Override
    protected JPanel createContentPanel() {
        locationEditor =
                new LocationEditor();

        locationEditor.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        return locationEditor;
    }


    @Override
    protected void writeToGuiFields(GeoPosition initialValue) {
        locationEditor.setLocationValue(
                new Location(
                        initialValue
                )
        );
    }


    @Override
    protected GeoPosition readFromGuiFields() {
        return locationEditor
                .getLocationValue()
                .toPosition();
    }
}

