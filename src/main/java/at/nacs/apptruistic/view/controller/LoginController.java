package at.nacs.apptruistic.view.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Controller
public class LoginController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }

//  @PostMapping("/login")
//  public String postLogin(HttpServletRequest request) {
//    return "redirect:/profile";
//  }
}
