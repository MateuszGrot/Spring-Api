package pl.mateuszgrot.workoutapp;

import org.springframework.stereotype.Component;

@Component
public class WorkoutResponseMapper {

  public WorkoutResponse map(final Workout workout) {
    return new WorkoutResponse(workout.getId(), workout.getName(), workout.getDuration());
  }

}
