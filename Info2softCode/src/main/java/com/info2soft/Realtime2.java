package com.info2soft;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Callable;

public class Realtime2 implements Callable<String> {
    public String call() throws Exception {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.1.111.228:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        ProducerRecord<String, String> record;

//      增量循环起始值
        int num = 1;
//      循环结束值
        int limit = 100;
//      增量键
        String key = "realtime";
//      realtime 映射目标端复合主键1
        String code = "688692";
//      realtime映射目标端复合主键2
        String setCode = "1";

        while (num <= limit) {
            Thread.sleep(100);
            // 创建 Kafka 消息记录
            record = new ProducerRecord<>("realtime", key, Data2.getData(key, code, setCode));
            // 发送 Kafka 消息记录
            producer.send(record);
            if (num == limit) {break;}
            num++;
            code = String.valueOf(Integer.parseInt(code) + 1);
            setCode = String.valueOf(Integer.parseInt(setCode) + 1);
        }
        producer.close();
        return "Realtime Success";

    }
}