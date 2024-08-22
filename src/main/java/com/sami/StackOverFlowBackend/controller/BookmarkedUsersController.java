package com.sami.StackOverFlowBackend.controller;

import com.sami.StackOverFlowBackend.DTO.API_Responses;
import com.sami.StackOverFlowBackend.service.BookmarkedUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.url}/bookmark")
@RequiredArgsConstructor
public class BookmarkedUsersController {

    private final BookmarkedUsersService bookmarkedUsersService;

    @PostMapping("/bookmarkUser")
    public API_Responses<String> saveBookmarkUser(@RequestBody Long userId) {
      return bookmarkedUsersService.saveBookmarkedUser(userId);
    }


    @GetMapping("/bookmarkedUsersIds")
    public API_Responses<List<Long>> getBookmarkedUsersIds() {
        return bookmarkedUsersService.getBookmarkedUsersIds();
    }

    @DeleteMapping("/unmarkUser")
    public API_Responses<String> deleteBookmarkUser(@RequestBody Long userId) {
        return bookmarkedUsersService.deleteBookmarkUser(userId);
    }

}
