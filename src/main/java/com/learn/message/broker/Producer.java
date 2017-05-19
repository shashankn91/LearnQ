package com.learn.message.broker;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rabbitmq.client.AMQP;

import java.io.IOException;

public class Producer extends EndPoint{

    private Gson gson;
    public Producer(String endPointName) throws IOException{
        super(endPointName);
        gson = new GsonBuilder().create();
    }

    public void sendMessage(Object object) throws IOException {
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .contentType("application/json")
                .build();

        channel.exchangeDeclare(endPointName, "fanout");
        channel.basicPublish(endPointName, "", null, gson.toJson(object,TransactionRequest.class).getBytes());
    }
}