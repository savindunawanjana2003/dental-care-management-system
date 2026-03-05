package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Controller;

import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto.AuthDto;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto.SystemUserDto;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Service.Impl.AuthService;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Util.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 6:11 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */

@RestController
@RequestMapping("api/v1/dentalcare/auth")
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<APIResponse<String>> register(@RequestBody SystemUserDto systemUserDto) {
        System.out.println("=====================================");
        return ResponseEntity.status(201).body(new APIResponse<>(
                201,
                "User Register Sucsses fully..",
                authService.saveCustomer(systemUserDto)
        ));
    }

    @PostMapping("/login")
    public ResponseEntity<APIResponse<String>> login(@RequestBody AuthDto authDto) {

        return ResponseEntity.status(200).body(new APIResponse<>(
                200,
                "Login Succsess fully...",
                authService.authenticate(authDto)
        ));

    }

}
