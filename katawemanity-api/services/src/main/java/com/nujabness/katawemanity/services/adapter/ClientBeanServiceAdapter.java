package com.nujabness.katawemanity.services.adapter;


import com.nujabness.katawemanity.beans.commons.ClientBean;
import com.nujabness.katawemanity.data.entity.Client;

public class ClientBeanServiceAdapter {

    private ClientBeanServiceAdapter() {
      throw new IllegalStateException("Utility class");
    }

  public static ClientBean transformToClientBeanService(Client client) {
    ClientBean clientBeanService = new ClientBean();
    clientBeanService.setId(client.getId_cli());
    clientBeanService.setNom(client.getNom());
    clientBeanService.setPrenom(client.getPrenom());
    clientBeanService.setAdresse(client.getAdresse());

    return clientBeanService;
  }

}
