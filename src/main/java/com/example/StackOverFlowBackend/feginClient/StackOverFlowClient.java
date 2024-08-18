package com.example.StackOverFlowBackend.feginClient;

import com.example.StackOverFlowBackend.model.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "stackOverFlowHttpClient" , url ="https://api.stackexchange.com/2.2")
public interface StackOverFlowClient {


    @GetMapping("/users?site=stackoverflow&filter=!3xJkL3hkXlxjprvS.")
    UsersResponse getUsers();

}
