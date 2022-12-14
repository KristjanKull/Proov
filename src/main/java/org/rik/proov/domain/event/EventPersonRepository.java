package org.rik.proov.domain.event;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPersonRepository extends CrudRepository<EventPerson, Long> {
}
