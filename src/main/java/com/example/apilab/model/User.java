package com.example.apilab.model;

import lombok.Data;

@Data
public class User {

    private UserBadgeCounts badge_counts;
    private long account_id;
    private boolean is_employee;
    private long last_modified_date;
    private long last_access_date;
    private int reputation_change_year;
    private int reputation_change_quarter;
    private int reputation_change_month;
    private int reputation_change_week;
    private int reputation_change_day;
    private long reputation;
    private long creation_date;
    private String user_type;
    private long user_id;
    private int accept_rate;
    private String location;
    private String website_url;
    private String link;
    private String profile_image;
    private String display_name;

}
