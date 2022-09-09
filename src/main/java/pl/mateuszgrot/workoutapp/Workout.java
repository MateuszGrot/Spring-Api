package pl.mateuszgrot.workoutapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Workout {

<<<<<<< HEAD
  private UUID uuid = UUID.randomUUID();
=======
  private UUID id;
>>>>>>> improvements
  private String name;
  private Duration duration;

}
