package com.example.apilab.repository;

import com.example.apilab.entity.bookmarkedUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookMarkedUsersRepository extends JpaRepository<bookmarkedUsers, Long> {

}
