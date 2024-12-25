package com.info2soft;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Callable;

public class Rtmin implements Callable<String> {
    @Override
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
//      判断返回哪串
        String key = "rtmin";
//      rtmin映射目标端复合主键1
        String code = "688692";
//      rtmin 映射目标端复合主键2
        int market = 1;
//      增量循环结束值
        int limit = 100;


        while (num <= limit) {
            Thread.sleep(100);
            // 创建 Kafka 消息记录
            record = new ProducerRecord<>("rtmin", key, Data.getData(key, code, market));
            // 发送 Kafka 消息记录
            producer.send(record);
            if (num == limit) {break;}
            num++;
            code = String.valueOf(Integer.parseInt(code) + 1);
            market++;
        }
        producer.close();
        return "Rtmin Success";

    }
}
