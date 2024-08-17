package com.example.apilab.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class bookmarkedUsers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long ID;

  @Column(unique = true, nullable = false)
  Long userId;


}
