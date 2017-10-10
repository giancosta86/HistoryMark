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

import info.gianlucacosta.historymark.gui.main.MainFrame;
import info.gianlucacosta.zephyros.swing.graphics.Images;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Optional;


public class IconButton extends JButton {
    public IconButton(String toolTip, String iconFileName) {
        this(toolTip, iconFileName, Optional.empty());
    }


    public IconButton(String toolTip, String iconFileName, ActionListener onClick) {
        this(toolTip, iconFileName, Optional.of(onClick));
    }


    public IconButton(String toolTip, String iconFileName, Optional<ActionListener> onClickOption) {
        setToolTipText(toolTip);

        Image buttonIcon =
                Images.readFromURL(
                        MainFrame.class.getResource("icons/" + iconFileName)
                );

        setIcon(
                new ImageIcon(buttonIcon)
        );

        onClickOption.ifPresent(this::addActionListener);
    }
}
