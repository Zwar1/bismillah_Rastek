package Rastek_fix.demo.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class SubDivisionRes {

    private Long id;

    private String subDivision_name;

    private DivisionRes division;
}
