package com.ylmz.modelmap.dto;

import com.ylmz.modelmap.enums.UserStatus;
import lombok.Data;

@Data
public class UserDTO {
    private String name;
    private String lName;
    private String fullName;
    private UserStatus status;
    private Long identityNumber;

}
