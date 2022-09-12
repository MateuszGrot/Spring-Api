package pl.mateuszgrot.workoutapp.adapter.in;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class UuidWrapper {

  private UUID id;

}
