package com.example.AppClinicaOdontologica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("password");
        String password2 = bCryptPasswordEncoder.encode("password2");

        userRepository.save(new AppUser("Armando Casas", "armanditocasitas", "armandocasas@digital.com", password, AppUsuarioRoles.ADMIN));
        userRepository.save(new AppUser("Jose Repelin Cucharas", "repelin", "repeliendo@digital.com", password2, AppUsuarioRoles.USER));
    }
}
