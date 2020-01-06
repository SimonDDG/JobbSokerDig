package com.jbs.JobbSokerDig;

import com.jbs.JobbSokerDig.repositorys.Login;
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

        return "ok";
    }
}
