package pl.sda.final_project.service;

import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;
import pl.sda.final_project.model.ResetPasswordEntity;
import pl.sda.final_project.model.UserEntity;
import pl.sda.final_project.repository.ResetPasswordRepo;

import java.time.LocalDateTime;

@Service
public class ResetPasswordService {

    private final ResetPasswordRepo resetPasswordRepo;
    private final MessageService messageService;

    public ResetPasswordService(ResetPasswordRepo resetPasswordRepo, MessageService messageService) {
        this.resetPasswordRepo = resetPasswordRepo;
        this.messageService = messageService;
    }

    public void saveResetPasswordEntry(UserEntity user){
        String token = new RandomString(60).nextString();
        LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(10);
        ResetPasswordEntity resetPasswordEntity = new ResetPasswordEntity();
        resetPasswordEntity.setToken(token);
        resetPasswordEntity.setExpiryDate(expiryTime);
        resetPasswordEntity.setUsed(false);
        resetPasswordEntity.setUser(user);

        resetPasswordRepo.save(resetPasswordEntity);

        messageService.sendResetMail(token, user.getLogin());
    }

    public UserEntity findUserByToken(String token) {
       return resetPasswordRepo.findByToken(token)
                .map(ResetPasswordEntity::getUser).orElseThrow(
                        () -> new RuntimeException("Token does not exist"));
        //TODO check if token valid
    }
}
