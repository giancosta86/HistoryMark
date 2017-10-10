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

import info.gianlucacosta.historymark.model.Age;

import javax.swing.DefaultComboBoxModel;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Stream;

class AgeModel extends DefaultComboBoxModel<AgeItem> {
    private final TreeSet<AgeItem> ageItemSet =
            new TreeSet<>();

    public AgeModel(List<Age> ages) {
        Stream.concat(
                Stream.of(AgeItem.ALL_TIME),

                ages
                        .stream()
                        .map(AgeItem::new)
        )
                .forEach(this::addElement);
    }


    @Override
    public void addElement(AgeItem ageItem) {
        ageItemSet.add(ageItem);

        int itemIndex =
                ageItemSet
                        .headSet(ageItem)
                        .size();

        super.insertElementAt(
                ageItem,
                itemIndex
        );
    }


    @Override
    public void removeElement(Object ageItem) {
        ageItemSet.remove(ageItem);

        super.removeElement(ageItem);
    }


    public void ensureElement(AgeItem item) {
        item.getAge().ifPresent(newAge -> {
            Optional<AgeItem> matchingAgeItemOption =
                    ageItemSet
                            .stream()
                            .filter(ageItem ->
                                    ageItem
                                            .getAge()
                                            .map(age ->
                                                    Objects.equals(
                                                            age.getId(),
                                                            newAge.getId()
                                                    )
                                            )
                                            .orElse(false)

                            )
                            .findAny();


            matchingAgeItemOption.ifPresent(this::removeElement);
        });


        addElement(item);
    }
}
