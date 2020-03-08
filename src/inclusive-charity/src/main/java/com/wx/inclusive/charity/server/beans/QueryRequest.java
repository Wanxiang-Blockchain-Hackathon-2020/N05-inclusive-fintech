package com.wx.inclusive.charity.server.beans;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: inclusive-charity
 * @description: query
 * @author: Emily Ma
 * @create: 2020-03-07
 **/
@Data
public class QueryRequest {
    private Long timestamp;
    private String sign;
}
