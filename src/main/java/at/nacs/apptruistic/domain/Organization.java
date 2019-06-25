package at.nacs.apptruistic.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
public final class Organization {

  private String id;

  @Email
  @NotNull
  @NotEmpty(message = "please enter your e-mail address")
  private String email;

  @NotEmpty(message = "please choose a password")
  @NotNull
  @Size(max = 16, min = 8, message = "password must be greater than 8 and smaller than 16 characters")
  private String password;


  @NotEmpty(message = "organization name cannot be empty")
  @NotNull
  private String organizationName;

  @NotEmpty(message = "please enter a short description about the organization")
  @NotNull
  private String description;


  private String websiteLink;

  @NotEmpty(message = "please enter your contact information")
  @NotNull
  private String contact;



  private Set<String> authorities = new HashSet<>();
}
