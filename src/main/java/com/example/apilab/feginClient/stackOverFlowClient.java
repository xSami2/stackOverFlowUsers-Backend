package com.example.apilab.feginClient;

import com.example.apilab.feginClient.model.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "stackOverFlowHttpClient" , url ="https://api.stackexchange.com/2.2")
public interface stackOverFlowClient {


    @GetMapping("/users?site=stackoverflow&filter=!3xJkL3hkXlxjprvS.")
    UsersResponse getUsers();

}
