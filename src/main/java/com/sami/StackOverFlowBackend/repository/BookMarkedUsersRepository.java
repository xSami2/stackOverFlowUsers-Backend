package com.sami.StackOverFlowBackend.repository;

import com.sami.StackOverFlowBackend.entity.BookmarkedUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookMarkedUsersRepository extends JpaRepository<BookmarkedUsers, Long> {


    @Query("SELECT userId FROM BookmarkedUsers")
    List<Long> getAllUserIds();



    void deleteByUserId(long id);

}
