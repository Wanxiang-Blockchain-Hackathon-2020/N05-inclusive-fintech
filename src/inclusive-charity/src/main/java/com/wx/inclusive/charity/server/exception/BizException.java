package com.wx.inclusive.charity.server.exception;

import com.wx.inclusive.charity.server.constants.ReturnCode;
import lombok.Getter;

public  class BizException extends RuntimeException{
    @Getter
    private ReturnCode returnCode;
    private String msg;
    public BizException(ReturnCode returnCode) {
        super(returnCode.getDesc());
        this.returnCode = returnCode;
    }
    public BizException(ReturnCode returnCode, Throwable cause) {
        super(returnCode.getDesc(),cause);
        this.returnCode = returnCode;
    }

    public BizException(ReturnCode returnCode, String msg) {

        super(msg);
        this.returnCode = returnCode;
        this.msg = msg;
    }
}
