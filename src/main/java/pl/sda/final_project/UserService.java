package pl.sda.final_project;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registerUser(RegistrationDto registrationDto){
        String passwordHash = String.valueOf(registrationDto.getPassword().hashCode());
        if (userWithEmailExists(registrationDto.getLogin())){
            throw new RuntimeException("Użytkownik o emailu " + registrationDto.getLogin() + " istnieje");
        }
        User userToSave = User.apply(registrationDto, passwordHash);
        userRepo.save(userToSave);
    }

    private boolean userWithEmailExists(String login) {
        return userRepo.existsByLogin(login);
    }

}
