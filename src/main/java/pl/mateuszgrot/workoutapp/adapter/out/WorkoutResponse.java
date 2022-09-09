package pl.mateuszgrot.workoutapp.adapter.out;

import java.time.Duration;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WorkoutResponse {

  private UUID id;
  private String name;
  private Duration duration;

}
