package com.learn.message.broker;


import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by shashank on 4/27/17.
 */
public class TransactionRequest {

    public enum TransactionRequestType {
        ADD_CT_CREDITS("ADD_CT_CREDITS"),
        REDEEM_CT_CREDITS("REDEEM_CT_CREDITS"),
        INSTANT_CREDITS("INSTANT_CREDITS");

        String transactionRequestType;
        TransactionRequestType(String transactionRequestType) {
            this.transactionRequestType = transactionRequestType;
        }
    }

    private String userId;

    private Date expiry;

    private BigDecimal amount;

    private String campaignName;

    private String clientTransactionId;

    private String clientName;

    private TransactionRequestType transactionRequestType;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getClientTransactionId() {
        return clientTransactionId;
    }

    public void setClientTransactionId(String clientTransactionId) {
        this.clientTransactionId = clientTransactionId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public TransactionRequestType getTransactionRequestType() {
        return transactionRequestType;
    }

    public void setTransactionRequestType(TransactionRequestType transactionRequestType) {
        this.transactionRequestType = transactionRequestType;
    }
}
