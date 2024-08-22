package com.sami.StackOverFlowBackend.service;

import com.sami.StackOverFlowBackend.DTO.API_Responses;
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

    public API_Responses<String> saveBookmarkedUser(Long userId) {
        try{
            BookmarkedUsers bookmarkedUser = new BookmarkedUsers();
            bookmarkedUser.setUserId(userId);
            bookmarkedUsersRepository.save(bookmarkedUser);
            return new API_Responses<>(true , "User with ID " +userId+ " has been added to bookmarked" , null);
        }catch (DataIntegrityViolationException exception){
            return new API_Responses<>(false , "User with ID " +userId+ " is Already bookmarked" , null);
        }

    }
    public API_Responses<List<Long>> getBookmarkedUsersIds(){
        try {
            List<Long> userIds = bookmarkedUsersRepository.getAllUserIds();
            return new API_Responses<>(true , "Bookmarked User IDs has been fetch successfully " , userIds);

        }catch (Exception e){
           System.err.println("An error occurred while fetching bookmarked user IDs: " + e.getMessage());
            return new API_Responses<>(true , "An error occurred while fetching bookmarked user IDs:" , null);
        }
    }

    @Transactional
    public API_Responses<String> deleteBookmarkUser(Long userId) {
        try {
             bookmarkedUsersRepository.deleteByUserId(userId);
            return new API_Responses<>(true , "User with ID " +userId+ " has been deleted from bookmarked" , null);
        }catch (Exception e){
            return new API_Responses<>(true , "An error occurred while fetching bookmarked user IDs:" , null);
        }
    }
}
