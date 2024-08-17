package com.example.apilab.feginClient.model;

import lombok.Data;

import java.util.List;

@Data
public class ExportRequest {

    List<User> users;
    String orderType;
}
