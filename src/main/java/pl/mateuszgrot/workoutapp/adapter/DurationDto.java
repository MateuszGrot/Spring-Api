package pl.mateuszgrot.workoutapp.adapter;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DurationDto {

  @NotNull
  private Long amount;
  @NotEmpty
  private String unit;

}
