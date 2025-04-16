package com.DgzqMongoObm;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import org.bson.Document;


public class Demo {
    public static void main(String[] args) {

//      指定数据库名称与集合名
        String dbname = "test";
        String collectionname = "OptionalStock";

//      指定性查询库中集合转存list数组
        System.out.println("MongoDB中"+dbname+"库中的集合列表:"+MongoDBUtil.getAllCollection(dbname));

//      创建mongodb客户端连接对象
        MongoCollection<Document> mongoCollection ;
        MongoClient mongoClient = MongoDBUtil.getMongoClient();
        mongoCollection = mongoClient.getDatabase(dbname).getCollection(collectionname);

        int limit = 10;
        int count = limit;
        try {

            while (limit > 0) {
                Document document = Document.parse(Data.getStockCode());
                mongoCollection.insertOne(document);
                limit--;
                int sum=count-limit;
                System.out.println("insert into collection:NO."+sum);
            }
        } catch (Exception e) {
            System.err.println("error:" + e.getMessage());
        }

//      关闭资源
        MongoDBUtil.closeAll(mongoClient);
    }
}
