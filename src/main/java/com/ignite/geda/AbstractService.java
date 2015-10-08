package com.ignite.geda;

import com.ignite.geda.annotations.dto.impl.EmployeeDTOImpl;
import com.ignite.geda.converters.IdConverter;
import com.ignite.geda.domain.impl.EmployeeImpl;
import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.EntityRetriever;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey on 07.10.2015.
 */
public abstract class AbstractService implements Service {
    protected Map<String, Object> getConvertersMap() {
        Map<String, Object> converters = new HashMap<String, Object>();
        converters.put("id_converter", new IdConverter());
        return converters;
    }

    protected void createEntityRetriever(Map<String, Object> convertersMap) {
        final EntityRetriever retriever = new EntityRetriever() {

            /*
             * Simple retrieve mock. Actual retriever would probably call a DAO object.
             */
            @SuppressWarnings("unchecked")
            public Object retrieveByPrimaryKey(final Class entityInterface, final Class entityClass, final Object primaryKey) {
                try {
                    return entityClass.newInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

        };

        convertersMap.put("retriever", retriever);
    }

    protected BeanFactory createEntityBeanFactory() {
        return new BeanFactory() {

            public Class getClazz(final String entityBeanKey) {
                return null;
            }

            public Object get(final String entityBeanKey) {
                if (entityBeanKey.equals("Employee")) {
                    return new EmployeeImpl();
                }
                return null;
            }

        };
    }

    protected BeanFactory createDtoBeanFactory() {
        return new BeanFactory() {

            public Class getClazz(final String entityBeanKey) {
                return null;
            }

            public Object get(final String entityBeanKey) {
                if (entityBeanKey.equals("EmployeeDTO")) {
                    return new EmployeeDTOImpl();
                }
                return null;
            }
        };
    }
}
