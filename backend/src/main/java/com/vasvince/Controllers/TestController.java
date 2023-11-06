package com.vasvince.Controllers;

import com.vasvince.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/votes/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String test(@PathVariable int id) {
        return "{\"id\": \"" + id + "\"}";
    }
}
