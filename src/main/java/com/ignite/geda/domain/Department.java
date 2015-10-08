package com.ignite.geda.domain;

import java.util.List;

/**
 * Created by Sergey on 06.10.2015.
 */
public interface Department {
    String getName();

    void setName(String name);

    Employee getHead();

    void setHead(Employee head);

    List<Employee> getStaff();

    void setStaff(List<Employee> staff);
}
