package com.vasvince.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestServiceTests {

    @Test
    public void test() {
        int testNumber = 1;
        Assertions.assertEquals(1, testNumber);
    }
}
