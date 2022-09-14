package pl.mateuszgrot.workoutapp.adapter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DurationDto {

    @NotNull
    @Positive
    private Long amount;
    @NotEmpty
    private String unit;

}
