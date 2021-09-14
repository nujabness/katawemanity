package com.nujabness.katawemanity.services.UserService.impl;

import com.nujabness.katawemanity.beans.commons.AchatBean;
import com.nujabness.katawemanity.beans.commons.ClientBean;
import com.nujabness.katawemanity.beans.commons.ProduitBean;
import com.nujabness.katawemanity.beans.commons.UserBean;
import com.nujabness.katawemanity.beans.request.ClientRequest;
import com.nujabness.katawemanity.beans.request.RegisterRequest;
import com.nujabness.katawemanity.data.dao.IAchatRepository;
import com.nujabness.katawemanity.data.dao.IClientRepository;
import com.nujabness.katawemanity.data.dao.IProduitRepository;
import com.nujabness.katawemanity.data.dao.IUserRepository;
import com.nujabness.katawemanity.data.entity.Achat;
import com.nujabness.katawemanity.data.entity.Client;
import com.nujabness.katawemanity.data.entity.Produit;
import com.nujabness.katawemanity.data.entity.User;
import com.nujabness.katawemanity.services.UserService.IUserService;
import com.nujabness.katawemanity.services.adapter.AchatBeanServiceAdapter;
import com.nujabness.katawemanity.services.adapter.ClientBeanServiceAdapter;
import com.nujabness.katawemanity.services.adapter.ProduitBeanServiceAdapter;
import com.nujabness.katawemanity.services.adapter.UserBeanServiceAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

  @Autowired  private IUserRepository userRepository;
  @Autowired private IClientRepository clientRepository;
  @Autowired private IProduitRepository produitRepository;
  @Autowired private IAchatRepository achatRepository;

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

  public List<ProduitBean> getAllProduit() throws Exception {
    List<Produit> produits = produitRepository.findAllProduit();
    return produits.stream().map(ProduitBeanServiceAdapter::transformToProduitBeanService).collect(Collectors.toList());
  }

  public List<AchatBean> getAllAchat() throws Exception {
    List<Achat> achats = achatRepository.findAllAchat();
    return achats.stream().map(AchatBeanServiceAdapter::transformToAchatBeanService).collect(Collectors.toList());

  }


  public Integer deleteClient(ClientRequest clientRequest) throws Exception {
    return clientRepository.deleteClientByIdentifiant(clientRequest.getId());
  }


  public Integer updateClient(ClientRequest clientRequest) throws Exception {
    return clientRepository.updateClientByIdentifiant(clientRequest.getId(),clientRequest.getNom(),clientRequest.getPrenom(),clientRequest.getAdresse());
  }


}
