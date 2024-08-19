package com.sami.StackOverFlowBackend.model;

import lombok.Data;

import java.util.List;

@Data
public class UsersResponse {

    private List<User> items;
    private boolean has_more;
    private int quote_max;
    private int quota_remaining;

}
