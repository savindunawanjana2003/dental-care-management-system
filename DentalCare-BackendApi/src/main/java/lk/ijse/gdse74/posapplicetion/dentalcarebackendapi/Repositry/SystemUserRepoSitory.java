package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Repositry;

import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Entyty.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.Optional;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 5:11 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */
@Repository
public interface SystemUserRepoSitory extends JpaRepository<SystemUserEntity, Long> {
    Optional<SystemUserEntity> findByusername(String username);
    Optional<SystemUserEntity> findByEmail(String email);
    Optional<SystemUserEntity>  findByNicNumber(String nicNumber);
    Optional<SystemUserEntity>  findByphoneNumber(String phoneNumber);

}
