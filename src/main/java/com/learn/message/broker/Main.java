package com.learn.message.broker;

import com.google.gson.Gson;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class Main {
    public Main() throws Exception{


        /*
        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        */
        Producer producer = new Producer("hello");

        for (int i = 0; i < 100000; i++) {
            HashMap message = new HashMap();
            TransactionRequest transactionRequest = new TransactionRequest();
        //http://cleartaxcredits-env-staging.us-east-1.elasticbeanstalk.com/user/vendor/d8d994dd-c3fb-4363-b722-b34c3ad71fa1/paytm
        String messageID = UUID.randomUUID().toString();
            transactionRequest.setUserId("1234ufgg");
            transactionRequest.setAmount(new BigDecimal(10));
            transactionRequest.setCampaignName("referral");
            transactionRequest.setClientTransactionId(messageID);
            System.out.println("ClientID is = " + messageID);
            transactionRequest.setClientName("tst");
            transactionRequest.setTransactionRequestType(TransactionRequest.TransactionRequestType.INSTANT_CREDITS);
            Gson gson = new Gson();
            String json = gson.toJson(transactionRequest);

            message.put("message number", i);
            producer.sendMessage(transactionRequest);
            System.out.println("Message Number "+ i +" sent.");
        }
    }

    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
        new Main();
    }
}