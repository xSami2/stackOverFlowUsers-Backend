package com.example.StackOverFlowBackend.model;

import com.example.StackOverFlowBackend.DTO.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ExportRequest {

    List<UserDTO> users;
    String orderType;
}
