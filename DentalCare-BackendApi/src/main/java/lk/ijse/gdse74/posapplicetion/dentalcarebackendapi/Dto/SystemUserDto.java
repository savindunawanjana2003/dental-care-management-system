package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 5:49 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemUserDto {

    private Long userId;
    private String username;
    private String password;
    private String role;
    private String phoneNumber;
    private String nicNumber;
    private String email;
    private String createdAt;
    private String updatedAt;
}
