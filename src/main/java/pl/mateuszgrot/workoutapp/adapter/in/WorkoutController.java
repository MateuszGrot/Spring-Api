package pl.mateuszgrot.workoutapp.adapter.in;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.mateuszgrot.workoutapp.domain.CreateWorkoutHandler;
import pl.mateuszgrot.workoutapp.infrastructure.db.WorkoutRepository;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/workouts")
@RequiredArgsConstructor
public class WorkoutController {

    private final WorkoutResponseMapper mapper;
    private final WorkoutRepository workoutRepository;
    private final CreateWorkoutHandler createWorkoutHandler;

    @GetMapping("/")
    public List<WorkoutResponse> getAll() {
        return workoutRepository.findAll().stream()
            .map(mapper::map)
            .collect(Collectors.toList());
    }


    @GetMapping(path = "/{id}")
    public WorkoutResponse getById(@PathVariable("id") UUID id) {

        return workoutRepository.findById(id)
            .map(mapper::map)
            .orElseThrow(
                () -> new NoSuchElementException("Workout with ID = " + id + " not found"));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UuidWrapper addWorkout(@RequestBody @Validated CreateWorkoutRequest request) {
        final UUID id = UUID.randomUUID();
        createWorkoutHandler.create(id, request);

        return UuidWrapper.of(id);
    }


    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteWorkout(@PathVariable("id") UUID id) {
        workoutRepository.deleteById(id);
    }
}
