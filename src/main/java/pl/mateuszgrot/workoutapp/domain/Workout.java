package pl.mateuszgrot.workoutapp.domain;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document
public class Workout {

  @Id
  private UUID id;
  private String name;
  private Duration duration;

}
