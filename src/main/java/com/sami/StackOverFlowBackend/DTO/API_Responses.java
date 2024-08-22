package com.sami.StackOverFlowBackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor

public class API_Responses<T> {


    private boolean success;
    private String message;
    private T data;


}
