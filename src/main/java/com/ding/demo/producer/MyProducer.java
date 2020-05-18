package com.ding.demo.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author ding
 * @date 2020/5/15
 */
public class MyProducer {

    private static KafkaProducer<String,String> producer;


    static {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","");
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,"com.ding.demo.patitioners.MyPartitioner");
        producer =  new KafkaProducer<>(properties);
    }

    private static void sendMessage(){
        ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", 0, "key", "v");
        producer.send(record);
    }

}
