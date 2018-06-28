package com.mongo.runner;

import com.mongo.converter.DeleteQueryConverter;
import com.mongo.converter.InsertQueryConverter;
import com.mongo.converter.SelectQueryConverter;
import com.mongo.sql.query.DeleteSqlQuery;
import com.mongo.sql.query.InsertSqlQuery;
import com.mongo.sql.query.SelectSqlQuery;

public class MainConverter {


    public static void main(String[] args) {

        String sqlQ1 = "SELECT * FROM identityActions";
        String sqlQ2 = "SELECT lastLoginTimestampUtc, uid, lastAccessedTimestampUtc FROM identityActions";
        String sqlQ3 = "SELECT * FROM identityActions WHERE uid=122323";
        String sqlQ4 = "SELECT * FROM identityActions WHERE uid=122323 AND email=abc@abc";
        String sqlQ5 = "SELECT lastLoginTimestampUtc, uid FROM identityActions WHERE uid=122323 AND email=abc@abc";

        SelectQueryConverter selectQueryConverter = new SelectQueryConverter();

        System.out.println(selectQueryConverter.getMongoQuery(new SelectSqlQuery(sqlQ1)));
        System.out.println(selectQueryConverter.getMongoQuery(new SelectSqlQuery(sqlQ2)));
        System.out.println(selectQueryConverter.getMongoQuery(new SelectSqlQuery(sqlQ3)));
        System.out.println(selectQueryConverter.getMongoQuery(new SelectSqlQuery(sqlQ4)));
        System.out.println(selectQueryConverter.getMongoQuery(new SelectSqlQuery(sqlQ5)));

        System.out.println("______________________________________________");

        String i1 = "INSERT INTO identityActions (uid,lastAccessedTimestampUtc) VALUES (122323, 2014-12-12)";
        String i2 = "INSERT INTO identityActions (lastAccessedTimestampUtc,lastModifiedTimestampUtc, uid,email) VALUES " +
                " (2017-05-10T06:14:08.678Z,2017-05-10T06:14:08.678Z, uid-7878, abc@abc)," +
                " (2017-05-10T06:14:08.678Z,2017-05-10T06:14:08.678Z, uid-7979, anc)";

        InsertQueryConverter insertQueryConverter = new InsertQueryConverter();

        System.out.println(insertQueryConverter.getMongoQuery(new InsertSqlQuery(i1)));
        System.out.println(insertQueryConverter.getMongoQuery(new InsertSqlQuery(i2)));

        System.out.println("______________________________________________");

        String d1 = "DELETE FROM identityActions";
        String d2 = "DELETE FROM identityActions WHERE uid=122323";
        String d3 = "DELETE FROM identityActions WHERE uid = 122323, email = abc@abc";

        DeleteQueryConverter deleteQueryConverter = new DeleteQueryConverter();

        System.out.println(deleteQueryConverter.getMongoQuery(new DeleteSqlQuery(d1)));
        System.out.println(deleteQueryConverter.getMongoQuery(new DeleteSqlQuery(d2)));
        System.out.println(deleteQueryConverter.getMongoQuery(new DeleteSqlQuery(d3)));

        System.out.println("______________________________________________");

        String u1 = "UPDATE identityActions SET uid=XYZ WHERE uid=122323";
        String u2 = "UPDATE identityActions SET uid=XYZ, email = abc@abc WHERE uid=122323";

    }
}
