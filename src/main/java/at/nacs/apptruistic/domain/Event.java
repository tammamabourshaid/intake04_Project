package at.nacs.apptruistic.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Event {

  private String id;

  private String oId;

  @NotEmpty(message = "please enter the name of the event")
  @NotNull
  private String what;

  @FutureOrPresent
  @NotEmpty(message = "please choose a date for the event")
  @NotNull
  @DateTimeFormat(pattern = "dd-MMM-YYYY")
  private LocalDate when;

  @Future(message = "please enter a date in the future")
  @NotNull
  @NotEmpty(message = "please enter the deadline date to accept volunteers")
  @DateTimeFormat(pattern = "dd-MMM-YYYY")
  private LocalDate deadline;

  @NotEmpty(message = "please enter a short description about the organization")
  @NotNull
  private String description;

  @NotEmpty
  @NotNull
  private String location;

  @NotEmpty(message = "please choose a topic")
  private String topic;


  @NotEmpty(message = "please enter a short description about the organization")
  @NotNull
  private String contact;

  @NotEmpty(message = "please enter the number of volunteers required")
  @NotNull
  private String capacity;

  private String organizationName;

}
