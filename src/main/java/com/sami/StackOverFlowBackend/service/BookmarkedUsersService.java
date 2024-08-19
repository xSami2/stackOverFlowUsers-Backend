package com.sami.StackOverFlowBackend.service;

import com.sami.StackOverFlowBackend.entity.BookmarkedUsers;
import com.sami.StackOverFlowBackend.repository.BookMarkedUsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BookmarkedUsersService {

    private final BookMarkedUsersRepository bookmarkedUsersRepository;

    public void saveBookmarkedUser(Long userId) {
        try{
            BookmarkedUsers bookmarkedUser = new BookmarkedUsers(userId);
            bookmarkedUsersRepository.save(bookmarkedUser);
        }catch (DataIntegrityViolationException exception){
            System.err.println("The same user Cannot Bookmarked Twice: " + exception.getMessage());



        }

    }
    public List<Long> getBookmarkedUsersIds(){
        try {
            return bookmarkedUsersRepository.getAllUserIds();
        }catch (Exception e){
           System.err.println("An error occurred while fetching bookmarked user IDs: " + e.getMessage());
            return new ArrayList<>(); // Returning an empty list as a fallback
        }
    }

    @Transactional
    public void deleteBookmarkUser(Long userId) {
        try {
             bookmarkedUsersRepository.deleteByUserId(userId);
        }catch (Exception e){
            System.err.println("An error occurred while Deleting UserID : " + e.getMessage());
        }
    }
}
