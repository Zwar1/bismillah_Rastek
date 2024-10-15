package Rastek_fix.demo.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class DivisionRes {

    private Long id;

    private String division_name;

    private DepartementRes departement;
}
