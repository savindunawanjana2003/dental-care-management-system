package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/4/26 3:15 AM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthDto {
    private String username;
    private String password;
}
