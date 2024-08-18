package com.example.StackOverFlowBackend.service;

import com.example.StackOverFlowBackend.entity.BookmarkedUsers;
import com.example.StackOverFlowBackend.repository.BookMarkedUsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BookmarkedUsersService {

    private final BookMarkedUsersRepository bookmarkedUsersRepository;

    public void saveBookmarkedUser(Long userId) {
        try{
            BookmarkedUsers bookmarkedUser = new BookmarkedUsers();
            bookmarkedUser.setUserId(userId);
            bookmarkedUsersRepository.save(bookmarkedUser);
        }catch (DataIntegrityViolationException exception){
        exception.printStackTrace();
        }

    }
    public List<Long> getBookmarkedUsersIds(){
        return bookmarkedUsersRepository.getAllUserIds();
    }

    @Transactional
    public void deleteBookmarkUser(Long userId) {
        bookmarkedUsersRepository.deleteByUserId(userId);
    }
}
