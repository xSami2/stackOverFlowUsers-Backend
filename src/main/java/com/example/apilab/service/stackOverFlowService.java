package com.example.apilab.service;

import com.example.apilab.entity.bookmarkedUsers;
import com.example.apilab.feginClient.stackOverFlowClient;
import com.example.apilab.feginClient.model.ExportRequest;
import com.example.apilab.feginClient.model.User;
import com.example.apilab.feginClient.model.UsersResponse;
import com.example.apilab.repository.BookMarkedUsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class stackOverFlowService {




    private final stackOverFlowClient stackOverFlowClient;
    private final BookMarkedUsersRepository bookmarkedUsersRepository;

    public List<User> getStackOverFlowUsers() {
        UsersResponse users = stackOverFlowClient.getUsers();
        System.out.println(users.getItems());
        return users.getItems();
    }
    public void exportStackOverFlowUsersFile(ExportRequest request) throws IOException {

       String orderType = request.getOrderType();
       List<User> usersList = request.getUsers();
        switch (orderType) {
            case "Normal" -> writeStackOverFlowUsersFile(usersList);
            case "Ascending" -> {
                List<User> sortedUsersAscending = sortUsersAscending(usersList);
                writeStackOverFlowUsersFile(sortedUsersAscending);
            }
            case "Descending" -> {
                List<User> sortedUsersDescending = sortUsersDescending(usersList);
                writeStackOverFlowUsersFile(sortedUsersDescending);
            }
        }


    }
    public void saveBookmarkedUser(Long userId) {

        try{
                bookmarkedUsers bookmarkedUser = new bookmarkedUsers();
                bookmarkedUser.setUserId(userId);
                bookmarkedUsersRepository.save(bookmarkedUser);
        }catch (DataIntegrityViolationException ignored){

        }

    }
    public List<Long> getBookmarkedUsersIds(){
        return bookmarkedUsersRepository.getAllUserIds();
    }

    @Transactional
    public void deleteBookmarkUser(Long userId) {
        bookmarkedUsersRepository.deleteByUserId(userId);
    }

    private List<User> sortUsersDescending(List<User> users) {
        // Create a copy of the original list to sort
        List<User> sortedUsersDescending = new ArrayList<>(users);

        int n = sortedUsersDescending.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the index of the smallest element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (sortedUsersDescending.get(j).getUser_id() > sortedUsersDescending.get(minIndex).getUser_id()) {
                    minIndex = j;
                }
            }
            // Swap the smallest element with the first unsorted element
            User temp = sortedUsersDescending.get(minIndex);
            sortedUsersDescending.set(minIndex, sortedUsersDescending.get(i));
            sortedUsersDescending.set(i, temp);
        }

        return sortedUsersDescending;
    }
    private List<User> sortUsersAscending(List<User> users) {
        // Create a copy of the original list to sort
        List<User> sortedUsersAscending = new ArrayList<>(users);

        int n = sortedUsersAscending.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Find the index of the smallest element in the unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (sortedUsersAscending.get(j).getUser_id() < sortedUsersAscending.get(minIndex).getUser_id()) {
                    minIndex = j;
                }
            }
            // Swap the smallest element with the first unsorted element
            User temp = sortedUsersAscending.get(minIndex);
            sortedUsersAscending.set(minIndex, sortedUsersAscending.get(i));
            sortedUsersAscending.set(i, temp);
        }

        return sortedUsersAscending;
    }
    private void writeStackOverFlowUsersFile(List<User> users) throws IOException {
        try {
            FileWriter myWriter = new FileWriter(new File( "src/main/resources","stackOverFlowUsers.sofusers"));
            myWriter.write(users.size() + "\t" + "1");
            myWriter.write("\n");
            for (User user : users) {
                myWriter.write(user.getUser_id() + "\t");
                myWriter.write(user.getAccount_id() + "\t");
                myWriter.write(user.getDisplay_name() + "\t");
                //myWriter.write(user.getuserAge() + "\t");
                myWriter.write(user.getReputation() + "\t");
                myWriter.write(user.getLocation() + "\t");
                myWriter.write(user.getUser_type() + "\t");
                myWriter.write(user.getView_count() + "\t");
                myWriter.write(user.getQuestion_count() + "\t");
                myWriter.write(user.getAnswer_count() + "\t");
                myWriter.write(user.getProfile_image() + "\t");
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }



}

