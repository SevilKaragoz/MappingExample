package com.ylmz.modelmap.response;

import com.ylmz.modelmap.enums.UserStatus;
import lombok.Data;

@Data
public class UserContactResponse {

    private String userName;
    private String fullName;
    private String phoneNumber;
    private String address;
    private UserStatus status;
    private String idenNumber;
}
