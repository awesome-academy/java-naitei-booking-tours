package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {

    enum Gender {
        MALE, FEMALE
    }

    enum Role {
        USER, ADMIN
    }

    @Id
    private Long id;
    private String fullname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date birthday;
    @Column(name = "living_city")
    private String livingCity;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
}
