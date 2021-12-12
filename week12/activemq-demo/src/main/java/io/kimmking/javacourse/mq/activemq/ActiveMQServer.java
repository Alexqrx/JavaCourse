package io.kimmking.javacourse.mq.activemq;

public class ActiveMQServer {

    public static void main(String[] args) {
        // 尝试用java代码启动一个ActiveMQ broker server
        // 然后用前面的测试demo代码，连接这个嵌入式的server
        Producter producter=new Producter();
        producter.init();
        ActiveMQServer aq=new ActiveMQServer();

        try{
            System.out.println("aaaaaaa");
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        //Thread 1
        new Thread(aq.new ProductorMq(producter)).start();
        //Thread 2
        new Thread(aq.new ProductorMq(producter)).start();
        //Thread 3
        new Thread(aq.new ProductorMq(producter)).start();
        //Thread 4
        new Thread(aq.new ProductorMq(producter)).start();

    }

    private class ProductorMq implements Runnable{
        Producter producter;
        public ProductorMq(Producter producter){
            this.producter=producter;
        }
        @Override
        public void run() {
            while (true){

                try {
                    producter.sendMessage("AlexCourse-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
