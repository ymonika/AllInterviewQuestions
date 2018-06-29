package com.mongo.runner;

import com.mongo.converter.*;
import com.mongo.mongo.query.MongoQuery;
import com.mongo.sql.query.DeleteSqlQuery;
import com.mongo.sql.query.InsertSqlQuery;
import com.mongo.sql.query.SelectSqlQuery;
import com.mongo.sql.query.UpdateSqlQuery;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainConverter {


    static public MongoQuery getMongoQuery(String sql) {
        QueryConverter queryConverter;
        MongoQuery mongoQuery = null;
        if (sql.startsWith("SELECT")) {
            queryConverter = new SelectQueryConverter();
            mongoQuery = queryConverter.covertToMongoQuery(new SelectSqlQuery(sql));
        } else if (sql.startsWith("INSERT")) {
            queryConverter = new InsertQueryConverter();
            mongoQuery = queryConverter.covertToMongoQuery(new InsertSqlQuery(sql));
        } else if (sql.startsWith("DELETE")) {
            queryConverter = new DeleteQueryConverter();
            mongoQuery = queryConverter.covertToMongoQuery(new DeleteSqlQuery(sql));
        } else if (sql.startsWith("UPDATE")) {
            queryConverter = new UpdateQueryConverter();
            mongoQuery = queryConverter.covertToMongoQuery(new UpdateSqlQuery(sql));
        }
        return mongoQuery;
    }


    public static void main(String[] args) throws Exception {

        File file = new File("/home/cts1/projects/personal/AllInterviewQuestions/SqlMongoConverter/src/main/resources/input.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        bufferedReader.lines().forEach(line -> {
            System.out.println(getMongoQuery(line));
        });

        /*


        String sqlQ1 = "SELECT * FROM identityActions";
        String sqlQ2 = "SELECT lastLoginTimestampUtc, uid, lastAccessedTimestampUtc FROM identityActions";
        String sqlQ3 = "SELECT * FROM identityActions WHERE uid=122323";
        String sqlQ4 = "SELECT * FROM identityActions WHERE uid=122323 AND email=abc@abc";
        String sqlQ5 = "SELECT lastLoginTimestampUtc, uid FROM identityActions WHERE uid=122323 AND email=abc@abc";

        SelectQueryConverter selectQueryConverter = new SelectQueryConverter();

        System.out.println(selectQueryConverter.covertToMongoQuery(new SelectSqlQuery(sqlQ1)));
        System.out.println(selectQueryConverter.covertToMongoQuery(new SelectSqlQuery(sqlQ2)));
        System.out.println(selectQueryConverter.covertToMongoQuery(new SelectSqlQuery(sqlQ3)));
        System.out.println(selectQueryConverter.covertToMongoQuery(new SelectSqlQuery(sqlQ4)));
        System.out.println(selectQueryConverter.covertToMongoQuery(new SelectSqlQuery(sqlQ5)));

        System.out.println("______________________________________________");

        String i1 = "INSERT INTO identityActions (uid,lastAccessedTimestampUtc) VALUES (122323, 2014-12-12)";
        String i2 = "INSERT INTO identityActions (lastAccessedTimestampUtc,lastModifiedTimestampUtc, uid,email) VALUES " +
                " (2017-05-10T06:14:08.678Z,2017-05-10T06:14:08.678Z, uid-7878, abc@abc)," +
                " (2017-05-10T06:14:08.678Z,2017-05-10T06:14:08.678Z, uid-7979, anc)";

        InsertQueryConverter insertQueryConverter = new InsertQueryConverter();

        System.out.println(insertQueryConverter.covertToMongoQuery(new InsertSqlQuery(i1)));
        System.out.println(insertQueryConverter.covertToMongoQuery(new InsertSqlQuery(i2)));

        System.out.println("______________________________________________");

        String d1 = "DELETE FROM identityActions";
        String d2 = "DELETE FROM identityActions WHERE uid=122323";
        String d3 = "DELETE FROM identityActions WHERE uid = 122323, email = abc@abc";

        DeleteQueryConverter deleteQueryConverter = new DeleteQueryConverter();

        System.out.println(deleteQueryConverter.covertToMongoQuery(new DeleteSqlQuery(d1)));
        System.out.println(deleteQueryConverter.covertToMongoQuery(new DeleteSqlQuery(d2)));
        System.out.println(deleteQueryConverter.covertToMongoQuery(new DeleteSqlQuery(d3)));

        System.out.println("______________________________________________");

        String u1 = "UPDATE identityActions SET uid=XYZ WHERE uid=122323";
        String u2 = "UPDATE identityActions SET uid=XYZ, email=abc@abc WHERE uid=122323";
        String u3 = "UPDATE identityActions SET uid=XYZ";

        UpdateQueryConverter updateQueryConverter = new UpdateQueryConverter();
        System.out.println(updateQueryConverter.covertToMongoQuery(new UpdateSqlQuery(u1)));
        System.out.println(updateQueryConverter.covertToMongoQuery(new UpdateSqlQuery(u2)));
        System.out.println(updateQueryConverter.covertToMongoQuery(new UpdateSqlQuery(u3)));*/
    }
}
