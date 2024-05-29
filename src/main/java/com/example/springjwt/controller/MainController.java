package com.example.springjwt.controller;

import com.example.springjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody   //view 말고 String 값 리턴을 위해
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public String mainP(){
        return "Main Controller";
    }
}
