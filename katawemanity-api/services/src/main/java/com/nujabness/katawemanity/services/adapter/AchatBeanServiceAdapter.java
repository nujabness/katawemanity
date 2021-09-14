package com.nujabness.katawemanity.services.adapter;

import com.nujabness.katawemanity.beans.commons.AchatBean;
import com.nujabness.katawemanity.data.entity.Achat;

public class AchatBeanServiceAdapter {

    private AchatBeanServiceAdapter() {
      throw new IllegalStateException("Utility class");
    }

  public static AchatBean transformToAchatBeanService(Achat achat) {
    AchatBean achatBeanService = new AchatBean ();
    achatBeanService.setId_cli(achat.getId_cli().getId_cli());
    achatBeanService.setId_prod(achat.getId_prod().getId_prod());
    achatBeanService.setQuantite(achat.getQuantite());

    return achatBeanService;
  }

}
