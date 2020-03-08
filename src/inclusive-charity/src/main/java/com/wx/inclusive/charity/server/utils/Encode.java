package com.wx.inclusive.charity.server.utils;

import java.util.Base64;

public class Encode {
    public static String encodeBase64(byte[] bytes)
    {
        return Base64.getEncoder().encodeToString(bytes).replace("\r","").replace("\n","");
    }
    public static byte[] decodeBase64(String value)
    {
        return Base64.getDecoder().decode(value);
    }
}
