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
        User userToSave = new User();
    }

}
