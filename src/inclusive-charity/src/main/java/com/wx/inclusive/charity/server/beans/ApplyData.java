package com.wx.inclusive.charity.server.beans;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: inclusive-charity
 * @description: donate
 * @author: Emily Ma
 * @create: 2020-03-07
 **/
@Data
public class ApplyData {
    private int applyId;
    private Long timestamp;
    private BigDecimal balance;
    private String context;
    private String address;
    private String sign;
}
