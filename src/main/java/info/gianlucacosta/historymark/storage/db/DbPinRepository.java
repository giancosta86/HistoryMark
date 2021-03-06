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

package info.gianlucacosta.historymark.storage.db;

import info.gianlucacosta.historymark.model.Pin;
import info.gianlucacosta.historymark.storage.PinRepository;
import info.gianlucacosta.zephyros.db.hibernate.FunctionalSession;
import info.gianlucacosta.zephyros.db.hibernate.PersistenceExceptions;
import org.hibernate.SessionFactory;

import javax.persistence.PersistenceException;
import java.util.Collection;


public class DbPinRepository extends FunctionalSession implements PinRepository {
    public DbPinRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Collection<Pin> findAll() {
        return runNamedListQuery(
                "info.gianlucacosta.historymark.ReadPins",
                Pin.class
        );
    }

    @Override
    public void save(Pin pin) {
        try {
            saveOrUpdateInTransaction(pin);
        } catch (PersistenceException ex) {
            PersistenceExceptions.getSqlState(ex).ifPresent(sqlState -> {
                switch (sqlState) {
                    case UNIQUE_VIOLATION:
                        throw new DuplicateException();
                }
            });

            throw ex;
        }
    }

    @Override
    public void delete(Pin pin) {
        deleteInTransaction(pin);
    }
}
