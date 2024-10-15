package Rastek_fix.demo.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class DepartementRes {

    private Long id;

    private String departement_name;

    private String departement_head;

}
