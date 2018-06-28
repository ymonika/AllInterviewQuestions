package com.mongo.converter;

import com.mongo.mongo.query.MongoQuery;

public interface QueryConverter<T> {

    MongoQuery getMongoQuery(T t);
}
