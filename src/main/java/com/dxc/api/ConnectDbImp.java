package com.dxc.api;

import com.mongodb.client.MongoDatabase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConnectDbImp implements ConnectDb{
    private static Log log = LogFactory.getLog(ConnectDbImp.class);
    private static MongoDatabase db = null;

    @Override
    public MongoDatabase get_db() {
        return db;
    }

    ConnectDbImp() {
        if (db == null)
            db = DB.create_db();
    }



}
