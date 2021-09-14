package com.nujabness.katawemanity.services.UserService;

public interface IUserService {
    void getAllClient() throws Exception;
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
    void insertUser() throws Exception;
    void insertClient() throws Exception;

}
