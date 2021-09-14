package com.nujabness.katawemanity.data.dao;

import com.nujabness.katawemanity.data.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface IClientRepository extends JpaRepository<Client, Integer> {

  @Query("SELECT c FROM Client c WHERE c.id  IN :id")
  Client findByIdentifiant(@Param("id") Integer id);

  @Query("SELECT c.nom FROM Client c WHERE c.id  IN :id")
  String getNomByIdentifiant(@Param("id") Integer id);


  @Query("SELECT DISTINCT c FROM Client c")
  List<Client> findAllClient();

  @Transactional
  @Modifying
  @Query("DELETE FROM Client c WHERE c.id_cli IN :id")
  Integer deleteClientByIdentifiant(@Param("id") Integer id);

  @Transactional
  @Modifying
  @Query("UPDATE Client SET nom = :nom, prenom = :prenom, adresse = :adresse WHERE id = :id")
  Integer updateClientByIdentifiant(@Param("id") Integer id, @Param("nom") String nom, @Param("prenom") String prenom, @Param("adresse") String adresse);

}
