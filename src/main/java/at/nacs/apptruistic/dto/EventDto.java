package at.nacs.apptruistic.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class EventDto {

  @NotEmpty
  private String what;

  @NotEmpty
  private String when;

  @NotEmpty
  private String deadline;

  @NotEmpty
  private String description;

  @NotEmpty
  private String location;

  @NotEmpty
  private String topic;

  @NotEmpty
  private String contact;

  @NotEmpty
  private String capacity;

}
