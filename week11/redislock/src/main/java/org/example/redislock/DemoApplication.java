package org.example.redislock;

import org.example.redislock.util.RedisTool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    //锁
    private final static String LOCK = "redis_lock";
    //超时时间
    private final static int EXPIRE = 3;

    private static int amount = 10;


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(DemoApplication.class, args);
        Thread thread1 = new Thread(DemoApplication::testLock);
        Thread thread2 = new Thread(DemoApplication::testLock);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        Thread thread3 = new Thread(DemoApplication::testLock);
        thread3.start();
        thread3.join();
    }
    public static void testLock(){
        System.out.println("testLock开始");
        String requestId=RedisTool.getUUID();
        //首次获取会失败，因为没有锁
        if (!RedisTool.tryGetDistributedLock(LOCK,requestId,EXPIRE)) {
            System.out.println("获取锁失败");
            return;
        }

        try {
            Thread.sleep(10000);
            amount -= 1;
            System.out.printf("库存减一 amount: %d\n", amount);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        RedisTool.releaseDistributedLock(LOCK,requestId);
        System.out.println("lock test:: end");
    }
}
