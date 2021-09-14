package com.nujabness.katawemanity.services.UserService;

import com.nujabness.katawemanity.beans.commons.ClientBean;
import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.beans.request.RegisterRequest;

import java.util.List;

public interface IUserService {
    List<ClientBean> getAllClient() throws Exception;
    void getAllProduit() throws Exception;
    void getAllAchat() throws Exception;

    void deleteProduit() throws Exception;
    void deleteClient() throws Exception;
    void deleteAchat() throws Exception;


    void updateProduit() throws Exception;
    void updateAchat() throws Exception;
    void updateClient() throws Exception;
    void updateUser() throws Exception;

    void getClient() throws Exception;
    void getProduit() throws Exception;

    void insertAchat() throws Exception;
    UserBean insertUser(RegisterRequest registerRequest) throws Exception;
    void insertClient() throws Exception;

}
