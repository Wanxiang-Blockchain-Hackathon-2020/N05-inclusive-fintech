package com.wx.inclusive.charity.server.beans.data;

import com.wx.inclusive.charity.server.beans.AccountData;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: inclusive-charity
 * @description: account list
 * @author: Emily Ma
 * @create: 2020-03-07
 **/
@Data
public class AccountList {
    public static List<AccountData> accountDataList = new ArrayList<AccountData>();
    {
        AccountData donateAccount = new AccountData("0001", BigDecimal.valueOf(1000),"donater");
        accountDataList.add(donateAccount);
        AccountData charityAccount = new AccountData("0002", BigDecimal.valueOf(10000),"charity");
        accountDataList.add(charityAccount);
        AccountData charityFeeAccount = new AccountData("0003", BigDecimal.valueOf(10),"charityFee");
        accountDataList.add(charityFeeAccount);
        AccountData recipientAccount = new AccountData("0004", BigDecimal.valueOf(10),"recipient");
        accountDataList.add(recipientAccount);
    }
}
