package at.nacs.apptruistic.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {

    registry.addViewController("/").setViewName("index");
    registry.addViewController("/signup").setViewName("signup");
    registry.addViewController("/profile").setViewName("profile");
    registry.addViewController("/addevent").setViewName("addevent");
    registry.addViewController("/contact").setViewName("contact");
    registry.addViewController("/volunteer").setViewName("volunteer");
  }

}
