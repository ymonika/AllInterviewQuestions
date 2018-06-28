package com.mongo.mongo.query;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class FindMongoQuery implements MongoQuery {

    private List<OneColAndData> selectClause;
    private String tableName;
    private List<OneColAndData> whereClause = new ArrayList<>();

    public List<OneColAndData> getWhereClause() {
        return whereClause;
    }

    public void setWhereClause(List<OneColAndData> whereClause) {
        this.whereClause = whereClause;
    }

    public List<OneColAndData> getSelectClause() {
        return selectClause;
    }

    public void setSelectClause(List<OneColAndData> selectClause) {
        this.selectClause = selectClause;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public String toString() {
        StringJoiner outerStringJoiner = new StringJoiner(",");
        String whereClausedata = "";

        String selectClauseData = "{" + getStringFromList(selectClause) + "}";

        if (this.whereClause.size() != 0) {
            whereClausedata = "{" + getStringFromList(whereClause) + "}";
            outerStringJoiner.add(whereClausedata);
        }
        outerStringJoiner.add(selectClauseData);

        return "db." + tableName + ".find(" + outerStringJoiner.toString() + ")";
    }

    private String getStringFromList(List<OneColAndData> list) {
        StringJoiner stringJoiner = new StringJoiner(",");
        for (OneColAndData oneColAndData : list) {
            stringJoiner.add(oneColAndData.toString());
        }
        return stringJoiner.toString();
    }
}
