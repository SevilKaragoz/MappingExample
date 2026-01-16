package com.ylmz.modelmap.request;

import lombok.Data;

@Data
public class UserRequest {

    private String name;
    private String lName;
    private String status;
    private Long identityNumber;

}