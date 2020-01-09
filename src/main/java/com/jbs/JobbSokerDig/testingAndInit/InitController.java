package com.jbs.JobbSokerDig.testingAndInit;

import com.jbs.JobbSokerDig.general.Login;
import com.jbs.JobbSokerDig.repositorys.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/init")
    public String init(){
        Login login = loginRepository.findByUsername("testuser");
        if (login == null) {
            login = new Login();
            login.setUsername("testuser");
            login.setPassword(encoder.encode("123"));
            loginRepository.save(login);
        }

        Login loginUser = loginRepository.findByUsername("user");
        if (loginUser == null) {
            loginUser = new Login();
            loginUser.setUsername("user");
            loginUser.setPassword(encoder.encode("asd"));
            loginUser.setRole("USER");
            loginRepository.save(loginUser);
        }

        Login loginUser2 = loginRepository.findByUsername("user2");
        if (loginUser2 == null) {
            loginUser2 = new Login();
            loginUser2.setUsername("user2");
            loginUser2.setPassword(encoder.encode("asd"));
            loginUser2.setRole("USER");
            loginRepository.save(loginUser2);
        }

        Login loginUser3 = loginRepository.findByUsername("user3");
        if (loginUser3 == null) {
            loginUser3 = new Login();
            loginUser3.setUsername("user3");
            loginUser3.setPassword(encoder.encode("asd"));
            loginUser3.setRole("USER");
            loginRepository.save(loginUser3);
        }

        Login loginCompany = loginRepository.findByUsername("company");
        if (loginCompany == null) {
            loginCompany = new Login();
            loginCompany.setUsername("company");
            loginCompany.setPassword(encoder.encode("asd"));
            loginCompany.setRole("COMPANY");
            loginRepository.save(loginCompany);
        }

        return "ok";
    }
}
