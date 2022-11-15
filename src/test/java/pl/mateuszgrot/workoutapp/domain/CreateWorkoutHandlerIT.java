package pl.mateuszgrot.workoutapp.domain;


import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.temporal.ChronoUnit;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import pl.mateuszgrot.workoutapp.adapter.DurationDto;
import pl.mateuszgrot.workoutapp.adapter.in.CreateWorkoutRequest;
import pl.mateuszgrot.workoutapp.infrastructure.db.WorkoutRepository;


@ContextConfiguration(initializers = {MongoTestContainerInitializer.class})
@SpringBootTest
public class CreateWorkoutHandlerIT {

    @Autowired
    private CreateWorkoutHandler handler;
    @Autowired
    private WorkoutRepository repository;


    @Test
    @DisplayName("Dupa")
    void shouldCreateWorkout_whenRequestIsOk() {

        //given
        final UUID id = UUID.randomUUID();
        final CreateWorkoutRequest request = new CreateWorkoutRequest("Katarzyna",
            new DurationDto(5L, "SECONDS"));

        //when
        handler.create(id, request);

        //then

        final Workout result = repository.findById(id).orElseThrow();
        assertEquals(id, result.getId());
        assertEquals("Katarzyna", result.getName());
        assertEquals(5L, result.getDuration().getSeconds());
        assertEquals(5L, result.getDuration().get(ChronoUnit.SECONDS));

    }

}
