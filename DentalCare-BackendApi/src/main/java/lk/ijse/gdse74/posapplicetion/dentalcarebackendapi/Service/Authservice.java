package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Service;

import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto.SystemUserDto;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 6:09 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */
public interface Authservice {
    String saveCustomer(SystemUserDto systemUserDto);

    String updateCustomer(SystemUserDto systemUserDto);

    String delete(SystemUserDto systemUserDto);



}
