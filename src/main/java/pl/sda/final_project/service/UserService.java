package pl.sda.final_project.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.final_project.dto.UserDto;
import pl.sda.final_project.model.UserEntity;
import pl.sda.final_project.model.UserRole;
import pl.sda.final_project.dto.RegistrationDto;
import pl.sda.final_project.repository.UserRepo;
import pl.sda.final_project.repository.UserRoleRepo;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserRoleRepo userRoleRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, UserRoleRepo userRoleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userRoleRepo = userRoleRepo;
        this.passwordEncoder = passwordEncoder;
    }


    public void registerUser(RegistrationDto registrationDto) {
        String pass = passwordEncoder.encode(registrationDto.getPassword());
        if (userWithEmailExists(registrationDto.getLogin())) {
            throw new RuntimeException("Użytkownik o emailu " + registrationDto.getLogin() + "istnieje");
        }
        UserEntity userToSave = UserEntity.apply(registrationDto, pass);
        userToSave.addRole(userRoleRepo.findByRoleName(UserRole.Roles.USER.name()));
        userRepo.save(userToSave);
    }

    private boolean userWithEmailExists(String login) {
        return userRepo.existsByLogin(login);
    }

    public UserDto getCurrentUser(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByLogin(userName)
                .map(UserDto::apply)
                .orElseThrow(() -> new RuntimeException("Can't find user"));
    }
}
