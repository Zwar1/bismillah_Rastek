package Rastek_fix.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class UpdateSubDivisionReq {

    @JsonIgnore
    @NotBlank
    private Long id;

    private String subDivision_name;

}
