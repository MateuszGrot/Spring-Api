package pl.mateuszgrot.workoutapp.adapter.in;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import pl.mateuszgrot.workoutapp.adapter.DurationDto;

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

