package com.nujabness.katawemanity.api.controller;


import com.nujabness.katawemanity.beans.commons.AchatBean;
import com.nujabness.katawemanity.beans.commons.ClientBean;
import com.nujabness.katawemanity.beans.commons.ProduitBean;
import com.nujabness.katawemanity.beans.wrapper.Response;
import com.nujabness.katawemanity.services.UserService.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SelectController {

	private static final Logger logger = LoggerFactory.getLogger(SelectController.class);
	
	@Autowired
	private IUserService userService;

    @PostMapping("/clients")
    public ResponseEntity<Response<List<ClientBean>>> getClients() {
        Response<List<ClientBean>> response = new Response<List<ClientBean>>();
        try {
            response.setResult(userService.getAllClient());
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/produits")
    public ResponseEntity<Response<List<ProduitBean>>> getProduits() {
        Response<List<ProduitBean>> response = new Response<List<ProduitBean>>();
        try {
            response.setResult(userService.getAllProduit());
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/achats")
    public ResponseEntity<Response<List<AchatBean>>> getAchats() {
        Response<List<AchatBean>> response = new Response<List<AchatBean>>();
        try {
            response.setResult(userService.getAllAchat());
            response.setSuccess(true);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setSuccess(false);
        }
        return ResponseEntity.ok(response);
    }
}
