package pl.mateuszgrot.workoutapp.domain;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import pl.mateuszgrot.workoutapp.adapter.DurationDto;
import pl.mateuszgrot.workoutapp.adapter.in.CreateWorkoutRequest;
import pl.mateuszgrot.workoutapp.infrastructure.db.WorkoutRepository;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration(initializers = {MongoTestContainerInitializer.class})
class CreateWorkoutHandlerTest {


    private CreateWorkoutHandler handler;
    @Mock
    private WorkoutRepository repository;

    @BeforeEach
    void setUp() {
        handler = new CreateWorkoutHandler(repository);
    }


    @Test
    @DisplayName("Dupa")

    void shouldCreateWorkout_whenRequestIsOk() {



        //given
        final UUID id = UUID.randomUUID();
        final CreateWorkoutRequest request = new CreateWorkoutRequest("Katarzyna", new DurationDto(5L,"SECONDS"));

        //when
        handler.create(id,request);

        //then
        ArgumentCaptor<Workout> captor = ArgumentCaptor.forClass(Workout.class);
        verify(repository).save(captor.capture());
        assertEquals(id,captor.getValue().getId());
        assertEquals("Katarzyna",captor.getValue().getName());
        assertEquals(Duration.of(5L, ChronoUnit.SECONDS),captor.getValue().getDuration());

    }


}