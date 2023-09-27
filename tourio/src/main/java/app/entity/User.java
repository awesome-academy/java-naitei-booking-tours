package app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    public enum Gender {
        MALE, FEMALE
    }

    public enum Role {
        USER, ADMIN
    }

    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    private String fullname;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date birthday;
    @Column(name = "living_city")
    private String livingCity;
    @Column(nullable = false, unique = true)
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(nullable = false)
    private String password;
}
