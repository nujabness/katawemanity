package com.nujabness.katawemanity.data.dao;

import com.nujabness.katawemanity.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IUserRepository extends JpaRepository<User, Integer> {

  @Query("SELECT DISTINCT u FROM User u")
  List<User> findAllUser();

  @Transactional
  @Modifying
  @Query("DELETE FROM User u WHERE u.id IN :id")
  Integer deleteUserById(@Param("id") Integer id);

  @Transactional
  @Modifying
  @Query("UPDATE User SET nom = :nom, prenom = :prenom, password = :password, email = :email WHERE id = :id")
  Integer updateUserById(@Param("id") Integer id, @Param("nom") String nom, @Param("prenom") String prenom, @Param("password") String password, @Param("email") String email);

  @Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
  User getUserInfoByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
