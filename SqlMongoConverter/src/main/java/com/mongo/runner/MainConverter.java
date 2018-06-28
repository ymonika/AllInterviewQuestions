package com.mongo.runner;

import com.mongo.converter.InsertQueryConverter;
import com.mongo.converter.SelectQueryConverter;
import com.mongo.mongo.query.InsertMongoQuery;
import com.mongo.sql.query.InsertSqlQuery;
import com.mongo.sql.query.SelectSqlQuery;

public class MainConverter {


    public static void main(String[] args) {

        String sqlQ1 = "SELECT * FROM identityActions";
        String sqlQ2 = "SELECT lastLoginTimestampUtc, uid, lastAccessedTimestampUtc FROM identityActions";
        SelectSqlQuery selectSqlQuery1 = new SelectSqlQuery(sqlQ1);
        SelectSqlQuery selectSqlQuery2 = new SelectSqlQuery(sqlQ2);
        SelectQueryConverter selectQueryConverter = new SelectQueryConverter();
        System.out.println(selectQueryConverter.getMongoQuery(selectSqlQuery1));
        System.out.println(selectQueryConverter.getMongoQuery(selectSqlQuery2));

        String i1 = "INSERT INTO identityActions(uid,lastAccessedTimestampUtc) VALUES (122323, 2014-12-12)";
        String i2 = "INSERT INTO identityActions(lastAccessedTimestampUtc,lastModifiedTimestampUtc, uid) VALUES (2017-05-10T06:14:08.678Z,2017-05-10T06:14:08.678Z,uid-7878)," +
                "(2017-05-10T06:14:08.678Z,2017-05-10T06:14:08.678Z,uid-7979)";

        InsertSqlQuery insertSqlQuery1 = new InsertSqlQuery(i1);
        InsertSqlQuery insertSqlQuery2 = new InsertSqlQuery(i2);
        InsertQueryConverter insertQueryConverter = new InsertQueryConverter();

        System.out.println(insertQueryConverter.getMongoQuery(insertSqlQuery1));
        System.out.println(insertQueryConverter.getMongoQuery(insertSqlQuery2));

    }
}
