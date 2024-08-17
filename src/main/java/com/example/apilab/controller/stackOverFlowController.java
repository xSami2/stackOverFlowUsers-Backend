package com.example.apilab.controller;


import com.example.apilab.feginClient.model.ExportRequest;
import com.example.apilab.feginClient.model.User;
import com.example.apilab.service.stackOverFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @GetMapping("/bookmarkedUsersIds")
    public List<Long> getBookmarkedUsersIds() {
        return stackOverFlowService.getBookmarkedUsersIds();
    }

    @PostMapping
    public void exportStackOverFlowUsersFile(@RequestBody ExportRequest request) throws IOException {
       stackOverFlowService.exportStackOverFlowUsersFile(request);
    }

    @PostMapping("/bookmarkUser")
    public void saveBookmarkUser(@RequestBody Long userId) {
        System.out.println(userId);

        stackOverFlowService.saveBookmarkedUser(userId);

    }

    @DeleteMapping("/unmarkUser")
    public void deleteBookmarkUser(@RequestBody Long userId) {
        System.out.println(userId);
        stackOverFlowService.deleteBookmarkUser(userId);
    }



}
