package com.nujabness.katawemanity.data.dao;

import com.nujabness.katawemanity.data.entity.Achat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IAchatRepository extends JpaRepository<Achat, Integer> {

  @Query("SELECT a FROM Achat a WHERE a.id_cli  IN :id_cli AND a.id_prod  IN :id_prod")
  Achat findByIdentifiant(@Param("id_cli") Integer id_cli, @Param("id_prod") Integer id_prod);

  @Query("SELECT A FROM Achat A")
  List<Achat> findAllAchat();

  @Transactional
  @Modifying
  @Query("DELETE FROM Achat a WHERE a.id_cli = :id_cli AND a.id_prod = :id_prod ")
  Integer deleteAchatByIdentifiant(@Param("id_cli") Integer id_cli, @Param("id_prod") Integer id_prod);

  @Transactional
  @Modifying
  @Query("UPDATE Achat SET quantite = :quantite WHERE id_cli = :id_cli AND id_prod = :id_prod")
  Integer updateAchatByIdentifiant(@Param("id_cli") Integer id_cli, @Param("id_prod") Integer id_prod, @Param("quantite") Integer quantite);

}
