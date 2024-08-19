package com.sami.StackOverFlowBackend.service;

import com.sami.StackOverFlowBackend.DTO.UserDTO;
import com.sami.StackOverFlowBackend.model.ExportRequest;
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
            case "Normal" -> {
                writeStackOverFlowUsersFile(usersList);
            }
            case "Ascending" -> {
                usersList = sortUsersAscending(usersList);
            }
            case "Descending" -> {
                usersList  = sortUsersDescending(usersList);
            }
        }

        writeStackOverFlowUsersFile(usersList);



    }


    private List<UserDTO> sortUsersDescending(List<UserDTO> users) {
        List<UserDTO> sortedUsersDescending = new ArrayList<>(users);

        int n = sortedUsersDescending.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedUsersDescending.get(j).getUser_id() > sortedUsersDescending.get(minIndex).getUser_id()) {
                    minIndex = j;
                }
            }
            UserDTO temp = sortedUsersDescending.get(minIndex);
            sortedUsersDescending.set(minIndex, sortedUsersDescending.get(i));
            sortedUsersDescending.set(i, temp);
        }

        return sortedUsersDescending;
    }
    private List<UserDTO> sortUsersAscending(List<UserDTO> users) {
        List<UserDTO> sortedUsersAscending = new ArrayList<>(users);

        int n = sortedUsersAscending.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (sortedUsersAscending.get(j).getUser_id() < sortedUsersAscending.get(minIndex).getUser_id()) {
                    minIndex = j;
                }
            }
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
