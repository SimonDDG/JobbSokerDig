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
