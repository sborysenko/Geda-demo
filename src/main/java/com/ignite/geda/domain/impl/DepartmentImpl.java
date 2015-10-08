package com.ignite.geda.domain.impl;

import com.ignite.geda.domain.Department;
import com.ignite.geda.domain.Employee;

import java.util.List;

/**
 * Created by Sergey on 06.10.2015.
 */
public class DepartmentImpl implements Department {
    private String name;
    private Employee head;
    private List<Employee> staff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getHead() {
        return head;
    }

    public void setHead(Employee head) {
        this.head = head;
    }

    public List<Employee> getStaff() {
        return staff;
    }

    public void setStaff(List<Employee> staff) {
        this.staff = staff;
    }
}
