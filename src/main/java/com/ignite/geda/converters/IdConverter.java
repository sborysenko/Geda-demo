package com.ignite.geda.converters;

import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.ValueConverter;

/**
 * Created by Sergey on 07.10.2015.
 */
public class IdConverter implements ValueConverter {
    public Object convertToDto(Object object, BeanFactory beanFactory) {
        return Long.valueOf(object.toString());
    }

    public Object convertToEntity(Object object, Object oldEntity, BeanFactory beanFactory) {
        return object.toString();
    }
}
