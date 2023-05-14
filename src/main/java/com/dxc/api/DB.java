package com.dxc.api;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class DB {
    private static Log log = LogFactory.getLog(ConnectDbImp.class);
    final static String dbName = "test";
    final static String port = "27016";
    final static String username = "test";
    final static String pwd = "a";

    static public MongoDatabase create_db() {
        String uri = "mongodb://" + username + ":" + pwd + "@localhost:" + port + "/?authSource=" + dbName;

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(uri))
                .build();

        // Create a new client and connect to the server
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("test");
        try {
            // Send a ping to confirm a successful connection
//                Bson command = new BsonDocument("ping", new BsonInt64(1));
//                Document commandResult = database.runCommand(command);
            log.info("You successfully connected to MongoDB!");
        } catch (MongoException me) {
            log.debug(me);
        }
        return database;

    }
}
