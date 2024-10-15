package Rastek_fix.demo.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class DivisionReq {

    private String division_name;

    private Long departement_id;
}
