package com.mongo.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomStringUtil {

    public static List<String> getListFromString(String values) {
        return Arrays.stream(values.split(",")).map(value -> value.trim()).collect(Collectors.toList());
    }

}

