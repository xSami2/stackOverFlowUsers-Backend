package com.sami.StackOverFlowBackend.service;

import com.sami.StackOverFlowBackend.DTO.API_Responses;
import com.sami.StackOverFlowBackend.DTO.UserDTO;
import com.sami.StackOverFlowBackend.feginClient.StackOverFlowClient;
import com.sami.StackOverFlowBackend.mapper.UserMapper;
import com.sami.StackOverFlowBackend.model.UsersResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StackOverFlowService {




    private final StackOverFlowClient stackOverFlowClient;
    private final UserMapper userMapper;

    public API_Responses<List<UserDTO>> getStackOverFlowUsers() {
        try {
            UsersResponse users = stackOverFlowClient.getUsers();
            List<UserDTO> userDTOs = userMapper.UsersToUserDTOs(users);
            return new API_Responses<>(true , "StackOverFlow User Data" , userDTOs);
        } catch (Exception e) {
            System.err.println("An error occurred while fetching StackOverflow users: " + e.getMessage());
            return  new API_Responses<>(false , "Exception Error" , null);
        }
    }



}

