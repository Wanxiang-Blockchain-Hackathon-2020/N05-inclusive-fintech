package com.wx.inclusive.charity.server.beans.data;

import lombok.Data;

import java.util.Random;

/**
 * @program: inclusive-charity
 * @description: get from chain
 * @author: Emily Ma
 * @create: 2020-03-07
 **/
@Data
public class ChainInfo {
    public static int blockNo = 0;
    private static String txHash;
    public static Long timestamp;

    public static String getTxHash()
    {
        byte[] tmp = new byte[32];
        Random random = new Random();
        random.nextBytes(tmp);
        txHash = tmp.toString();
        return txHash;
    }

}
