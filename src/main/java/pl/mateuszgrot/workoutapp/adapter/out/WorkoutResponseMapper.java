package pl.mateuszgrot.workoutapp.adapter.out;

import org.springframework.stereotype.Component;
import pl.mateuszgrot.workoutapp.adapter.out.WorkoutResponse;
import pl.mateuszgrot.workoutapp.domain.Workout;

@Component
public class WorkoutResponseMapper {

  public WorkoutResponse map(final Workout workout) {
    return new WorkoutResponse(workout.getId(), workout.getName(), workout.getDuration());
  }

}
