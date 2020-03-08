package com.wx.inclusive.charity.server.beans;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: inclusive-charity
 * @description: get from chain
 * @author: Emily Ma
 * @create: 2020-03-07
 **/
@Data
public class DonateResponse {
    private int blockNo;
    private String txHash;
    private Long timestamp;
    private BigDecimal balance;

}
