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

package info.gianlucacosta.historymark.gui.main;

import info.gianlucacosta.historymark.ArtifactInfo;
import info.gianlucacosta.historymark.gui.util.IconButton;
import info.gianlucacosta.historymark.icons.MainIcon;
import info.gianlucacosta.zephyros.os.User;
import info.gianlucacosta.zephyros.swing.dialogs.AboutBox;
import info.gianlucacosta.zephyros.swing.graphics.Images;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.Optional;

class AboutPanel extends JPanel {
    public AboutPanel() {
        setLayout(new FlowLayout());

        add(
                new IconButton(
                        "Visit website",
                        "web.png",
                        this::showWebsite
                )
        );


        add(
                new IconButton(
                        "About...",
                        "about.png",
                        this::showAboutBox
                )
        );
    }


    private void showWebsite(ActionEvent event) {
        User.openBrowser(
                ArtifactInfo.getWebsite()
        );
    }


    private void showAboutBox(ActionEvent event) {
        AboutBox aboutBox =
                new AboutBox(
                        Images.readFromURL(
                                MainIcon.getUrl(32)
                        ),

                        Images.readFromURL(
                                MainIcon.getUrl(128)
                        ),
                        ArtifactInfo.getName(),
                        ArtifactInfo.getVersion(),
                        ArtifactInfo.getCopyrightHolder(),
                        Optional.ofNullable(ArtifactInfo.getFacebookPage())
                );


        aboutBox.setVisible(true);
    }
}
