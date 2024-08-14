package com.example.apilab.controller;


import com.example.apilab.DTO.UserDTO;
import com.example.apilab.model.ExportRequest;
import com.example.apilab.model.User;
import com.example.apilab.model.UsersResponse;
import com.example.apilab.service.stackOverFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sof")
@RequiredArgsConstructor
public class stackOverFlowController {

    private final stackOverFlowService stackOverFlowService;


    @GetMapping
    public List<User> getStackOverFlowUsers() {
         return stackOverFlowService.getStackOverFlowUsers();
    }
    @PostMapping
    public void exportStackOverFlowUsersFile(@RequestBody ExportRequest request) throws IOException {
       stackOverFlowService.exportStackOverFlowUsersFile(request);
    }

    @PostMapping("/bookmarkUsers")
    public void bookMarkUsers(@RequestBody List<User> bookmarkUsers) {
        System.out.println(bookmarkUsers);

        stackOverFlowService.saveBookmarkedUsers(bookmarkUsers);

    }

}
