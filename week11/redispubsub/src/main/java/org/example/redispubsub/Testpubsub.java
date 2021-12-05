package org.example.redispubsub;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Testpubsub {
    public static void main(String[] args) {
        JedisPool jp=new JedisPool(new JedisPoolConfig(),"192.168.249.115",6379);
        Publisher publisher = new Publisher(jp);    //发布者
        publisher.start();

        Subscriber subscriber = new Subscriber(jp);    //订阅者
        subscriber.start();

    }
}
