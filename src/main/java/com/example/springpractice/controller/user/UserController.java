package com.example.springpractice.controller.user;

import com.example.springpractice.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return user.toString();
    }
}
