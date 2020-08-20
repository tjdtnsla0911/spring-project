package com.cos.jwtex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JspController {
@GetMapping("/jsp")
public String jsp() {
 return "hello";
}
@GetMapping("/auth/loginForm")
public String loginForm() {
	System.out.println("로그인을거쳤다");
	return "user/loginForm";
}
@GetMapping("/auth/joinForm")
public String join() {
	System.out.println("회원가입을거쳤다");
	return "user/joinForm";
}

}
