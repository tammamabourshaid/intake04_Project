package at.nacs.apptruistic.view.controller;

import at.nacs.apptruistic.domain.Organization;
import at.nacs.apptruistic.logic.OrganizationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignUpController {

  private final OrganizationManager organizationManager;

  @ModelAttribute("organization")
  Organization organization() {
    return new Organization();
  }

  @GetMapping
  String page() {
    return "signup";
  }

  @PostMapping
  String post(@Valid Organization organization, BindingResult result) {
    Optional<Organization> existing = organizationManager.findByEmail(organization.getEmail());
    if (existing.isPresent()) {
      result.rejectValue("email", null, "There is already an account registered with that email");
    }
    if (result.hasErrors()) {
      return page();
    }
    organizationManager.store(organization);

    return "redirect:/login";
  }
}
