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

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.time.LocalDate;

/**
 * Converts a LocalDate by writing its year, month and day as attributes
 */
class LocalDateConverter implements Converter {
    private static final String YEAR_ATTRIBUTE = "year";
    private static final String MONTH_ATTRIBUTE = "month";
    private static final String DAY_ATTRIBUTE = "day";


    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        LocalDate sourceDate =
                (LocalDate) source;

        writer.addAttribute(
                YEAR_ATTRIBUTE,
                String.valueOf(sourceDate.getYear())
        );

        writer.addAttribute(
                MONTH_ATTRIBUTE,
                String.valueOf(sourceDate.getMonthValue())
        );


        writer.addAttribute(
                DAY_ATTRIBUTE,
                String.valueOf(sourceDate.getDayOfMonth())
        );
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        int year =
                Integer.parseInt(reader.getAttribute(YEAR_ATTRIBUTE));

        int month =
                Integer.parseInt(reader.getAttribute(MONTH_ATTRIBUTE));

        int day =
                Integer.parseInt(reader.getAttribute(DAY_ATTRIBUTE));


        return LocalDate.of(
                year,
                month,
                day
        );
    }

    @Override
    public boolean canConvert(Class type) {
        return type == LocalDate.class;
    }
}
