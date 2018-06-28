package com.mongo.converter;

import com.mongo.mongo.query.DeleteMongoQuery;
import com.mongo.mongo.query.OneColAndData;
import com.mongo.sql.query.DeleteSqlQuery;
import com.mongo.util.CustomStringUtil;

import java.util.ArrayList;
import java.util.List;

public class DeleteQueryConverter implements QueryConverter<DeleteSqlQuery> {

    @Override
    public DeleteMongoQuery getMongoQuery(DeleteSqlQuery deleteSqlQuery) {

        DeleteMongoQuery deleteMongoQuery = new DeleteMongoQuery();
        deleteMongoQuery.setTableName(deleteSqlQuery.getTableName());
        if(! deleteSqlQuery.getColumnNames().isEmpty()) {
            deleteMongoQuery.setWhereClause(CustomStringUtil.getListOfPairValues(deleteSqlQuery.getColumnNames(), deleteSqlQuery.getColumnValues()));
        }
        return deleteMongoQuery;
    }


}
