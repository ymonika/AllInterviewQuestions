package com.mongo.converter;

import com.mongo.mongo.query.InsertDataMap;
import com.mongo.mongo.query.InsertMongoQuery;
import com.mongo.mongo.query.MongoQuery;
import com.mongo.sql.query.InsertSqlQuery;

import java.util.ArrayList;
import java.util.List;

public class InsertQueryConverter implements QueryConverter<InsertSqlQuery> {


    @Override
    public MongoQuery getMongoQuery(InsertSqlQuery insertSqlQuery) {
        InsertMongoQuery insertMongoQuery = new InsertMongoQuery();

        insertMongoQuery.setTableName(insertSqlQuery.getTableName());
        insertMongoQuery.setInsertData(getInsertDataMap(insertSqlQuery.getColumnNames(), insertSqlQuery.getColumnValues()));

        return insertMongoQuery;
    }

    private List<InsertDataMap> getInsertDataMap(List<String> columnValues, List<List<String>> list) {
        List<InsertDataMap> insertDataMaps = new ArrayList<>();

        for (List<String> columnDataValues : list) {
            if (columnValues.size() == columnDataValues.size()) {
                insertDataMaps.add(new InsertDataMap(columnValues, columnDataValues));
            } else {
                throw new RuntimeException("Data Column & Values are mismatched.");
            }
        }
        return insertDataMaps;
    }
}
