package com.wx.inclusive.charity.server.controller;

import com.wx.inclusive.charity.server.beans.*;
import com.wx.inclusive.charity.server.service.InclusiveCharityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ly on 10/24/18
 */

@RestController
@RequestMapping(value = "/api")
@Slf4j
public class InclusiveCharityController {
    private static final Map<String,String> jsonMapCache = new HashMap<>();

    @Autowired
    private InclusiveCharityService inclusiveCharityService;

    @PostMapping(path = "/donate",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public NormalResponse donate(@RequestBody TransferRequest transferRequest){
        return NormalResponse.success(inclusiveCharityService.donate(transferRequest));

    }
    @PostMapping(path = "/aidApply",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public NormalResponse aidApply(@RequestBody ApplyRequest applyRequest){
        return NormalResponse.success(inclusiveCharityService.aidApply(applyRequest));

    }
    @PostMapping(path = "/balanceQuery",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public NormalResponse balanceQuery(@RequestBody QueryRequest queryRequest){
        return NormalResponse.success(inclusiveCharityService.balanceQuery(queryRequest));

    }
    @PostMapping(path = "/withdrawApply",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public NormalResponse withdrawApply(@RequestBody ApplyRequest applyRequest){
        return NormalResponse.success(inclusiveCharityService.withdrawApply( applyRequest));

    }
    @PostMapping(path = "/aidCheck",produces = "application/json; charset=UTF-8")
    @ResponseBody
    public NormalResponse aidCheck(@RequestBody AidCheck aidCheck){
        return NormalResponse.success(inclusiveCharityService.aidCheck(aidCheck));

    }

}
