package com.DgzqMongoObm;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Data {
    public static String MongoId(){
        return new ObjectId().toHexString();
    }

    public static String getDateTime(){
        LocalDateTime now = LocalDateTime.now();
        // 定义格式化模板
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        // 格式化时间
        String formattedTime = now.format(formatter);
        return formattedTime;
    }


    public  static String getStockCode() {

        String str = "{ \"_id\":\""+ MongoId() +"\",\n"+
                "  \"userId\": \"ecEpKNdpkPWs5iQ1wXMTNQ==\",\n" +
                "  \"md5\": \"988b46e278f42ef2445c56b615e4c6f4\",\n" +
                "  \"updateFlag\": \"1\",\n" +
                "  \"updateTime\":\""+getDateTime()+"\",\n" +
                "  \"stockList\": [\n" +
                "    {\"market\": \"2\",\"stockCode\": \"000001\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"399001\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"002326\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"002643\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"5\",\"stockCode\": \"301766\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"000930\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"2\",\"stockCode\": \"601766\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"000050\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"002756\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"2\",\"stockCode\": \"999999\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"002182\",\"createTime\": \""+getDateTime()+"\"}\n" +
                "  ],\n" +
                "  \"stockGroup\": {\n" +
                "    \"879930ce-672a-42dc-9077-fec9367e92e1\": [\n" +
                "      {\"market\": \"1\",\"stockCode\": \"600000\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "      {\"market\": \"0\",\"stockCode\": \"002271\",\"createTime\": \""+getDateTime()+"\"}\n" +
                "    ],\n" +
                "\t\"aaaaaaaa-672a-42dc-9077-fec9367e92e1\": [\n" +
                "      {\"market\": \"1\",\"stockCode\": \"99999\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "      {\"market\": \"0\",\"stockCode\": \"888888\",\"createTime\": \""+getDateTime()+"\"}\n" +
                "    ]},\n" +
                "\"nStockList\": [\n" +
                "    {\"market\": \"1\",\"stockCode\": \"000001\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"399001\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"002326\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"002643\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"2\",\"stockCode\": \"017686\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"000930\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"1\",\"stockCode\": \"601766\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"000050\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"002756\",\"createTime\": \""+getDateTime()+"\"},\n" +
                "    {\"market\": \"0\",\"stockCode\": \"002182\",\"createTime\": \""+getDateTime()+"\"}\n" +
                "  ],\"_class\": \"com.dz.model.TOptionalStock\"\n" +
                "}";
        return str;
    }
}
