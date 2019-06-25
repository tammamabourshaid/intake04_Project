package at.nacs.apptruistic.logic;

import at.nacs.apptruistic.domain.Event;
import at.nacs.apptruistic.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndexManager {
  private final EventRepository eventRepository;

  public List<Event> findAll(){
    return eventRepository.findAllByOrderByWhenAsc();
  }
}
