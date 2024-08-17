package com.example.apilab.repository;

import com.example.apilab.entity.bookmarkedUsers;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookMarkedUsersRepository extends JpaRepository<bookmarkedUsers, Long> {


    @Query("SELECT userId FROM bookmarkedUsers")
    List<Long> getAllUserIds();



    void deleteByUserId(long id);

}
