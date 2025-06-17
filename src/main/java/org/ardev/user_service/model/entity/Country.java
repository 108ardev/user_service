package org.ardev.user_service.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "title", length = 64, nullable = false, unique = true)
    private String title;

    @OneToMany(mappedBy = "country")
    private List<User> residents;
}
