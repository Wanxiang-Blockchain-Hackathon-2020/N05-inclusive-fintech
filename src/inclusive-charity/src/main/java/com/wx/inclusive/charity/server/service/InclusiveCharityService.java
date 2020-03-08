package com.wx.inclusive.charity.server.service;

import com.wx.inclusive.charity.server.beans.*;
import com.wx.inclusive.charity.server.beans.data.*;
import com.wx.inclusive.charity.server.utils.CryptoUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by ly on 10/24/18
 */
@Service
public class InclusiveCharityService {

    public DonateResponse donate(TransferRequest transferRequest)
    {
        Boolean result = transfer(transferRequest);
        DonateResponse donateResponse = new DonateResponse();

        donateResponse.setBlockNo(ChainInfo.blockNo+1);
        donateResponse.setTxHash(ChainInfo.getTxHash());
        donateResponse.setTimestamp(System.currentTimeMillis());
        donateResponse.setBalance(transferRequest.getBalance());

        return donateResponse;
    }

    public Boolean transfer(TransferRequest transferRequest){
        String context = "timestamp"+transferRequest.getTimestamp()+"balance"+transferRequest.getBalance()+"toAddress"+transferRequest.getToAddress();
        String addressFrom = CryptoUtil.getAddressFromSign(context, transferRequest.getSign());
        String addressTo = transferRequest.getToAddress();
        BigDecimal balance = transferRequest.getBalance();
        for (AccountData accountData:AccountList.accountDataList)
        {
            if (accountData.getAddress().equals(addressFrom))
            {
                accountData.setBalance(accountData.getBalance().subtract(balance));
            }
            if (accountData.getAddress().equals(addressTo))
            {
                accountData.setBalance(accountData.getBalance().add(balance));
            }
        }
        return true;
    }
    public String aidApply(ApplyRequest applyRequest){
        String context = "timestamp"+applyRequest.getTimestamp()+"balance"+applyRequest.getBalance()+"context"+applyRequest.getContext();
        String addressFrom = CryptoUtil.getAddressFromSign(context, applyRequest.getSign());

        ApplyData applyData = new ApplyData();
        int applyId = AccountList.accountDataList.size();
        applyData.setApplyId(applyId);
        applyData.setBalance(applyRequest.getBalance());
        applyData.setContext(applyRequest.getContext());
        applyData.setTimestamp(System.currentTimeMillis());
        applyData.setAddress(addressFrom);
        AidApplyList.applyDataList.add(applyData);
        return "success";
    }
    public BigDecimal balanceQuery(QueryRequest queryRequest){

        String context = "timestamp"+queryRequest.getTimestamp();
        String addressFrom = CryptoUtil.getAddressFromSign(context, queryRequest.getSign());
        BigDecimal balance = BigDecimal.ZERO;
        for (AccountData accountData:AccountList.accountDataList)
        {
            if (accountData.getAddress().equals(addressFrom))
            {
                balance = accountData.getBalance();
            }
        }
        return balance;
    }

    public String withdrawApply(ApplyRequest applyRequest){
        String context = "timestamp"+applyRequest.getTimestamp()+"balance"+applyRequest.getBalance()+"context"+applyRequest.getContext();
        String addressFrom = CryptoUtil.getAddressFromSign(context, applyRequest.getSign());

        ApplyData applyData = new ApplyData();
        applyData.setBalance(applyRequest.getBalance());
        applyData.setContext(applyRequest.getContext());
        applyData.setTimestamp(System.currentTimeMillis());
        applyData.setAddress(addressFrom);
        WithdrawApplyList.applyDataList.add(applyData);
        return "success";
    }
    public String aidCheck(AidCheck aidCheck){
        for (ApplyData applyData:AidApplyList.applyDataList)
        {
            if (applyData.getApplyId() == aidCheck.getApplyId())
                AidApplyList.applyDataList.remove(applyData);
        }
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.setBalance(aidCheck.getBalance());
        transferRequest.setTimestamp(aidCheck.getTimestamp());
        transferRequest.setToAddress(aidCheck.getToAddress());
        transferRequest.setSign(aidCheck.getSign());
        Boolean result = transfer(transferRequest);

        TransferRequest transferFee = new TransferRequest();
        transferFee.setBalance(aidCheck.getBalance().multiply(BigDecimal.valueOf(0.1)));
        transferFee.setTimestamp(aidCheck.getTimestamp());
        transferFee.setToAddress("0003");
        transferFee.setSign(aidCheck.getSign());
        Boolean result1 = transfer(transferFee);
        return "success";
    }
}
