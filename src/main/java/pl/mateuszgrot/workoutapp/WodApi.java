package pl.mateuszgrot.workoutapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/wod")
public class WodApi {

    private List<Workout> workouts;

    public WodApi(){
        workouts = new ArrayList<>();
        workouts.add(new Workout(1L,"Fran","3 min"));
        workouts.add(new Workout(2L,"Grace","1 min"));
    }

    @GetMapping("/all")
    public List<Workout> getAll(){
        return workouts;
    }

    @GetMapping
    public Workout getById(@RequestParam int index){
        Optional<Workout> first = workouts.stream().filter(element -> element.getId() == index).findFirst();
    return first.get();
    }

}
