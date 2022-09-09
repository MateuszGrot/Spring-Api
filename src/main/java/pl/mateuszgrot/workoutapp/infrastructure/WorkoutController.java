package pl.mateuszgrot.workoutapp.infrastructure;

import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import pl.mateuszgrot.workoutapp.adapter.in.CreateWorkoutRequest;
import pl.mateuszgrot.workoutapp.adapter.out.UuidWrapper;
import pl.mateuszgrot.workoutapp.adapter.out.WorkoutResponse;
import pl.mateuszgrot.workoutapp.adapter.out.WorkoutResponseMapper;
import pl.mateuszgrot.workoutapp.domain.Workout;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

  private final WorkoutResponseMapper mapper;
  private List<Workout> workouts;

  public WorkoutController(
      final WorkoutResponseMapper mapper
  ) {
    workouts = new ArrayList<>();
    this.mapper = mapper;
  }

  @GetMapping("/")
  public List<WorkoutResponse> getAll() {
    return workouts.stream()
        .map(mapper::map)
        .collect(Collectors.toList());
  }


  @GetMapping(path = "/{id}")
  public WorkoutResponse getById(@PathVariable("id") UUID id) {

    return workouts.stream()
        .filter(element -> element.getId() == id)
        .findFirst()
        .map(mapper::map)
        .orElseThrow(() -> new NoSuchElementException("Workout with ID = " + id + " not found"));
  }

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public UuidWrapper addWorkout(@RequestBody @Validated CreateWorkoutRequest request) {
    final UUID id = UUID.randomUUID();
    workouts.add(new Workout(id,
        request.getName(),
        Duration.of(request.getDuration().getAmount(),
            ChronoUnit.valueOf(request.getDuration().getUnit()))));

    return UuidWrapper.of(id);
  }


  @DeleteMapping(path = "/{id}")
  @ResponseStatus(code = HttpStatus.NO_CONTENT)
  public void deleteWorkout(@PathVariable("id") UUID id) {
    workouts.removeIf(element -> element.getId() == id);
  }
}
