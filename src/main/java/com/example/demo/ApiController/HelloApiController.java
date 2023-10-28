package com.example.demo.ApiController;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloApiController {

    @GetMapping("/api/hello")
    public Map<String, Object> hello()
    {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "Hello Restfull Api");
        return res;
    }

}
