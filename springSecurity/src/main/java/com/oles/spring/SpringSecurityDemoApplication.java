package com.oles.spring;

import com.oles.spring.model.Role;
import com.oles.spring.model.Status;
import com.oles.spring.model.User;
import com.oles.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
class SpringSecurityDemoApplication {

    public static void main(String[] args) {





        SpringApplication.run(SpringSecurityDemoApplication.class,args);
    }

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
            ;
    User user = new User("Ivan@com","Ivan","Ivanovich",passwordEncoder.encode("oles"), Role.ADMIN, Status.ACTIVE);

    UserRepository repository ;
@Autowired
    public SpringSecurityDemoApplication(UserRepository repository) {
        this.repository = repository;

    System.out.println( repository.findByEmail("admin@email.com"));
    repository.save(user);

    }
}
