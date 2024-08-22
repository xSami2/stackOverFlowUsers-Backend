package com.sami.StackOverFlowBackend.controller;

import com.sami.StackOverFlowBackend.DTO.API_Responses;
import com.sami.StackOverFlowBackend.DTO.UserDTO;
import com.sami.StackOverFlowBackend.model.ExportRequest;
import com.sami.StackOverFlowBackend.service.ExportStackOverFlowUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("${api.endpoint.url}/export")
@RequiredArgsConstructor
public class ExportStackOverFlowUsersController {

    private final ExportStackOverFlowUsersService exportStackOverFlowUsersService;

    @PostMapping
    public API_Responses<String> exportStackOverFlowUsersFile(@RequestBody ExportRequest request) throws IOException {
       return exportStackOverFlowUsersService.exportStackOverFlowUsersFile(request);
    }
}
