package com.ignite.geda.dsl.dto.impl;

import com.ignite.geda.dto.DepartmentDTO;
import com.ignite.geda.dto.EmployeeDTO;

import java.util.List;

/**
 * Created by Sergey on 07.10.2015.
 */
public class DepartmentDTOImpl implements DepartmentDTO {
    private String name;
    private EmployeeDTO head;
    private List<EmployeeDTO> staff;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeDTO getHead() {
        return head;
    }

    public void setHead(EmployeeDTO head) {
        this.head = head;
    }

    public List<EmployeeDTO> getStaff() {
        return staff;
    }

    public void setStaff(List<EmployeeDTO> staff) {
        this.staff = staff;
    }
}
