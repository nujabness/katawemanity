package com.nujabness.katawemanity.api.controller;


import com.nujabness.katawemanity.services.UserService.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/security")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login() {
      return null;
    }

    @PostMapping("/register")
    public ResponseEntity<?> signin() {
      return null;
    }
}
