package at.nacs.apptruistic.repository;

import at.nacs.apptruistic.domain.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
List<Event> findAllByOId(String oId);

  List<Event> findAllByOrderByWhenAsc();

}
