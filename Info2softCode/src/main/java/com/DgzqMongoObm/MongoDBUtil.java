package com.DgzqMongoObm;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * DB通用类，公用方法区
 */
public class MongoDBUtil {

    static MongoClientURI mongoClientURI ;
    static MongoClient mongoClient ;
    static MongoDatabase mongoDatabase ;
    static CompositeConfiguration config ;

    static {
        System.out.println("====================MongoDBUtil====================");
        config = new CompositeConfiguration();

        try {
            config.addConfiguration(new PropertiesConfiguration("src/MongoDB.properties"));
            String host = config.getString("host");
            String port = config.getString("port");
            String user = config.getString("username");
            String password = config.getString("password");
            String database = config.getString("database");
            String s = "mongodb://" + user + ":" + password + "@" + host + ":" + port + "/" + database;
            mongoClientURI = new MongoClientURI(s);
            mongoClient = new MongoClient(mongoClientURI);
            mongoDatabase = mongoClient.getDatabase(database);

        } catch (ConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取Mongo连接
     * @return 客户端连接对象
     */
    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    /**
     * 获取Mongo数据库
     * @return 数据库连接对象
     */
    public static MongoDatabase getMongoDatabase() {
        return mongoDatabase;
    }

    /**
     * 获取集合列表
     * @return 指定数据库中所有集合
     */
    public static List<String> getAllCollection(String dbname) {
        MongoIterable<String> collections = mongoClient.getDatabase(dbname).listCollectionNames();
        List<String> list = new ArrayList<>();
        for (String collection : collections) {
            list.add(collection);
        }
        return list;
    }

    /**
     * 获取集合对象
     * @param dbname
     * @param collectionName
     * @return 指定数据库指定集合对象
     */
    public static MongoCollection<Document> getCollection(String dbname ,String collectionName) {
        return mongoClient.getDatabase(dbname).getCollection(collectionName);
    }

    /**
     * 关闭资源
     * @param mongoClient
     */
    public static void closeAll(MongoClient mongoClient) {
        mongoClient.close();
    }
}