package com.mongo.converter;

import com.mongo.mongo.query.MongoQuery;
import com.mongo.mongo.query.UpdateMongoQuery;
import com.mongo.sql.query.UpdateSqlQuery;

public class UpdateQueryConverter implements QueryConverter<UpdateSqlQuery> {

    @Override
    public UpdateMongoQuery getMongoQuery(UpdateSqlQuery updateSqlQuery) {

        UpdateMongoQuery updateMongoQuery = new UpdateMongoQuery();


        return updateMongoQuery;
    }
}
