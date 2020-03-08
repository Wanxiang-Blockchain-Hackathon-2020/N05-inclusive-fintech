package com.wx.inclusive.charity.server.beans.data;

import com.wx.inclusive.charity.server.beans.ApplyData;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: inclusive-charity
 * @description: donate
 * @author: Emily Ma
 * @create: 2020-03-07
 **/
@Data
public class AidApplyList {
    public static List<ApplyData> applyDataList = new ArrayList<ApplyData>();

}
