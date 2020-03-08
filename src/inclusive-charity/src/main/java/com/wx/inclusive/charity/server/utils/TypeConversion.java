package com.wx.inclusive.charity.server.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.web3j.crypto.Sign;

import java.nio.ByteBuffer;

public class TypeConversion {
    public static byte[] Long2Bytes(Long param)
    {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(param);
        return buffer.array();
    }
    public static Sign.SignatureData String2Signature(String signature)
    {

        byte[] signatureBytes = Encode.decodeBase64(signature);
        String signatureStr = new String(signatureBytes);

        JSONObject jsonObject = JSON.parseObject(signatureStr);
        byte v = jsonObject.getByte("v");
        byte[] r = jsonObject.getBytes("r");
        byte[] s=jsonObject.getBytes("s");
        Sign.SignatureData signatureData = new Sign.SignatureData(v,r,s);
        return signatureData;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String signature = "eyJ2IjoyNywiciI6IjdFM3N4OGZsQUNNelN3SzhWT1g3alJFL0NYcTQ5Vzd5T1psNHRuVzNOYTQ9IiwicyI6Ik5hN1VqNktMVU84cGFsR1VkVi9OcTBYK1hOWVFHRjFYOEVKUFkyWCtxT0E9In0=";
        Sign.SignatureData signatureData= String2Signature(signature);
        String signatureTmp = JsonUtil.Object2String(signatureData);
        System.out.println(signature);
        System.out.println(signatureTmp);
    }
}
