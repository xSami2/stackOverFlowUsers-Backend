package com.example.apilab.mapper;

import java.util.ArrayList;
import java.util.List;
import com.example.apilab.DTO.UserDTO;
import com.example.apilab.feginClient.model.UsersResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {



    public List<UserDTO> UsersToUserDTOs(UsersResponse usersResponse) {
        ArrayList<UserDTO> userDTOs = new ArrayList<UserDTO>();

        for (int i = 0; i <usersResponse.getItems().size() ; i++) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUser_id( usersResponse.getItems().get(i).getUser_id() );
            userDTO.setDisplay_name(usersResponse.getItems().get(i).getDisplay_name());
            userDTO.setReputation(usersResponse.getItems().get(i).getReputation());
            userDTO.setLast_access_date(usersResponse.getItems().get(i).getLast_access_date());
            userDTOs.add(userDTO);
        }

        return userDTOs;

    }
}
