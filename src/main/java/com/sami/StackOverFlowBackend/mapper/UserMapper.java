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
        ArrayList<UserDTO> userDTOs = new ArrayList<>();

        for (User userModel : usersResponse.getItems()){
            UserDTO userDTO = new UserDTO(userModel);
            userDTOs.add(userDTO);
        }

        return userDTOs;

    }
}
