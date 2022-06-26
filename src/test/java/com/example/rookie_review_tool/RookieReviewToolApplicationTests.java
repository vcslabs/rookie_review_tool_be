package com.example.rookie_review_tool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RookieReviewToolApplicationTests {

    @Test
    void check() {
        final String expected = "hello";
        final String actual = "hello";

        Assertions.assertEquals(expected, actual);
    }

}
