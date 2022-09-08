package pl.mateuszgrot.workoutapp;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CreateWorkoutRequest {

  @NotEmpty
  private String name;

  @NotNull
  @Valid
  private DurationDto duration;


}

