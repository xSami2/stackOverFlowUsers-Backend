package com.example.StackOverFlowBackend.controller;

import com.example.StackOverFlowBackend.model.ExportRequest;
import com.example.StackOverFlowBackend.service.ExportStackOverFlowUsersService;
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
    public void exportStackOverFlowUsersFile(@RequestBody ExportRequest request) throws IOException {
        exportStackOverFlowUsersService.exportStackOverFlowUsersFile(request);
    }
}
