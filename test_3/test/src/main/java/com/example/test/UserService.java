package com.example.test;

import com.example.test.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;
    private final EmailService emailService;
    private final PasswordEncoder passwordEncoder;
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public UserService(UserDao userDao, EmailService emailService, PasswordEncoder passwordEncoder, PasswordResetTokenRepository passwordResetTokenRepository) {
        this.userDao = userDao;
        this.emailService = emailService;
        this.passwordEncoder = passwordEncoder;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    public User registerNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    public void initiatePasswordReset(String email) {
        User user = userDao.findByEmail(email);
        if (user != null) {
            String token = UUID.randomUUID().toString();

            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setToken(token);
            passwordResetToken.setUser(user);
            passwordResetTokenRepository.save(passwordResetToken);

            emailService.sendSimpleMessage(
                    email,
                    "비밀번호를 재설정 하세요",
                    "링크에 접속한 뒤 비밀번호를 접속하세요: " +
                            "http://yourdomain.com/reset?token=" + token // 이 URL은 예시입니다. 실제 애플리케이션에 맞게 수정하세요.
            );
        }
    }
}