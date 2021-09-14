package com.nujabness.katawemanity.services.UserService.impl;

import com.nujabness.katawemanity.data.dao.IUserRepository;
import com.nujabness.katawemanity.services.UserService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private EntityManager entityManager;


  public void getAllClient() throws Exception {}
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
  public void insertUser() throws Exception {}
  public void insertClient() throws Exception {}
}
