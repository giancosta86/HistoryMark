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

package info.gianlucacosta.historymark.storage.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import info.gianlucacosta.historymark.model.Age;
import info.gianlucacosta.historymark.model.Pin;

class HistoryXStream extends XStream {
    private static final HistoryXStream instance =
            new HistoryXStream();

    public static HistoryXStream getInstance() {
        return instance;
    }


    private HistoryXStream() {
        initSecurity();
        initConverters();
        initAliases();
    }


    private void initSecurity() {
        addPermission(NoTypePermission.NONE);

        addPermission(NullPermission.NULL);
        addPermission(PrimitiveTypePermission.PRIMITIVES);

        allowTypesByWildcard(new String[]{
                "info.gianlucacosta.historymark.**",
                "java.util.**",
                "java.time.**"
        });
    }

    private void initConverters() {
        registerConverter(new LocalDateConverter());
    }


    private void initAliases() {
        alias("ages", AgeBundle.class);
        addImplicitCollection(AgeBundle.class, "ages");
        alias("age", Age.class);

        alias("pins", PinBundle.class);
        addImplicitCollection(PinBundle.class, "pins");
        alias("pin", Pin.class);
    }
}
