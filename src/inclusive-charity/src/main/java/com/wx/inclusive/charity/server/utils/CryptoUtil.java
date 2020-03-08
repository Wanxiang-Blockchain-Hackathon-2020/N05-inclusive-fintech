package com.wx.inclusive.charity.server.utils;

import com.wx.inclusive.charity.server.constants.ReturnCode;
import com.wx.inclusive.charity.server.exception.CryptoException;
import org.web3j.crypto.Keys;
import org.web3j.crypto.Sign;

import java.math.BigInteger;
import java.security.SignatureException;

import static com.wx.inclusive.charity.server.utils.TypeConversion.String2Signature;
import static org.web3j.crypto.Sign.signedMessageToKey;

/**
 * @program: inclusive-charity
 * @description:
 * @author: Emily Ma
 * @create: 2020-03-08
 **/
public class CryptoUtil {

    public static BigInteger getPubKeyFromSignature(byte[] message, String signature) {

        Sign.SignatureData signatureData = String2Signature(signature);
        BigInteger pubKey;
        try {
            pubKey = signedMessageToKey(message, signatureData);
        } catch (SignatureException e) {
            e.printStackTrace();
            throw new CryptoException(ReturnCode.VERIFY_fAILED);
        }
        //String pubKeyStr = pubKey.toString(16);
        return pubKey;
    }
    public static String getAddressFromSign(String context, String sign)
    {
        /*BigInteger pubkey = getPubKeyFromSignature(context.getBytes(), sign);
        String address = Keys.getAddress(pubkey);*/
        String address = sign;
        return address;
    }
}
