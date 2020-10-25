package pl.sda.final_project.model;


import pl.sda.final_project.dto.RegistrationDto;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity extends BaseEntity {

    private String firstName;
    private String lastName;

    @Embedded
    private Address address;

    private LocalDate birthDate;
    private String pesel;
    /**
     * login is an e-mail
     */
    private String login;
    private String password;
    private String phoneNumber;
    private boolean preferEmails;

    @ManyToMany
    private List<UserRole> roles;

    public static UserEntity apply(RegistrationDto registrationDto, String pswdHash){
        UserEntity user = new UserEntity();
        user.firstName = registrationDto.getFirstName();
        user.lastName = registrationDto.getLastName();
        user.login = registrationDto.getLogin();
        user.password = pswdHash;
        user.address = Address.apply(registrationDto);
        user.birthDate = LocalDate.parse(registrationDto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return user;
    }

    public void addRole(UserRole userRole) {
        if (roleExists(userRole)) {
            return;
        }
        if (roles == null) {
            roles = new ArrayList<>();
        }
        roles.add(userRole);
    }

    private boolean roleExists(UserRole userRole) {
        return roles != null && roles.stream()
                .anyMatch(r -> userRole.getRoleName().equals(r.getRoleName()));
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
