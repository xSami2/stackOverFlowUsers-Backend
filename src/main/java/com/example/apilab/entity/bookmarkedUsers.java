package com.example.apilab.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class bookmarkedUsers {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  String uuid;

  @Column(unique = true, nullable = false)
  Long user_id;


}
