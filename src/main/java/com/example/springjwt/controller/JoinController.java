package com.example.springjwt.controller;

import com.example.springjwt.dto.CustomUserDetails;
import com.example.springjwt.dto.JoinDTO;
import com.example.springjwt.entity.UserEntity;
import com.example.springjwt.service.JoinService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequiredArgsConstructor
@Slf4j
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/admin/join")
    public String joinProcess(JoinDTO joinDTO){
        joinService.joinProcess(joinDTO);
        return "ok";
    }

    @PostMapping("/user/join")
    public String userJoinProcess(JoinDTO joinDTO){
        joinService.userJoinProcess(joinDTO);
        return "ok";
    }

    @PostMapping("/auth")
    public String authProcess(@RequestHeader("Authorization") String authorizationHeader){
        return "ok";
    }

    @RequestMapping(value =  "/auth2", method = RequestMethod.POST)
    public String auth2Process(@AuthenticationPrincipal CustomUserDetails user){
        String name = user.getUsername();
        log.info("user.getName = {}", name);
        return name;
    }


}
