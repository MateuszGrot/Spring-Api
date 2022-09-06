package pl.mateuszgrot.workoutapp;

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
@RequestMapping("/api/wod")
public class WodApi {

    private List<Workout> workouts;

    public WodApi() {
        workouts = new ArrayList<>();
    }

    @GetMapping("/")
    public List<Workout> getAll() {
        return workouts;
    }

    @GetMapping(path = "/{id}")
    public Workout getById(@PathVariable("id") UUID id) {

        return workouts.stream()
                .filter(element -> element.getUuid() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Workout with ID = " + id + " not found"));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addWorkout(@RequestBody @Validated CreateWorkoutRequest request) {
        workouts.add(new Workout(UUID.randomUUID(),
                request.getName(),
                Duration.of(request.getDuration().getAmount(),
                        ChronoUnit.valueOf(request.getDuration().getUnit()))));


    }


    @DeleteMapping(path = "/{id}")
    public boolean deleteWod(@PathVariable("id") UUID id) {
        return workouts.removeIf(element -> element.getUuid() == id);
    }
}
