package com.example.demo.webController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/web/hello")
    @ResponseBody
    public String hello()
    {
        return "<h1>Hello Web Controller</h1>";
    }

}
