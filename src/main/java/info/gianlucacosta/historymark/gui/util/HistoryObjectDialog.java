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

import info.gianlucacosta.historymark.icons.MainIcon;
import info.gianlucacosta.zephyros.swing.dialogs.ObjectDialog;
import info.gianlucacosta.zephyros.swing.graphics.Images;

import java.awt.Image;
import java.util.Optional;

public abstract class HistoryObjectDialog<T> extends ObjectDialog<T> {
    public HistoryObjectDialog() {
    }

    public HistoryObjectDialog(T valueToedit) {
        super(valueToedit);
    }

    @Override
    protected Optional<Image> getWindowIcon() {
        return Optional.of(
                Images.readFromURL(
                        MainIcon.getUrl(32)
                )
        );
    }
}
