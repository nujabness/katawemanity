package com.nujabness.katawemanity.api.controller;

import com.nujabness.katawemanity.beans.request.ClientRequest;
import com.nujabness.katawemanity.beans.wrapper.Response;
import com.nujabness.katawemanity.services.UserService.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UpdateController {

	private static final Logger logger = LoggerFactory.getLogger(UpdateController.class);
	
	@Autowired
	private IUserService userService;

    @PostMapping("/update/client")
    public ResponseEntity<Response<Integer>> updateClients(@RequestBody ClientRequest clientRequest) {
        Response<Integer> response = new Response<Integer>();
        try {
            response.setResult(userService.updateClient(clientRequest));
            response.setMessage("Client mis à jour !");
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return ResponseEntity.ok(response);
    }
}
