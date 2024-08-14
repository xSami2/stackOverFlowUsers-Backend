package com.example.apilab.DTO;


import lombok.Data;

@Data
public class UserDTO {

    private long user_id;
    private long reputation;
    private String display_name;
    private long last_access_date;


}
