package com.sami.StackOverFlowBackend.controller;


import com.sami.StackOverFlowBackend.DTO.UserDTO;
import com.sami.StackOverFlowBackend.service.StackOverFlowService;
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
