package com.wx.inclusive.charity.server.beans;

import com.wx.inclusive.charity.server.constants.Magic;
import lombok.Data;

/**
 * Created by ly on 10/24/18
 */

@Data
public class ResponseFormat {
    private String status;
    private String msg;

    public ResponseFormat(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static ResponseFormat basic(){
        return new ResponseFormat(Magic.SUCCESS,"");
    }
}
