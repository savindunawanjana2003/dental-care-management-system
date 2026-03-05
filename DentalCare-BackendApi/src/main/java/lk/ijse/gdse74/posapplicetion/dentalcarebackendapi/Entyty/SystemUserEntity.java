package lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Entyty;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lk.ijse.gdse74.posapplicetion.dentalcarebackendapi.Entyty.enums.SystemUserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * --------------------------------------------
 * Author: Savindu Nawanjana
 * --------------------------------------------
 * Created: 3/3/26 4:59 PM
 * Project: DentalCare-BackendApi
 * --------------------------------------------
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "system_users")
public class SystemUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private SystemUserRole role;

    @Column(nullable = false)
    private String nicNumber;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;
    private String createdAt;
    private String updatedAt;
}
