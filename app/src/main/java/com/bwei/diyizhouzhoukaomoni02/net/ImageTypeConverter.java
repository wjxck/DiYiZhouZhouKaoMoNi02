package com.bwei.diyizhouzhoukaomoni02.net;

import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.ArrayList;
import java.util.List;

public class ImageTypeConverter implements PropertyConverter<List<String>, String> {
    @Override
    public List<String> convertToEntityProperty(String databaseValue) {
        ArrayList<String> list = new ArrayList<>();
        list.add(databaseValue);
        return list;
    }

    @Override
    public String convertToDatabaseValue(List<String> entityProperty) {
        return (entityProperty == null && !entityProperty.isEmpty()) ? "" : entityProperty.get(0);
    }
}