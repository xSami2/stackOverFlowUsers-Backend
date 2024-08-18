package com.example.StackOverFlowBackend.service;

import com.example.StackOverFlowBackend.DTO.UserDTO;
import com.example.StackOverFlowBackend.entity.BookmarkedUsers;
import com.example.StackOverFlowBackend.feginClient.StackOverFlowClient;
import com.example.StackOverFlowBackend.mapper.UserMapper;
import com.example.StackOverFlowBackend.model.ExportRequest;
import com.example.StackOverFlowBackend.model.User;
import com.example.StackOverFlowBackend.model.UsersResponse;
import com.example.StackOverFlowBackend.repository.BookMarkedUsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StackOverFlowService {




    private final StackOverFlowClient stackOverFlowClient;
    private final UserMapper userMapper;

    public List<UserDTO> getStackOverFlowUsers() {
        UsersResponse users = stackOverFlowClient.getUsers();
        return userMapper.UsersToUserDTOs(users);
    }



}

