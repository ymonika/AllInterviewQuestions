package com.mongo.converter;

import com.mongo.mongo.query.DeleteMongoQuery;
import com.mongo.mongo.query.OneColAndData;
import com.mongo.sql.query.DeleteSqlQuery;

import java.util.ArrayList;
import java.util.List;

public class DeleteQueryConverter implements QueryConverter<DeleteSqlQuery> {

    @Override
    public DeleteMongoQuery getMongoQuery(DeleteSqlQuery deleteSqlQuery) {

        DeleteMongoQuery deleteMongoQuery = new DeleteMongoQuery();
        deleteMongoQuery.setTableName(deleteSqlQuery.getTableName());
        if(! deleteSqlQuery.getColumnNames().isEmpty()) {
            deleteMongoQuery.setWhereClause(getInsertDataMap(deleteSqlQuery.getColumnNames(), deleteSqlQuery.getColumnValues()));
        }
        return deleteMongoQuery;
    }

    private List<OneColAndData> getInsertDataMap(List<String> columnValues, List<String> columnDataValues) {
        List<OneColAndData> oneColAndDatas = new ArrayList<>();

            if (columnValues.size() == columnDataValues.size() ) {
                for(int i=0;i<columnValues.size();i++) {
                    oneColAndDatas.add(new OneColAndData(columnValues.get(i), columnDataValues.get(i)));
                }
            } else {
                throw new RuntimeException("Data Column & Values are mismatched.");
        }
        return oneColAndDatas;
    }
}
