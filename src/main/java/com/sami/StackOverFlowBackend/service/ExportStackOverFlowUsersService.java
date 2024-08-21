package com.sami.StackOverFlowBackend.service;

import com.sami.StackOverFlowBackend.DTO.UserDTO;
import com.sami.StackOverFlowBackend.model.ExportRequest;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Service
public class ExportStackOverFlowUsersService {

    public void exportStackOverFlowUsersFile(ExportRequest request) throws IOException {

        String orderType = request.getOrderType();
        List<UserDTO> usersList = request.getUsers();




        switch (orderType) {
            case "Normal" -> {
            break;
            }
            case "Ascending" -> {
               usersList.sort(Comparator.comparingLong(UserDTO::getUser_id));
            }
            case "Descending" -> {
                usersList.sort(Comparator.comparingLong(UserDTO::getUser_id).reversed());
            }
        }

        writeStackOverFlowUsersFile(usersList);



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
