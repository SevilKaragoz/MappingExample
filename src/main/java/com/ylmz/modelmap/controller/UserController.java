package com.ylmz.modelmap.controller;

import com.ylmz.modelmap.request.UserBalanceRequest;
import com.ylmz.modelmap.request.UserContactRequest;
import com.ylmz.modelmap.request.UserRequest;
import com.ylmz.modelmap.response.UserBalanceResponse;
import com.ylmz.modelmap.response.UserContactResponse;
import com.ylmz.modelmap.response.UserResponse;
import com.ylmz.modelmap.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        UserResponse response = userService.createUser(userRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/balance")
    public ResponseEntity<UserBalanceResponse> getTotalBalance(@Valid @RequestBody UserBalanceRequest userBalanceRequest) {
        UserBalanceResponse response = userService.getTotalBalance(userBalanceRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/contact")
    public ResponseEntity<UserContactResponse> getUserContact(@Valid @RequestBody UserContactRequest userContactRequest) {
        UserContactResponse response = userService.getUserContact(userContactRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
