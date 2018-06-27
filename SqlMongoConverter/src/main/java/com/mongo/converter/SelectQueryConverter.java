package com.mongo.converter;

import com.mongo.mongo.query.FindMongoQuery;
import com.mongo.sql.query.SelectSqlQuery;
import com.mongo.util.Constant;

import java.util.StringJoiner;

public class SelectQueryConverter implements QueryConverter<SelectSqlQuery> {

    static String COL_CONSTANT = "\"XYZ\" : 1";

    public FindMongoQuery getMongoQuery(SelectSqlQuery selectSqlQuery) {
        StringJoiner stringJoinerOuter = new StringJoiner(",");
        stringJoinerOuter.add(Constant.CURLY_);

        StringJoiner colClause = new StringJoiner(",");
        for (String column : selectSqlQuery.getSelectClause()) {
            if (column.length() > 0) {
                colClause.add(COL_CONSTANT.replace("XYZ", column.trim()));
            }
        }
        if(colClause.length() != 0 ) {
         stringJoinerOuter.add("{" + colClause + "}");
        }
        FindMongoQuery findMongoQuery = new FindMongoQuery();
        findMongoQuery.setTableName(selectSqlQuery.getTableName());
        findMongoQuery.setSelectClause(stringJoinerOuter.toString());

        return findMongoQuery;
    }
}
