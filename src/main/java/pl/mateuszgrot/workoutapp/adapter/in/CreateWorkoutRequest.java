package pl.mateuszgrot.workoutapp.adapter.in;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.mateuszgrot.workoutapp.adapter.DurationDto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateWorkoutRequest {

    @NotEmpty
    private String name;

    @Valid
    private DurationDto duration;


}

