package com.ignite.geda.annotations.dto.impl;

import com.ignite.geda.converters.EmployeeMatcher;
import com.ignite.geda.domain.Employee;
import com.ignite.geda.dto.DepartmentDTO;
import com.ignite.geda.dto.EmployeeDTO;
import com.inspiresoftware.lib.dto.geda.annotations.Dto;
import com.inspiresoftware.lib.dto.geda.annotations.DtoCollection;
import com.inspiresoftware.lib.dto.geda.annotations.DtoField;
import com.inspiresoftware.lib.dto.geda.annotations.DtoParent;

import java.util.List;

/**
 * Created by Sergey on 07.10.2015.
 */
@Dto
public class DepartmentDTOImpl implements DepartmentDTO {
    @DtoField
    private String name;

    @DtoField(value = "head",
            dtoBeanKey = "EmployeeDTO",
            entityBeanKeys = {"Employee"})
    private EmployeeDTO head;

    @DtoCollection(dtoBeanKey = "EmployeeDTO",
            entityBeanKeys = {"Employee"},
            dtoToEntityMatcher = EmployeeMatcher.class,
            entityGenericType = Employee.class)
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
