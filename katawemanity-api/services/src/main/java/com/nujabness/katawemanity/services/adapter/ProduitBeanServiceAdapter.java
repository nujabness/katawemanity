package com.nujabness.katawemanity.services.adapter;

import com.nujabness.katawemanity.beans.commons.ProduitBean;
import com.nujabness.katawemanity.data.entity.Produit;

public class ProduitBeanServiceAdapter {

    private ProduitBeanServiceAdapter() {
      throw new IllegalStateException("Utility class");
    }

  public static ProduitBean transformToProduitBeanService(Produit produit) {
    ProduitBean produitBeanService = new ProduitBean ();
    produitBeanService .setId(produit.getId_prod());
    produitBeanService .setLibelle(produit.getLibelle());
    produitBeanService .setPrix(produit.getPrix());
    produitBeanService .setQuantite(produit.getQuantite());

    return produitBeanService;
  }

}
