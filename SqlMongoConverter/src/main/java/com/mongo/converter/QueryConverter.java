package com.mongo.converter;

import com.mongo.mongo.query.FindMongoQuery;

public interface QueryConverter<T> {

    FindMongoQuery getMongoQuery(T t);
}
