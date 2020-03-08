package com.wx.inclusive.charity.server.beans;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: inclusive-charity
 * @description:
 * @author: Emily Ma
 * @create: 2020-03-08
 **/
@Data
public class AidCheck {
    private int applyId;
    private Long timestamp;
    private BigDecimal balance;
    private String toAddress;
    private String sign;
}
