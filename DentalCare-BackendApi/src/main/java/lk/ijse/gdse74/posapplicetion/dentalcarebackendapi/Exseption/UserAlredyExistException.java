package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Exseption;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 11:02 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */
public class UserAlredyExistException extends RuntimeException {
    public UserAlredyExistException(String message) {
        super(message);
    }
}
