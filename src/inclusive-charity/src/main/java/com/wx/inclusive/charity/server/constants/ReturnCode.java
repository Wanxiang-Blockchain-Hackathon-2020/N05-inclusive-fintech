package com.wx.inclusive.charity.server.constants;

import lombok.Getter;
import lombok.Setter;


public enum ReturnCode {
    VERIFY_fAILED(10001, "verify signature failed"),
    AUTHORIZATION_fAILED(10002, "verify authorization failed"),
    // Request paramter error (such as wrong parameter format, insufficient parameters) [12xxx]
    //请求参数错误（如参数格式错误，参数缺少） [12xxx]
    PARAMETER_FAILED(12010, " Parameter check failed"),
    PARAMETER_DUPLICATED(12011, " Parameter duplicated"),

    //4. Internet error, network timeout, system call failed (such as occur error in invocation error in and out of system,
    //   such as redis inter-service invocation timeout, httpclient invocation, blockchain node connection error)
    //4. 网络错误,网络超时，系统调用失败（如系统内调用，系统外调用， occur error，如redis，服务间调用超时，httpclient调用，区块链连接节点错误）  [14xxx]
    HYSTRIX_FALLBACK(14030, " Interface blown back"),
    FEIGN_RESPONSE_NULL(14040, " feignClient returns null"),
    FEIGN_RESPONSE_NOT_SUCCESS(14041, " feignClient invocation succeeded, returning unsuccessful error code"),

    // Session timeout 会话超时  [16xxx]
    SESSION_TIMEOUT(16010, " Session timeout"),
    LOGIN_ERROR(16011, "login error"),
    LOGIN_FAIL(16012, "login fail"),
    //TOKEN_EXPIRED(16020, " Token expired token过期"),

    // General request succeeded, failed 通用请求成功，失败(通用成功消息码) [17xxx]
    REQUEST_SUCCESS(17000, " Request success"),
    REQUEST_FAILED(17010, " Request failed"),
    SERVER_INTERNAL_ERROR(17011, " Server internal error"),
    NOT_FOUND(17012, " Request path error"),
    IO_ERROR(17013, " Internet IO error"),


    // File error 文件错误  [18xxx]
    /*FILE_UPLOAD_FAILED(18010, " File upload failed 文件上传失败"),
    FILE_SIZE_ERROR(18011, " File size is over limit 文件大小超出限制"),
    FILE_TYPE_ERROR(18012, " Wrong file format 文件格式错误"),
    FILE_DOWNLOAD_FAILED(18020, " File download failed 文件下载失败"),*/


    // Business error code, customized 业务失败错误码  自定义,[20xxx]
    PLATONE_RESPONSE_HAS_ERROR(20101," Platone return code hasError=true"),
    REPEAT_TRANSACTION(20202, "Repeated transaction"),
    OUT_OF_RETRY_LIMIT(20203, "超过重试次数"),
    DATA_NOT_FOUND(20204, "数据未找到");



    // Maximum error code 最大错误码
    //MAX_RETURN_CODE(99999," Maximum error code 最大错误码");



    @Getter
    @Setter
    private int val;
    @Getter
    @Setter
    private String desc;

    ReturnCode(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }
    public static ReturnCode getByVal(int val) {
        for (ReturnCode value : ReturnCode.values()) {
            if(value.val == val){
                return value;
            }
        }
        throw new RuntimeException("no matched ReturnCode:"+val);
    }
}

