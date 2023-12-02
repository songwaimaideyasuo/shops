package com.w.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SessionController {

    @GetMapping("/create-session")
    public String createSession(HttpSession session) {
        session.setAttribute("username", "JohnDoe");
        return "Session created.";
    }

    @GetMapping("/get-session")
    public String getSession(HttpSession session) {
        String username = (String) session.getAttribute("username");
        return "Username: " + username;
    }

}
