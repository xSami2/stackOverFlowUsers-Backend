package com.example.StackOverFlowBackend.controller;


import com.example.StackOverFlowBackend.DTO.UserDTO;
import com.example.StackOverFlowBackend.service.StackOverFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("${api.endpoint.url}/users")
@RequiredArgsConstructor
public class StackOverFlowUsersController {

    private final StackOverFlowService stackOverFlowService;


    @GetMapping
    public List<UserDTO> getStackOverFlowUsers() {
         return stackOverFlowService.getStackOverFlowUsers();
    }









}
