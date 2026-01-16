package com.ylmz.modelmap.service;


import com.ylmz.modelmap.dto.UserDTO;
import com.ylmz.modelmap.mapper.UserContactInfoMapper;
import com.ylmz.modelmap.request.UserBalanceRequest;
import com.ylmz.modelmap.request.UserContactRequest;
import com.ylmz.modelmap.request.UserRequest;
import com.ylmz.modelmap.response.UserBalanceResponse;
import com.ylmz.modelmap.response.UserContactResponse;
import com.ylmz.modelmap.response.UserResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService{

    private final ModelMapper modelMapper;

    public UserResponse createUser(UserRequest userRequest) {
     // to do
        UserDTO user = modelMapper.map(userRequest, UserDTO.class);
        /*
           fullName eşleşmediği için maplemedi !
           Enum Null Fallback: DTO da status ENUM , request de String ; convert edemediğinden NULL olarak status alanını yapar !
         */
        UserResponse response = modelMapper.map(user, UserResponse.class);
        response.setIsSuccess(true);
        return response;
    }

    public UserBalanceResponse getTotalBalance(@Valid UserBalanceRequest userBalanceRequest) {
        return UserBalanceResponse.builder()
                .userName(userBalanceRequest.getUserName())
                .totalBalance(userBalanceRequest.getUserIncome().subtract(userBalanceRequest.getUserExpenses()))
                .build();
    }

    public UserContactResponse getUserContact(UserContactRequest userContactRequest) {
        return  UserContactInfoMapper.INSTANCE.toResponse(userContactRequest);
    }
}
