package Rastek_fix.demo.DTO;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SubDivisionReq {

    private String subDivision_name;

    private Long division_id;
}
