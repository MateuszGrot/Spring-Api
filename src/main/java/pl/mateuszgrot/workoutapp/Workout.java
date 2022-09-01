package pl.mateuszgrot.workoutapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter


public class Workout {

    private long id;
    private String name;
    private String durationTime;

}
