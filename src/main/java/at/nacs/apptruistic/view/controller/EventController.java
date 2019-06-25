package at.nacs.apptruistic.view.controller;

import at.nacs.apptruistic.domain.Event;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/addevent")
@Controller
public class EventController {

    private final EventManager eventManager;
    private final  ProfileManager profileManager;

    @ModelAttribute("eventDto")
    EventDto eventDto() {
        return new EventDto();
    }

    @GetMapping
    String page() {
        return "addevent";
    }

    @PostMapping
    String post(@Valid EventDto eventDto, BindingResult result) {
        if (result.hasErrors()) {
            return page();
        }
        eventManager.store(eventDto);
        return "redirect:/profile";
    }
    @ModelAttribute("events")
    List<Event> events() {

        return profileManager.showListOfEvents();
    }

}
