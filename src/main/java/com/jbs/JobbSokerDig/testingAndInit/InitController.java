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

        Login loginGoogle = loginRepository.findByUsername("google");
        if (loginGoogle == null) {
            loginGoogle = new Login();
            loginGoogle.setUsername("google");
            loginGoogle.setPassword(encoder.encode("asd"));
            loginGoogle.setRole("COMPANY");
            loginRepository.save(loginGoogle);
        }

        Login loginApple = loginRepository.findByUsername("apple");
        if (loginApple == null) {
            loginApple = new Login();
            loginApple.setUsername("apple");
            loginApple.setPassword(encoder.encode("asd"));
            loginApple.setRole("COMPANY");
            loginRepository.save(loginApple);
        }

        Login loginuser4 = loginRepository.findByUsername("user4");
        if (loginuser4 == null) {
            loginuser4 = new Login();
            loginuser4.setUsername("user4");
            loginuser4.setPassword(encoder.encode("asd"));
            loginuser4.setRole("USER");
            loginRepository.save(loginuser4);
        }

        Login loginuser5 = loginRepository.findByUsername("user5");
        if (loginuser5 == null) {
            loginuser5 = new Login();
            loginuser5.setUsername("user5");
            loginuser5.setPassword(encoder.encode("asd"));
            loginuser5.setRole("USER");
            loginRepository.save(loginuser5);
        }

        Login loginuser6 = loginRepository.findByUsername("user6");
        if (loginuser6 == null) {
            loginuser6 = new Login();
            loginuser6.setUsername("user6");
            loginuser6.setPassword(encoder.encode("asd"));
            loginuser6.setRole("USER");
            loginRepository.save(loginuser6);
        }

        Login loginuser7 = loginRepository.findByUsername("user7");
        if (loginuser7 == null) {
            loginuser7 = new Login();
            loginuser7.setUsername("user7");
            loginuser7.setPassword(encoder.encode("asd"));
            loginuser7.setRole("USER");
            loginRepository.save(loginuser7);
        }

        Login loginuser8 = loginRepository.findByUsername("user8");
        if (loginuser8 == null) {
            loginuser8 = new Login();
            loginuser8.setUsername("user8");
            loginuser8.setPassword(encoder.encode("asd"));
            loginuser8.setRole("USER");
            loginRepository.save(loginuser8);
        }

        Login loginuser9 = loginRepository.findByUsername("user9");
        if (loginuser9 == null) {
            loginuser9 = new Login();
            loginuser9.setUsername("user9");
            loginuser9.setPassword(encoder.encode("asd"));
            loginuser9.setRole("USER");
            loginRepository.save(loginuser9);
        }

        Login loginuser10 = loginRepository.findByUsername("user10");
        if (loginuser10 == null) {
            loginuser10 = new Login();
            loginuser10.setUsername("user10");
            loginuser10.setPassword(encoder.encode("asd"));
            loginuser10.setRole("USER");
            loginRepository.save(loginuser10);
        }

        return "ok";
    }
}
