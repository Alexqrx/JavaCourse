package org.example.redislock.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collections;
import java.util.UUID;

public class RedisTool {
    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;
    private static JedisPool jedisPool = new JedisPool();
    /**
     *尝试获取分布式锁
     *jedis Redis客户端
     * key 锁唯一
     * requestId可以使用UUID，可以当作加锁的人
     *expireTime 超时时间
     *return 是否获取成功
     */
    public static boolean tryGetDistributedLock(String key,String requestId,int expireTime){
        Jedis jedis=jedisPool.getResource();
        String result=jedis.set(key,requestId,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        if(LOCK_SUCCESS.equals(result)){
            return true;
        }
        return false;
    }
    /**
     * 释放锁
     *jedis.eval()方法是把代码交给redis服务端执行
     */
    public static boolean releaseDistributedLock(String lockKey, String requestId) {
        Jedis jedis=jedisPool.getResource();
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }
    /**
     * 获取UUID
     */
    public static String getUUID(){
        String requestId=UUID.randomUUID().toString();
        return requestId;
    }

}
