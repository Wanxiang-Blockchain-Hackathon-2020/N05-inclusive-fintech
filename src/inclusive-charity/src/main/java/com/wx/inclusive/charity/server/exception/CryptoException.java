package com.wx.inclusive.charity.server.exception;

import com.wx.inclusive.charity.server.constants.ReturnCode;

public class CryptoException extends BizException{
    public CryptoException(ReturnCode returnCode) {
        super(returnCode);
    }
    public CryptoException(ReturnCode returnCode, String appendMsg) {
        super(returnCode,appendMsg);
    }

}
