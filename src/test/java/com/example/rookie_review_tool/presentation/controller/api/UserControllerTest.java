package com.example.rookie_review_tool.presentation.controller.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    UserController userController;

    @Test
    @DisplayName("hello_正常ケース")
    void case_1() {

        // Given
        String expected = "ログイン成功";

        // When
        String actual = userController.hello();

        // Then
        assertEquals( expected, actual );
    }
}
