package com.mongo.mongo.query;

public class FindMongoQuery implements MongoQuery {

    private String selectClause;
    private String tableName;

    public String getSelectClause() {
        return selectClause;
    }

    public void setSelectClause(String selectClause) {
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
        return "db." + tableName + ".find(" + selectClause + ")";
    }

}
