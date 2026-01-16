package com.ylmz.modelmap.response;

import lombok.Data;

@Data
public class UserResponse {

    private String userName;
    private String lName;
    private String lastStatus;
    private Long identityNumber;
    private Boolean isSuccess;
}
