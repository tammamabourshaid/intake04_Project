package at.nacs.apptruistic.view.controller;

import at.nacs.apptruistic.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/volunteer")
public class VolunteerController {
  @GetMapping
  String page() {
    return "volunteer";
  }


  @ModelAttribute("principal")
  UserPrincipal principal(@AuthenticationPrincipal UserPrincipal principal) {
    return principal;
  }
}
