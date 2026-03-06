package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Service.Impl;

import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto.AuthDto;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Dto.SystemUserDto;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Entyty.SystemUserEntity;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Entyty.enums.SystemUserRole;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Exseption.UserAlredyExistException;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Repositry.SystemUserRepoSitory;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Service.Authservice;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Util.APIResponse;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Util.Jwrutil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 6:10 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */
@Service
@RequiredArgsConstructor
public class AuthService implements Authservice {
    private final SystemUserRepoSitory userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Jwrutil Jwrutil;

    @Override
    public String saveCustomer(SystemUserDto systemUserDto) {

        java.util.Optional<SystemUserEntity> releventUser1 = userRepository.findByEmail(systemUserDto.getEmail());
        java.util.Optional<SystemUserEntity> releventUser2 = userRepository.findByNicNumber(systemUserDto.getNicNumber());
        java.util.Optional<SystemUserEntity> releventUser3 = userRepository.findByusername(systemUserDto.getUsername());
        java.util.Optional<SystemUserEntity> releventUser4 = userRepository.findByphoneNumber(systemUserDto.getPhoneNumber());

        if (releventUser1.isPresent()) {
            throw new UserAlredyExistException("This Email already Exist try with Difarent Email");
        } else if (releventUser2.isPresent()) {
            throw new UserAlredyExistException("This NIC Number already Exist try with Difarent NIC Number");
        } else if (releventUser3.isPresent()) {
            throw new UserAlredyExistException("This Username already Exist try with Difarent Username");
        } else if (releventUser4.isPresent()) {
            throw new UserAlredyExistException("This Phone Number already Exist try with Difarent Phone Number");
        }


        SystemUserEntity userEntity = SystemUserEntity.builder()
                .username(systemUserDto.getUsername())
                .password(passwordEncoder.encode(systemUserDto.getPassword()))
                .role(SystemUserRole.valueOf(systemUserDto.getRole()))
                .nicNumber(systemUserDto.getNicNumber())
                .phoneNumber(systemUserDto.getPhoneNumber())
                .email(systemUserDto.getEmail())
                .createdAt(systemUserDto.getCreatedAt())
                .updatedAt(systemUserDto.getUpdatedAt()).build();

        userRepository.save(userEntity);

        return "Suceessfully Register 🙂 ";
    }

    @Override
    public String updateCustomer(SystemUserDto systemUserDto) {
        return "";
    }

    @Override
    public String delete(SystemUserDto systemUserDto) {
        return "";
    }


    public String authenticate(AuthDto authDto) {
        SystemUserEntity user = userRepository.findByusername(authDto.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("Username not found"));
        if (!passwordEncoder.matches(authDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Wrong password");
        }
//        -===============================
        String token = Jwrutil.genaretTocken(authDto.getUsername());
        System.out.println("=======================");
        System.out.println(token);
        System.out.println("------------------");
        return token;
    }
}
