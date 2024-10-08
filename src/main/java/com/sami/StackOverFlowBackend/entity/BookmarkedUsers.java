package com.sami.StackOverFlowBackend.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BookmarkedUsers {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long ID;

  @Column(unique = true, nullable = false)
  Long userId;


}