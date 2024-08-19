package com.example.StackOverFlowBackend.DTO;


import com.example.StackOverFlowBackend.model.User;
import com.example.StackOverFlowBackend.model.UsersResponse;
import lombok.Data;

@Data
public class UserDTO {

    public UserDTO(long user_id, long account_id, long last_access_date, String display_name, String userAge, long reputation, String location, String userType, long VIEW_COUNT, long QUESTION_COUNT, long ANSWER_COUNT, String PROFILE_IMAGE) {
        this.user_id = user_id;
        this.account_id = account_id;
        this.last_access_date = last_access_date;
        this.display_name = display_name;
        this.userAge = userAge;
        this.reputation = reputation;
        this.location = location;
        this.userType = userType;
        this.VIEW_COUNT = VIEW_COUNT;
        this.QUESTION_COUNT = QUESTION_COUNT;
        this.ANSWER_COUNT = ANSWER_COUNT;
        this.PROFILE_IMAGE = PROFILE_IMAGE;
    }

    private long user_id;
    private long account_id;
    private long last_access_date;
    private String display_name;
    private long creation_date;
    private String userAge;
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
    this.creation_date = user.getCreation_date();
    this.last_access_date = user.getLast_access_date();
    this.VIEW_COUNT = user.getView_count();
    this.QUESTION_COUNT = user.getQuestion_count();
    this.ANSWER_COUNT = user.getAnswer_count();
    this.PROFILE_IMAGE = user.getProfile_image();
}

}
