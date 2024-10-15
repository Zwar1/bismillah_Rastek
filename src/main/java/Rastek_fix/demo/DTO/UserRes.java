package Rastek_fix.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRes {

    private String username;
    private String email;
    private Date created_at;
    private Date updated_at;
    private String created_by;
    private String updated_by;

    public String getUpdated_by() {
        if (updated_by == null) {
            return updated_by = "There is no update yet";
        }
        return updated_by;
    }

}
