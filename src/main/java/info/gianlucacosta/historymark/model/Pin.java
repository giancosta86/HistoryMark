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

package info.gianlucacosta.historymark.model;

import info.gianlucacosta.historymark.util.HistoryDateFormat;
import org.jxmapviewer.viewer.GeoPosition;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.awt.Color;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"title", "latitude", "longitude", "date"}
                )
        }
)
public class Pin implements info.gianlucacosta.atlas.pin.CommonPin {
    @Id
    private UUID id;

    private String title;

    private Location location;

    private LocalDate date;

    private String encodedColor;


    private Pin() {
    }


    public Pin(
            String title,
            Location location,
            LocalDate date,
            String encodedColor
    ) {
        this(
                UUID.randomUUID(),
                title,
                location,
                date,
                encodedColor
        );
    }


    public Pin(
            UUID id,
            String title,
            Location location,
            LocalDate date,
            String encodedColor
    ) {
        this.id = id;

        String actualTitle =
                title.trim();

        if (actualTitle.isEmpty()) {
            throw new IllegalArgumentException("The title is missing");
        }

        this.title = actualTitle;
        this.location = location;
        this.date = date;

        this.encodedColor = encodedColor;
    }


    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Location getLocation() {
        return location;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEncodedColor() {
        return encodedColor;
    }

    @Override
    public GeoPosition getPosition() {
        return location.toPosition();
    }

    @Override
    public Color getColor() {
        return Color.decode(encodedColor);
    }

    @Override
    public String getLabelText() {
        return String.format(
                "%s (%s)",
                title,
                HistoryDateFormat.formatDate(date)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pin)) return false;
        Pin pin = (Pin) o;
        return Objects.equals(id, pin.id) &&
                Objects.equals(title, pin.title) &&
                Objects.equals(location, pin.location) &&
                Objects.equals(date, pin.date) &&
                Objects.equals(encodedColor, pin.encodedColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, location, date, encodedColor);
    }


    @Override
    public String toString() {
        return "Pin{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location=" + location +
                ", date=" + date +
                ", encodedColor='" + encodedColor + '\'' +
                '}';
    }
}