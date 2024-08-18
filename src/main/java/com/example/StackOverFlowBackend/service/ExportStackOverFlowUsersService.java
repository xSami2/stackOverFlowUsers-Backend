package com.example.StackOverFlowBackend.service;

import com.example.StackOverFlowBackend.DTO.UserDTO;
import com.example.StackOverFlowBackend.model.ExportRequest;
import com.example.StackOverFlowBackend.model.User;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportStackOverFlowUsersService {

    public void exportStackOverFlowUsersFile(ExportRequest request) throws IOException {

        String orderType = request.getOrderType();
        List<UserDTO> usersList = request.getUsers();

        switch (orderType) {
            case "Normal" -> writeStackOverFlowUsersFile(usersList);
            case "Ascending" -> {
                List<UserDTO> sortedUsersAscending = sortUsersAscending(usersList);
                writeStackOverFlowUsersFile(sortedUsersAscending);
            }
            case "Descending" -> {
                List<UserDTO> sortedUsersDescending = sortUsersDescending(usersList);
                writeStackOverFlowUsersFile(sortedUsersDescending);
            }
        }


    }


    private List<UserDTO> sortUsersDescending(List<UserDTO> users) {
        // Create a copy of the original list to sort
        List<UserDTO> sortedUsersDescending = new ArrayList<>(users);

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
            UserDTO temp = sortedUsersDescending.get(minIndex);
            sortedUsersDescending.set(minIndex, sortedUsersDescending.get(i));
            sortedUsersDescending.set(i, temp);
        }

        return sortedUsersDescending;
    }
    private List<UserDTO> sortUsersAscending(List<UserDTO> users) {
        // Create a copy of the original list to sort
        List<UserDTO> sortedUsersAscending = new ArrayList<>(users);

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
            UserDTO temp = sortedUsersAscending.get(minIndex);
            sortedUsersAscending.set(minIndex, sortedUsersAscending.get(i));
            sortedUsersAscending.set(i, temp);
        }

        return sortedUsersAscending;
    }
    private void writeStackOverFlowUsersFile(List<UserDTO> users) throws IOException {
        try {
            FileWriter myWriter = new FileWriter(new File( "src/main/resources","stackOverFlowUsers.sofusers"));
            myWriter.write(users.size() + "\t" + "1");
            myWriter.write("\n");
            for (UserDTO user : users) {
                myWriter.write(user.getUser_id() + "\t");
                myWriter.write(user.getAccount_id() + "\t");
                myWriter.write(user.getDisplay_name() + "\t");
                myWriter.write(user.getUserAge() + "\t");
                myWriter.write(user.getReputation() + "\t");
                myWriter.write(user.getLocation() + "\t");
                myWriter.write(user.getUserType() + "\t");
                myWriter.write(user.getVIEW_COUNT() + "\t");
                myWriter.write(user.getQUESTION_COUNT() + "\t");
                myWriter.write(user.getANSWER_COUNT()+ "\t");
                myWriter.write(user.getPROFILE_IMAGE() + "\t");
                myWriter.write("\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}
