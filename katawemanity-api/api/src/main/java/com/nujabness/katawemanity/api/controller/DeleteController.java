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
public class DeleteController {

	private static final Logger logger = LoggerFactory.getLogger(DeleteController.class);
	
	@Autowired
	private IUserService userService;

    @PostMapping("/delete/client")
    public ResponseEntity<Response<Integer>> deleteClients(@RequestBody ClientRequest clientRequest) {
        Response<Integer> response = new Response<Integer>();
        try {
            response.setResult(userService.deleteClient(clientRequest));
            response.setMessage("Client supprimé !");
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return ResponseEntity.ok(response);
    }
}
