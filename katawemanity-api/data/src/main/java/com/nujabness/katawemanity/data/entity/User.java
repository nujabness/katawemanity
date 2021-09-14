package com.nujabness.katawemanity.data.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "email")
  private String email;

  @Column(name = "password")
  private String password;

}
