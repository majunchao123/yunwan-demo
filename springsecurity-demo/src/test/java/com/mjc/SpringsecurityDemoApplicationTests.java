package com.mjc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SpringsecurityDemoApplicationTests {

    @Test
    public void test01() {
        PasswordEncoder pw = new BCryptPasswordEncoder();

        String encode = pw.encode("123456");
        System.out.println(encode);
//        boolean matches = pw.matches("123456", "$2a$10$qXxkoZtkTQV2ryVZUvrC9.Iq9zxg5/sEHJhcFFK9BQ6Qt8xkIEgRi");
//        System.out.println(matches);


    }

}
