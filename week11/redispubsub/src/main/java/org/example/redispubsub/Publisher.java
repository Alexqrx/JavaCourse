package org.example.redispubsub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 订单生产者
 */
public class Publisher extends Thread{

    private final JedisPool jedisPool;

    public Publisher(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @Override
    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Jedis jedis=jedisPool.getResource();
        while (true){
            String line;
            try {
                line= br.readLine();
                if(!"quit".equals(line)){
                    jedis.publish("mychannel",line);
                    System.out.println(String.format("发布消息成功！channel： %s, message： %s", "mychannel", line));
                }else{
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
