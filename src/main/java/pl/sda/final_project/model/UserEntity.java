package pl.sda.final_project.model;


import pl.sda.final_project.dto.RegistrationDto;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UserEntity extends BaseEntity {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @Embedded
    private Address address;

    private LocalDate birthDate;
    private String pesel;

    @NotNull
    @Email
    private String login;
    @NotNull
    private String password;
    @Pattern(regexp = "[0-9]{9}", message = "you have to write 9 digits")
    private String phoneNumber;
    private boolean preferEmails;

    @ManyToMany
    private List<UserRole> roles;

    public UserEntity(String firstName, String lastName, String login, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public UserEntity() {
    }

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

    public boolean roleExists(UserRole userRole) {
        return roles != null && roles.stream()
                .anyMatch(r -> userRole.getRoleName().equals(r.getRoleName()));
    }

    public void clean(){
        roles.clear();
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
