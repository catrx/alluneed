package com.project.alluneed;

import static org.assertj.core.api.Assertions.assertThat;
import com.project.alluneed.controller.LoginController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class AlluneedApplicationTests {

    @Autowired
    private LoginController controller;


    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
