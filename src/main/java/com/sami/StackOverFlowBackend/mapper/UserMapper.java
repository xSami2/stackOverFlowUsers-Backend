package com.sami.StackOverFlowBackend.mapper;

import java.util.ArrayList;
import java.util.List;
import com.sami.StackOverFlowBackend.DTO.UserDTO;
import com.sami.StackOverFlowBackend.model.User;
import com.sami.StackOverFlowBackend.model.UsersResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {



    public List<UserDTO> UsersToUserDTOs(UsersResponse usersResponse) {
        ArrayList<UserDTO> userDTOs = new ArrayList<>(30);

        for (User userModel : usersResponse.getItems()){
            UserDTO userDTO = new UserDTO(userModel);
            String userAge = getUserAgeInHumanReformatted(userModel.getCreation_date());
            userDTO.setUserAge(userAge);
            userDTOs.add(userDTO);
        }

        return userDTOs;

    }

    private static String getUserAgeInHumanReformatted(Long creation_date) {
        long currentTimestamp = System.currentTimeMillis() / 1000;
        long userTimestamp = creation_date;

        long timeElapsedInSeconds = currentTimestamp - userTimestamp;
        return (timeElapsedInSeconds / 31556926)
                + " years and "
                + (timeElapsedInSeconds % 31556926) / 2629743
                + " months ago";
    }


}
