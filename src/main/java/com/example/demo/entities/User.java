package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Entity
@Data
@Table(name="users")
public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String password;
}
