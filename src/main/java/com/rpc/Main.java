package com.rpc;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by shashank on 10/18/16.
 */
public class Main {

    public Main(){
        try{
            RPCServer consumer = new RPCServer();
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();


        RPCClient producer = new RPCClient();
            for(int i=0 ; i<100;i++){
                producer.testClient(Integer.toString(i));
            }

        }
        catch (Exception e){
            System.out.print("Failed to make a xonsumer");
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
