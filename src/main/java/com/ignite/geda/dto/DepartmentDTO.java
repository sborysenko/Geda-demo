package com.ignite.geda.dto;

import com.ignite.geda.domain.Employee;

import java.util.List;

/**
 * Created by Sergey on 07.10.2015.
 */
public interface DepartmentDTO {
    String getName();

    void setName(String name);

    EmployeeDTO getHead();

    void setHead(EmployeeDTO head);

    List<EmployeeDTO> getStaff();

    void setStaff(List<EmployeeDTO> staff);
}
