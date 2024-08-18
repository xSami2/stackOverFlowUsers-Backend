package com.example.StackOverFlowBackend.controller;

import com.example.StackOverFlowBackend.service.BookmarkedUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.endpoint.url}/bookmark")
@RequiredArgsConstructor
public class BookmarkedUsersController {

    private final BookmarkedUsersService bookmarkedUsersService;

    @PostMapping("/bookmarkUser")
    public void saveBookmarkUser(@RequestBody Long userId) {
        bookmarkedUsersService.saveBookmarkedUser(userId);
    }

    @DeleteMapping("/unmarkUser")
    public void deleteBookmarkUser(@RequestBody Long userId) {
        bookmarkedUsersService.deleteBookmarkUser(userId);
    }

    @GetMapping("/bookmarkedUsersIds")
    public List<Long> getBookmarkedUsersIds() {
        return bookmarkedUsersService.getBookmarkedUsersIds();
    }

}
