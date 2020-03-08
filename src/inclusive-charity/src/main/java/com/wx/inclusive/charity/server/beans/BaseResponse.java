package com.wx.inclusive.charity.server.beans;

import com.wx.inclusive.charity.server.constants.ReturnCode;

import lombok.Data;
@Data
public class BaseResponse<T> {
    /**
     * return code 返回码
     */

    private Integer returnCode;

    private String returnDesc;



    private T data;

    public void ReSetRturnCode(ReturnCode returnCode){
        this.returnCode = returnCode.getVal();
        this.returnDesc = returnCode.getDesc();
    }
   /*public public BaseResponse(Integer returnCode, String returnDesc, T data) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
        this.data = data;
    }*/
}
