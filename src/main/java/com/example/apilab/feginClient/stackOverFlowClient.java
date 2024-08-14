package com.example.apilab.feginClient;

import com.example.apilab.model.UsersResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "stackOverFlowHttpClient" , url ="https://api.stackexchange.com/2.2")
public interface stackOverFlowClient {


    @GetMapping("/users?site=stackoverflow")
    UsersResponse getUsers();

}
