package pl.mateuszgrot.workoutapp;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/wod")
public class WodApi {

    private List<Workout> workouts;

    public WodApi() {
        workouts = new ArrayList<>();
        workouts.add(new Workout(1L, "Fran", "3 min"));
        workouts.add(new Workout(2L, "Grace", "1 min"));
    }

    @GetMapping("/")
    public List<Workout> getAll() {
        return workouts;
    }

    @GetMapping(path = "/{id}")
    public Workout getById(@PathVariable("id") Long id) {

        return workouts.stream()
                .filter(element -> element.getId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Workout with ID = " + id + " not found"));
    }

}
