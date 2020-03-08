package com.wx.inclusive.charity.server.beans;

import com.wx.inclusive.charity.server.constants.ReturnCode;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class NormalResponse<T> extends BaseResponse<T>{

    public NormalResponse() {
    }

    public NormalResponse(ReturnCode returnCode, T data) {
        this.setReturnCode(returnCode.getVal());
        this.setReturnDesc(returnCode.getDesc());
        this.setData(data);
    }

    public static <T> NormalResponse<T> success(T data){
        return of(ReturnCode.REQUEST_SUCCESS,data);
    }
    public static <T> NormalResponse<T> of(ReturnCode returnCode){
        return of(returnCode,null);
    }

    public static <T> NormalResponse<T> of(ReturnCode returnCode,T data){
        return new NormalResponse<>(returnCode,data);
    }

    public static <T> NormalResponse<T> success(){
        return success(null);
    }

    public static <T> NormalResponse<T> fail(T data){
        return of(ReturnCode.REQUEST_FAILED, data);
    }

    public static <T> NormalResponse<T> fail(){
        return fail(null);
    }


}

