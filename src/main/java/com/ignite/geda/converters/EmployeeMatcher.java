package com.ignite.geda.converters;

import com.ignite.geda.domain.Employee;
import com.ignite.geda.dto.EmployeeDTO;
import com.inspiresoftware.lib.dto.geda.adapter.DtoToEntityMatcher;

/**
 * Created by Sergey on 07.10.2015.
 */
public class EmployeeMatcher implements DtoToEntityMatcher<EmployeeDTO, Employee> {
    public boolean match(EmployeeDTO employeeDTO, Employee employee) {
        return employeeDTO.getFullName().equals(employee.getFirstName());
    }
}
