package com.example.StackOverFlowBackend.DTO;


import com.example.StackOverFlowBackend.model.User;
import com.example.StackOverFlowBackend.model.UsersResponse;
import lombok.Data;

@Data
public class UserDTO {
    private long user_id;
    private long account_id;
    private long last_access_date;
    private String display_name;
    private long userAge;
    private long reputation;
    private String location;
    private String userType;
    private long VIEW_COUNT;
    private long QUESTION_COUNT;
    private long ANSWER_COUNT;
    private String PROFILE_IMAGE;

public UserDTO(User user){
    this.user_id = user.getUser_id();
    this.account_id = user.getAccount_id();
    this.display_name = user.getDisplay_name();
    this.reputation = user.getReputation();
    this.location = user.getLocation();
    this.userType = user.getUser_type();
    this.userAge = user.getCreation_date();
    this.last_access_date = user.getLast_access_date();
    this.VIEW_COUNT = user.getView_count();
    this.QUESTION_COUNT = user.getQuestion_count();
    this.ANSWER_COUNT = user.getAnswer_count();
    this.PROFILE_IMAGE = user.getProfile_image();
}

}
