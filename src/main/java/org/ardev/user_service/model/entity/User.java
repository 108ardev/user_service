package org.ardev.user_service.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    @Column(name = "email", length = 64, nullable = false, unique = true)
    private String email;

    @Column(name = "phone", length = 64, nullable = false, unique = true)
    private String phone;

    @Column(name = "about_me", length = 4096)
    private String aboutMe;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "city", length = 64)
    private String city;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @CreationTimestamp
    @Temporal(TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Temporal(TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
