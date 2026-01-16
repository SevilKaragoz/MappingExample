package com.ylmz.modelmap.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserBalanceResponse {

    private String userName;
    private BigDecimal totalBalance;

}
