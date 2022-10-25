package pl.mateuszgrot.workoutapp.domain;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.mateuszgrot.workoutapp.adapter.in.CreateWorkoutRequest;
import pl.mateuszgrot.workoutapp.infrastructure.db.WorkoutRepository;

@AllArgsConstructor
@Component
public class CreateWorkoutHandler {

    private final WorkoutRepository workoutRepository;

    public void create(UUID id, CreateWorkoutRequest request) {
        final Workout workout = new Workout(id,
            request.getName(),
            Duration.of(
                request.getDuration().getAmount(),
                ChronoUnit.valueOf(request.getDuration().getUnit())
            )
        );

        workoutRepository.save(workout);
    }
}
