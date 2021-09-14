package com.nujabness.katawemanity.api.controller;


import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.beans.request.LoginRequest;
import com.nujabness.katawemanity.beans.request.RegisterRequest;
import com.nujabness.katawemanity.beans.wrapper.Response;
import com.nujabness.katawemanity.data.entity.User;
import com.nujabness.katawemanity.services.UserService.IUserService;
import com.nujabness.katawemanity.services.authentification.AuthenticationProvider;
import com.nujabness.katawemanity.services.authentification.CustomUsernamePasswordAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	private IUserService userService;

    @Autowired
    AuthenticationProvider authenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<Response<CustomUsernamePasswordAuthenticationToken>> login(@RequestBody LoginRequest loginBeanRequest) {
        Response<CustomUsernamePasswordAuthenticationToken> response = new Response<>();
        response.setResult(authenticationProvider.authenticate(loginBeanRequest));
        response.setSuccess(true);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<Response<UserBean>> register(@RequestBody RegisterRequest registerRequest) {
      Response<UserBean> response = new Response<>();
      try{
          response.setResult(userService.insertUser(registerRequest));
          response.setSuccess(true);
      }catch (Exception e){
          response.setSuccess(false);
          response.setMessage(e.getMessage());
      }
      return ResponseEntity.ok(response);
    }
}
