package com.info2soft;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONObject;

import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        // 创建 Kafka 生产者配置
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.1.111.228:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.ACKS_CONFIG, "all");

        // 创建 Kafka 生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
        String k1 = "rtmin";
        String k2 = "realtime";

        // 创建 JSON 数据
        JSONObject jsonObject = new JSONObject();


//      增量循环起始值
        int num=1;
//      topic--rtmin、realtime 映射目标端复合主键1
        String code="688692";
//      topic--rtmin 映射目标端复合主键2
        int market=num;
//      topic--realtime 映射目标端复合主键2
        String setCode="1";
//      增量循环结束值
        int limit = 120;
        ProducerRecord<String, String> record;
        ProducerRecord<String, String> record2;

        while (num<=limit) {
            synchronized (producer) {
                jsonObject.put(k1,setData(k1,code,market,setCode));
                jsonObject.put(k2, setData(k2,code,market,setCode));
//                获取key值
//                String k1 = jsonObject.keySet().toArray()[0].toString();
//                System.out.println(v1);
//                String k2 = jsonObject.keySet().toArray()[1].toString();
                //获取value --json{}两边不会打印双引，toString的话 会有双引，kafka识别不了
                String v1 = jsonObject.getString(k1);
                String v2 = jsonObject.getString(k2);

                // 创建 Kafka 消息记录
                record = new ProducerRecord<>("rtmin", k1, v1);
                record2 = new ProducerRecord<>("realtime", k2, v2);

                // 发送 Kafka 消息记录
                producer.send(record);
                producer.send(record2);
                if (num == limit){break;}
                num++;
                code = String.valueOf(Integer.parseInt(code)+1);
                market++;
                setCode =String.valueOf(Integer.parseInt(setCode)+1);

                try {
                    producer.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                producer.notify();
            }
        }

        // 关闭 Kafka 生产者
        producer.close();
    }
    public static String setData(String key ,String code ,int market,String setCode){

        String s1="{\"mf\"" +
                ":{\"iAmtOfBuy\":[573029,443659,0,101,100],\n" +
                "\"iVolOfBuy\":[54500,42200,0,0],\n" +
                "\"iAmtOfSell\":[390152,0,525500,0],\n" +
                "\"iVolOfSell\":[37100,0,50000,0],\n" +
                "\"iNumOfSell\":[5,0,1,0],\n" +
                "\"iBuyNum\":[56,8,0,0]},\n" +
                "\"time\":2411111341,\n" +
                "\"code\":\""+code+"\",\n" +
                "\"market\":"+market+"}";
        String s2="{\"afterDealAmount\" : 10.0,\n" +
                "\"afterDealVol\" : 0.0,\n" +
                "\"amp\" : 0.0807,\n" +
                "\"avgPrice\" : 447.954,\n" +
                "\"bizTime\" : 20241111153013016,\n" +
                "\"boardDays\" : 0,\n" +
                "\"buy\" : 7154.0,\n" +
                "\"buyPrice1\" : 458.0,\n" +
                "\"buyPrice2\" : 457.13,\n" +
                "\"buyPrice3\" : 457.0,\n" +
                "\"buyPrice4\" : 456.81,\n" +
                "\"buyPrice5\" : 456.15,\n" +
                "\"buyVolumes1\" : 61.0,\n" +
                "\"buyVolumes2\" : 2.0,\n" +
                "\"buyVolumes3\" : 4.0,\n" +
                "\"buyVolumes4\" : 5.0,\n" +
                "\"buyVolumes5\" : 2.0,\n" +
                "\"category\" : 27,\n" +
                "\"changeRatio\" : 0.0269,\n" +
                "\"changeValue\" : 12.0,\n" +
                "\"changeValueBp\" : 0.0,\n" +
                "\"circulationMarketValue\" : 6.542554274E9,\n" +
                "\"circulationStocks\" : 1.4285053E7,\n" +
                "\"code\" : \""+code+"\",\n" +
                "\"comparison\" : 0.4369,\n" +
                "\"contractPosition\" : 0.0,\n" +
                "\"conversionPremiumRate\" : 0.0,\n" +
                "\"conversionValue\" : 0.0,\n" +
                "\"currYearchangeRatio\" : 4.3343,\n" +
                "\"day10changeRatio\" : 0.4869,\n" +
                "\"day5changeRatio\" : 0.3921,\n" +
                "\"dealAmount\" : 6.37277492E8,\n" +
                "\"dealNum\" : 0,\n" +
                "\"dealVol\" : 14226.0,\n" +
                "\"dropNum\" : 0,\n" +
                "\"dropStopNum\" : 0,\n" +
                "\"entrustBuy\" : 74.0,\n" +
                "\"entrustDiff\" : 45.0,\n" +
                "\"entrustSell\" : 29.0,\n" +
                "\"flatNum\" : 0,\n" +
                "\"fundNetWorth\" : 40.49636604,\n" +
                "\"fundRtReferenceNetWorth\" : 0.0,\n" +
                "\"highPrice\" : 464.0,\n" +
                "\"incomePer10w\" : 0.0,\n" +
                "\"incomePer1k\" : 0.0,\n" +
                "\"incomeRatePerYear\" : 0.0,\n" +
                "\"isZT\" : 0,\n" +
                "\"latestChangeValue\" : 1.19,\n" +
                "\"limitDownPrc\" : 356.8,\n" +
                "\"limitUpPrc\" : 535.2,\n" +
                "\"lowPrice\" : 428.0,\n" +
                "\"lowerLimitPrice\" : 0.0,\n" +
                "\"month1changeRatio\" : 0.5374,\n" +
                "\"month3changeRatio\" : 1.1233,\n" +
                "\"name\" : \"达梦数据\",\n" +
                "\"netIn\" : -1.2413485E7,\n" +
                "\"netIn10\" : 4180574.0,\n" +
                "\"netIn20\" : -4.6625146E7,\n" +
                "\"netIn3\" : -3.235385E7,\n" +
                "\"netIn5\" : -1.9579525E7,\n" +
                "\"netRatio\" : -0.0195,\n" +
                "\"netRatio10\" : 8.0E-4,\n" +
                "\"netRatio20\" : -0.0057,\n" +
                "\"netRatio3\" : -0.0171,\n" +
                "\"netRatio5\" : -0.0072,\n" +
                "\"norminalPrice\" : 0.0,\n" +
                "\"nowPrice\" : 458.0,\n" +
                "\"numTrades\" : 0,\n" +
                "\"openPrice\" : 434.26,\n" +
                "\"ordImbDirection\" : 0,\n" +
                "\"ordImbQty\" : 0,\n" +
                "\"ordbPrice\" : 0.0,\n" +
                "\"ordbQty\" : 0,\n" +
                "\"origDealVol\" : 1422640.0,\n" +
                "\"pbRatio\" : 11.31,\n" +
                "\"peRatio\" : 149.72,\n" +
                "\"peRatioStatic\" : 117.56,\n" +
                "\"peRatioTTM\" : 98.82,\n" +
                "\"posLowerLimitAskPrice\" : 0.0,\n" +
                "\"posLowerLimitBidPrice\" : 0.0,\n" +
                "\"posUpperLimitAskPrice\" : 0.0,\n" +
                "\"posUpperLimitBidPrice\" : 0.0,\n" +
                "\"preWeightedPx\" : 0.0,\n" +
                "\"premiumRate\" : 0.0,\n" +
                "\"priceChangeFlag\" : 1,\n" +
                "\"qrr\" : 1.138,\n" +
                "\"redeemPrice\" : 0.0,\n" +
                "\"refPrice\" : 0.0,\n" +
                "\"riseNum\" : 0,\n" +
                "\"riseStopNum\" : 0,\n" +
                "\"sell\" : 7009.0,\n" +
                "\"sellPrice1\" : 458.03,\n" +
                "\"sellPrice2\" : 458.2,\n" +
                "\"sellPrice3\" : 459.94,\n" +
                "\"sellPrice4\" : 459.97,\n" +
                "\"sellPrice5\" : 460.0,\n" +
                "\"sellVolumes1\" : 3.0,\n" +
                "\"sellVolumes2\" : 14.0,\n" +
                "\"sellVolumes3\" : 2.0,\n" +
                "\"sellVolumes4\" : 1.0,\n" +
                "\"sellVolumes5\" : 9.0,\n" +
                "\"setCode\" : \""+setCode+"\",\n" +
                "\"shareWarrantPremiumRate\" : 0.0,\n" +
                "\"speedUp\" : 0.0044,\n" +
                "\"subCategory\" : 0,\n" +
                "\"summaryBuyPrice\" : 0.0,\n" +
                "\"summarySellPrice\" : 0.0,\n" +
                "\"timestamp4Day\" : 0,\n" +
                "\"totalChangeRatio\" : 0.0269,\n" +
                "\"totalMarketValue\" : 3.4808E10,\n" +
                "\"totalStocks\" : 7.6E7,\n" +
                "\"tradeDate\" : 20241111,\n" +
                "\"tradeStatus\" : 1,\n" +
                "\"tradeTime\" : 153013,\n" +
                "\"turnoverRate\" : 0.0996,\n" +
                "\"upperLimitPrice\" : 0.0,\n" +
                "\"week52HighPrice\" : 464.4,\n" +
                "\"week52LowPrice\" : 188.93,\n" +
                "\"weightedAvgBp\" : 0.0,\n" +
                "\"weightedAvgPx\" : 0.0,\n" +
                "\"yclosePrice\" : 446.0,\n" +
                "\"year1changeRatio\" : 4.3343\n" +
                "  }\n";
        if (key=="rtmin"){
            return s1;
        }
        else if (key=="realtime"){return s2;}
        return null;
    }
}