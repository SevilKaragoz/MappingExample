package com.ylmz.modelmap.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserBalanceRequest {

    private String userName;
    private BigDecimal userIncome;
    private BigDecimal userExpenses;
}
