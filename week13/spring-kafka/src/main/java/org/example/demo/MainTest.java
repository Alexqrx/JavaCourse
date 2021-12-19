package org.example.demo;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;

public class MainTest {
    public static void main(String[] args) {
        String servers = "hadoop01:9092,hadoop02:9092,hadoop03:9092";
        String topic = "TestTopic";
        String message = "test221";

        KafkaProducer<String, String> producer = KafkaUtil.createProducer(servers);
        KafkaUtil.send(producer, topic, message);

        KafkaConsumer<String, String> consumer = KafkaUtil.createConsumer(servers, topic);
        KafkaUtil.readMessage(consumer, 100);
    }
}
