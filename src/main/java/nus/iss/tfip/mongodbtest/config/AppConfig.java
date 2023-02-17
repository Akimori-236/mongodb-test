package nus.iss.tfip.mongodbtest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import nus.iss.tfip.mongodbtest.Constants;

@Configuration
public class AppConfig implements Constants {

    // get mongo URL from app.properties
    @Value("${mongo.url}")
    private String mongoUrl;

    @Bean
    public MongoDatabase getMongoDB() {
        // create a client
        MongoClient client = MongoClients.create(mongoUrl);
        // Get DB from client
        MongoDatabase db = client.getDatabase(DB_BGG);
        // Use collection
        // MongoCollection<Document> apps = db.getCollection(COLLECTION_APPS, Document.class);
        return db;
    }
}
