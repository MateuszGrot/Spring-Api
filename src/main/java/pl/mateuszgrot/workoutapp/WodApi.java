package pl.mateuszgrot.workoutapp;

import org.springframework.web.bind.annotation.*;

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
    public boolean addWod(@RequestBody Workout workout) {
        return workouts.add(workout);
    }


    @DeleteMapping(path = "/{id}")
    public boolean deleteWod(@PathVariable("id") UUID id) {
        return workouts.removeIf(element -> element.getUuid() == id);
    }
}
