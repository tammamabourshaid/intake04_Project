package at.nacs.apptruistic.logic;

import at.nacs.apptruistic.domain.Event;
import at.nacs.apptruistic.domain.Organization;
import at.nacs.apptruistic.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileManager {

  private final LoginManager loginManager;
  private final EventRepository eventRepository;


  public List<Event> showListOfEvents() {
    String oId = loginManager.getCurrentUser().getId();

    return eventRepository.findAllByOId(oId);
  }

  public Organization showOrganizationInformation() {
    Organization organization = loginManager.getCurrentUser();
    return organization;
  }

}
