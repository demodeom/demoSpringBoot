package com.example.demo.ApiController;


import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloApiController {

    @GetMapping("/api/hello")
    public Map<String, Object> hello() {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "Hello Restfull Api");
        return res;
    }

    @GetMapping("/api/hi")
    public Map<String, Object> hi(
            @RequestParam(name = "name", defaultValue = "Tony") String name,
            @RequestParam(name = "age", defaultValue = "18") Integer age
    ) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "姓名：" + name + ", 年龄: " + age);
        return res;
    }

    @GetMapping("/api/user/{userId}")
    public Map<String, Object> user(
        @PathVariable(name = "userId", required = true) Integer userId
    ) {
        Map<String, Object> res = new HashMap<>();
        res.put("code", 0);
        res.put("message", "success");
        res.put("data", "id: " + userId);
        return res;
    }

}
