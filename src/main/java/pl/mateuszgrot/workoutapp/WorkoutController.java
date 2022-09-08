package pl.mateuszgrot.workoutapp;

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

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

  private List<Workout> workouts;

  public WorkoutController() {
    workouts = new ArrayList<>();
  }

  @GetMapping("/")
  public List<WorkoutResponse> getAll() {
    return workouts.stream()
        .map(w -> new WorkoutResponse(w.getId(), w.getName(), w.getDuration()))
        .collect(Collectors.toList());
  }

  @GetMapping(path = "/{id}")
  public Workout getById(@PathVariable("id") UUID id) {
    return workouts.stream()
        .filter(element -> element.getId() == id)
        .findFirst()
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
  public boolean deleteWorkout(@PathVariable("id") UUID id) {
    return workouts.removeIf(element -> element.getId() == id);
  }
}
