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

package info.gianlucacosta.historymark.storage;

import info.gianlucacosta.historymark.model.Pin;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CachingPinRepository implements PinRepository {
    private final PinRepository backingRepository;
    private final Map<UUID, Pin> cache;


    public CachingPinRepository(PinRepository backingRepository) {
        this.backingRepository = backingRepository;

        this.cache =
                backingRepository
                        .findAll()
                        .stream()
                        .collect(
                                Collectors.toMap(
                                        Pin::getId,
                                        Function.identity()
                                )
                        );
    }


    @Override
    public Collection<Pin> findAll() {
        return cache.values();
    }

    @Override
    public void save(Pin pin) {
        backingRepository.save(pin);

        cache.put(
                pin.getId(),
                pin
        );
    }

    @Override
    public void delete(Pin pin) {
        backingRepository.delete(pin);

        cache.remove(pin.getId());
    }
}

