package at.nacs.apptruistic.view.controller;

import at.nacs.apptruistic.domain.Event;
import at.nacs.apptruistic.logic.IndexManager;
import at.nacs.apptruistic.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class IndexController {
  private final IndexManager indexManager;
  @GetMapping
  String page() {
    return "index";
  }

  @ModelAttribute("events")
  List<Event> events() {
    return indexManager.findAll();
  }

  @ModelAttribute("principal")
  UserPrincipal principal(@AuthenticationPrincipal UserPrincipal principal) {
    return principal;
  }
}
