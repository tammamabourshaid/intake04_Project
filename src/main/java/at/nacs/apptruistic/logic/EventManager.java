package at.nacs.apptruistic.logic;

import at.nacs.apptruistic.domain.Event;

import at.nacs.apptruistic.dto.EventDto;
import at.nacs.apptruistic.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventManager {
  private final LoginManager loginManager;
  private final EventRepository eventRepository;

  public Event store(EventDto eventDto) {
    String id = loginManager.getCurrentUser().getId();
    String organizationName=loginManager.getCurrentUser().getOrganizationName();
    Event event = new Event();
    event.setOrganizationName(organizationName);
    //event.setNow(LocalDateTime.now());
    event.setWhat(eventDto.getWhat());
    event.setWhen(LocalDate.parse(eventDto.getWhen()));
    event.setDeadline(LocalDate.parse(eventDto.getDeadline()));
    event.setDescription(eventDto.getDescription());
    event.setLocation(eventDto.getLocation());
    event.setTopic(eventDto.getTopic());
    event.setContact(eventDto.getContact());
    event.setCapacity(eventDto.getCapacity());

    event.setOId(id);
    return eventRepository.save(event);
  }
}
