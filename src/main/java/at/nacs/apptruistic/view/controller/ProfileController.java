package at.nacs.apptruistic.view.controller;

import at.nacs.apptruistic.domain.Event;
import at.nacs.apptruistic.domain.Organization;
import at.nacs.apptruistic.dto.EventDto;
import at.nacs.apptruistic.logic.EventManager;
import at.nacs.apptruistic.logic.ProfileManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileManager profileManager;

    @ModelAttribute("events")
    List<Event> events() {
        return profileManager.showListOfEvents();
    }


    @ModelAttribute("organization")
    Organization organization() {
        return profileManager.showOrganizationInformation();
    }


    @GetMapping
    String page() {
        return "profile";
    }

    private final EventManager eventManager;

    @ModelAttribute("eventDto")
    EventDto eventDto() {
        return new EventDto();
    }
//
//    @GetMapping
//    String page() {
//        return "addevent";
//    }

    @PostMapping
    String post(@Valid EventDto eventDto, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        eventManager.store(eventDto);
        return "redirect:/profile";
    }

}
