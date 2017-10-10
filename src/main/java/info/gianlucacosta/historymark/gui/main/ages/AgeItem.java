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
import info.gianlucacosta.historymark.util.HistoryDateFormat;
import info.gianlucacosta.zephyros.comparators.OptionalComparator;

import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;


class AgeItem implements Comparable<AgeItem> {
    public static final AgeItem ALL_TIME =
            new AgeItem();


    private static final Comparator<AgeItem> naturalComparator =
            Comparator.comparing(
                    AgeItem::getAge,
                    new OptionalComparator<>()
            );


    private final Optional<Age> ageOption;

    private AgeItem() {
        ageOption = Optional.empty();
    }

    public AgeItem(Age age) {
        ageOption = Optional.of(age);
    }


    @Override
    public int compareTo(AgeItem other) {
        return naturalComparator.compare(this, other);
    }

    public Optional<Age> getAge() {
        return ageOption;
    }


    public String getTitle() {
        return ageOption
                .map(age ->
                        String.format(
                                "%s (%s — %s)",
                                age.getName(),
                                HistoryDateFormat.formatDate(age.getStart()),
                                HistoryDateFormat.formatDate(age.getEnd())
                        ))
                .orElse("(ALL HISTORY)");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AgeItem)) return false;
        AgeItem ageItem = (AgeItem) o;
        return Objects.equals(ageOption, ageItem.ageOption);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ageOption);
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
