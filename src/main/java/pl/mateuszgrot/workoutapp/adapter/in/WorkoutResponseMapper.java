package pl.mateuszgrot.workoutapp.adapter.in;

import org.springframework.stereotype.Component;
import pl.mateuszgrot.workoutapp.adapter.in.WorkoutResponse;
import pl.mateuszgrot.workoutapp.domain.Workout;

@Component
public class WorkoutResponseMapper {

  public WorkoutResponse map(final Workout workout) {
    return new WorkoutResponse(workout.getId(), workout.getName(), workout.getDuration());
  }

}
