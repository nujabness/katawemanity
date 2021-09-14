package com.nujabness.katawemanity.data.dao;

import com.nujabness.katawemanity.data.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IProduitRepository extends JpaRepository<Produit, Integer> {

  @Query("SELECT p FROM Produit p WHERE p.id  IN :id")
  Produit findByIdentifiant(@Param("id") Integer id);

  @Query("SELECT p.libelle FROM Produit p WHERE p.id  IN :id")
  String getLibelleByIdentifiant(@Param("id") Integer id);

  @Query("SELECT DISTINCT p FROM Produit p")
  List<Produit> findAllProduit();

  @Transactional
  @Modifying
  @Query("DELETE FROM Produit p WHERE p.id_prod IN :id")
  Integer deleteProduitByIdentifiant(@Param("id") Integer id);

  @Transactional
  @Modifying
  @Query("UPDATE Produit SET libelle = :libelle, prix = :prix, quantite = :quantite WHERE id_prod = :id")
  Integer updateProduitByIdentifiant(@Param("id") Integer id, @Param("libelle") String libelle, @Param("prix") Integer prix, @Param("quantite") Integer quantite);

}
