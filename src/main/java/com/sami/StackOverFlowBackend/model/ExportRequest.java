package com.sami.StackOverFlowBackend.model;

import com.sami.StackOverFlowBackend.DTO.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class ExportRequest {

    List<UserDTO> users;
    String orderType;
}
