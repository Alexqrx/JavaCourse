package io.kimmking.javacourse.mq.activemq;

public class ActiveMQServer1 {
    public static void main(String[] args){
        Comsumer comsumer = new Comsumer();
        comsumer.init();
        ActiveMQServer1 testConsumer = new ActiveMQServer1();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
        new Thread(testConsumer.new ConsumerMq(comsumer)).start();
    }

    private class ConsumerMq implements Runnable{
        Comsumer comsumer;
        public ConsumerMq(Comsumer comsumer){
            this.comsumer = comsumer;
        }

        @Override
        public void run() {
            while(true){
                try {
                    comsumer.getMessage("AlexCourse-MQ");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
