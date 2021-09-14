package com.nujabness.katawemanity.services.UserService.impl;

import com.nujabness.katawemanity.beans.commons.ClientBean;
import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.beans.request.RegisterRequest;
import com.nujabness.katawemanity.data.dao.IClientRepository;
import com.nujabness.katawemanity.data.dao.IUserRepository;
import com.nujabness.katawemanity.data.entity.Client;
import com.nujabness.katawemanity.data.entity.User;
import com.nujabness.katawemanity.services.UserService.IUserService;
import com.nujabness.katawemanity.services.adapter.ClientBeanServiceAdapter;
import com.nujabness.katawemanity.services.adapter.UserBeanServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired  private IUserRepository userRepository;
  @Autowired private IClientRepository clientRepository;

  @Autowired
  private EntityManager entityManager;

  public UserBean insertUser(RegisterRequest request) throws Exception {
    User user = new User();

    user.setNom(request.getNom());
    user.setPrenom(request.getPrenom());
    user.setPassword(request.getPassword());
    user.setEmail(request.getEmail());

    userRepository.saveAndFlush(user);
    return UserBeanServiceAdapter.transformToUserBeanService(user);
  }

  public List<ClientBean> getAllClient() throws Exception {
      List<Client> clients = clientRepository.findAllClient();
      return clients.stream().map(ClientBeanServiceAdapter::transformToClientBeanService).collect(Collectors.toList());
  }

  public void getAllProduit() throws Exception {}

  public void getAllAchat() throws Exception {}
  public void deleteProduit() throws Exception {}
  public void deleteClient() throws Exception {}

  public void deleteAchat() throws Exception {}

  public void updateProduit() throws Exception {}
  public void updateAchat() throws Exception {}
  public void updateClient() throws Exception {}

  public void updateUser() throws Exception {}
  public void getClient() throws Exception {}

  public void getProduit() throws Exception {}

  public void insertAchat() throws Exception {}
  public void insertClient() throws Exception {}
}
