package com.ding.demo.producer;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author ding
 * @date 2020/5/15
 */
public class ProducerDemo {

    private static KafkaProducer<String,String> producer;

    /**
     * 创建发送者
     */
    static {
        Properties properties = new Properties();
        // broker 列表
        properties.put("bootstrap.servers","broker1:9092,broker2:9092");
        // 设定键值序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        producer =  new KafkaProducer<>(properties);
    }

    /**
     * 发送演示
     * 必传参数:
     * Topic, Value
     */
    // 最简单的直接发送
    private void sendMessage(){
        // 构造消息, 必穿参数Topic , Value
        ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", 0, "key", "v");
        try {
            RecordMetadata recordMetadata = producer.send(record).get();
            // 返回的元数据里面包含重要的 offset , partition 数据
            recordMetadata.offset();
            recordMetadata.partition();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 异步发送, 需要提供回调
    private void sendMessageAsyn(){
        ProducerRecord<String, String> record = new ProducerRecord<>("test-topic", 0, "key", "v");
        producer.send(record,new CallBackDemo());
    }

    // 实现kafak 的 CallBack 接口
    class CallBackDemo implements Callback{
        @Override
        public void onCompletion(RecordMetadata metadata, Exception exception) {
            if(exception != null){
                exception.printStackTrace();
            }
        }
    }

    /**
     * 自定义分区器
     */
    public class   BananaPartitioner implements Partitioner{
        // 演示了 key == banana 的消息, 总是分配到最后一个分区,
        // 其他消息 散列到其他分区
        @Override
        public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
            List<PartitionInfo> partitionInfos = cluster.partitionsForTopic(topic);
            int lastPartitionNumber = partitionInfos.size();
            if ("Banana".equalsIgnoreCase((String) key)){
                return lastPartitionNumber;
            }
            return (Math.abs(Utils.murmur2(keyBytes))%(lastPartitionNumber - 1));
        }

        @Override
        public void close() {

        }

        @Override
        public void configure(Map<String, ?> configs) {

        }
    }

}
