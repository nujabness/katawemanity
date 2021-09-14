package com.nujabness.katawemanity.services.UserService;

import com.nujabness.katawemanity.beans.commons.AchatBean;
import com.nujabness.katawemanity.beans.commons.ClientBean;
import com.nujabness.katawemanity.beans.commons.ProduitBean;
import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.beans.request.ClientRequest;
import com.nujabness.katawemanity.beans.request.RegisterRequest;

import java.util.List;

public interface IUserService {
    List<ClientBean> getAllClient() throws Exception;
    List<ProduitBean> getAllProduit() throws Exception;
    List<AchatBean> getAllAchat() throws Exception;

    Integer deleteClient(ClientRequest clientRequest) throws Exception;
    Integer updateClient(ClientRequest clientRequest) throws Exception;

    UserBean insertUser(RegisterRequest registerRequest) throws Exception;
}
