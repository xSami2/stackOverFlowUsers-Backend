package com.sami.StackOverFlowBackend.service;

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

    public List<UserDTO> getStackOverFlowUsers() {
        try {
            UsersResponse users = stackOverFlowClient.getUsers();
            return userMapper.UsersToUserDTOs(users);
        } catch (Exception e) {
            System.err.println("An error occurred while fetching StackOverflow users: " + e.getMessage());
            return new ArrayList<>();
        }
    }



}

