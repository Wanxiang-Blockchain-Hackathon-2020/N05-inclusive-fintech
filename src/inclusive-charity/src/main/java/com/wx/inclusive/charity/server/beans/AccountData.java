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
public class AccountData {
    public BigDecimal balance;
    public String address;
    public String desc;

    private AccountData(){}
    public AccountData(String address, BigDecimal balance, String desc)
    {
        AccountData accountData = new AccountData();
        accountData.setAddress(address);
        accountData.setBalance(balance);
        accountData.setDesc(desc);
    }
}
