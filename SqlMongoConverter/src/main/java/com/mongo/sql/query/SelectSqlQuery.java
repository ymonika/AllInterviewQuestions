package com.mongo.sql.query;

import com.mongo.util.Constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SelectSqlQuery extends SqlQuery {

    private List<String> selectClause;

    public SelectSqlQuery(String sqlQ) {
        int selectIndex = sqlQ.indexOf("SELECT") + 6 ;
        int fromIndex = sqlQ.indexOf("FROM") ;
        this.selectClause = getListForSelect(sqlQ.substring(selectIndex, fromIndex).trim());
        this.setTableName(sqlQ.substring(fromIndex + 4, sqlQ.length() ).trim());
    }

    public List<String> getSelectClause() {
        return selectClause;
    }

    public void setSelectClause(List<String> selectClause) {
        this.selectClause = selectClause;
    }

    private List<String> getListForSelect(String columnsOrAll){
        List<String> columns = new ArrayList<>();
        if(columnsOrAll.equals(Constant.STAR)) {
            return columns;
        } else {
            columns.addAll(Arrays.stream(columnsOrAll.split(",")).map(column -> column.trim()).collect(Collectors.toList()));
        }
        return columns;
    }

    @Override
    public String toString() {
        return " SELECT " + selectClause + "  from " + this.getTableName();
    }
}
