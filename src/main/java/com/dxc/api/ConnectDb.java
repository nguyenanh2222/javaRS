package com.dxc.api;

import com.mongodb.client.MongoDatabase;

public interface ConnectDb {
    MongoDatabase get_db();
}
