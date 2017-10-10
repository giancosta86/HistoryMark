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

package info.gianlucacosta.historymark.gui.main.ages;

import info.gianlucacosta.historymark.gui.util.HistoryObjectDialog;
import info.gianlucacosta.historymark.model.Age;
import info.gianlucacosta.zephyros.swing.components.LabeledInputPanel;
import info.gianlucacosta.zephyros.swing.components.PlainLocalDatePicker;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.UUID;


class AgeDialog extends HistoryObjectDialog<Age> {
    private JTextField nameField;
    private PlainLocalDatePicker startPicker;
    private PlainLocalDatePicker endPicker;


    public AgeDialog() {
        super();
    }

    public AgeDialog(Age ageToEdit) {
        super(ageToEdit);
    }


    @Override
    protected JPanel createContentPanel() {
        LabeledInputPanel contentPanel =
                new LabeledInputPanel();

        contentPanel.addLabel("Name:");

        nameField =
                new JTextField() {
                    {
                        setColumns(20);
                    }
                };

        contentPanel.addInput(nameField);


        contentPanel.addLabel("Start:");

        startPicker =
                new PlainLocalDatePicker();

        contentPanel.addInput(startPicker);


        contentPanel.addLabel("End:");

        endPicker =
                new PlainLocalDatePicker();

        contentPanel.addInput(endPicker);


        return contentPanel;
    }


    @Override
    protected String getDialogTitle(boolean hasInitialValue) {
        return hasInitialValue ?
                "Edit age..."
                :
                "Add age...";
    }

    @Override
    protected void writeToGuiFields(Age initialValue) {
        nameField.setText(initialValue.getName());

        startPicker.setDate(initialValue.getStart());

        endPicker.setDate(initialValue.getEnd());
    }

    @Override
    protected Age readFromGuiFields() {
        return new Age(
                initialValueOption
                        .map(Age::getId)
                        .orElseGet(UUID::randomUUID),

                nameField.getText(),
                startPicker.getDate(),
                endPicker.getDate()
        );
    }
}
