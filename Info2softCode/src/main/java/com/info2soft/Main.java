package com.info2soft;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONObject;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建 Kafka 生产者配置

//        String key1 = "rtmin";
//        String key2 = "realtime";

//        JSONObject jsonObject = new JSONObject();

        ExecutorService executorService = Executors.newCachedThreadPool();

//        int num = 0;
//        while (num < 3) {
//            Future<String> rtmin = executorService.submit(new Rtmin());
//            Future<String> realtime = executorService.submit(new Realtime());
//            System.out.println(rtmin.get());
//            System.out.println(realtime.get());
//            num++;
//        }
        executorService.submit(new Rtmin());
        executorService.submit(new Realtime());

        executorService.submit(new Rtmin());
        executorService.submit(new Realtime1());

        executorService.submit(new Rtmin());
        executorService.submit(new Realtime2());

        executorService.shutdown();


//        增量循环起始值
//        int num=1;

//        增量循环结束值
//        int limit = 120;


//        while (num<=limit) {

//            jsonObject.put("rtmin",rtmin.get());
//            jsonObject.put("realtime",realtime.get());
//                获取key值
//                String k1 = jsonObject.keySet().toArray()[0].toString();
//                System.out.println(v1);
//                String k2 = jsonObject.keySet().toArray()[1].toString();
        //获取value --json{}两边不会打印双引，toString的话 会有双引，kafka识别不了
//            String v1 = jsonObject.getString(k1);
//            String v2 = jsonObject.getString(k2);

        // 创建 Kafka 消息记录
//            record = new ProducerRecord<>("rtmin",key1 ,rtmin.get() );
//            record2 = new ProducerRecord<>("realtime", key2, realtime.get());
//
        // 发送 Kafka 消息记录
//            producer.send(record);
//            producer.send(record2);
//            if (num == limit){break;}
//            num++;
//            code = String.valueOf(Integer.parseInt(code)+1);
//            market++;
//            setCode =String.valueOf(Integer.parseInt(setCode)+1);


//        }
//        producer.close();
//        executorService.shutdown();

    }

}