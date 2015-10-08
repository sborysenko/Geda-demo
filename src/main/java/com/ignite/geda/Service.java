package com.ignite.geda;

import com.ignite.geda.domain.Department;
import com.ignite.geda.domain.Employee;
import com.ignite.geda.dto.DepartmentDTO;
import com.ignite.geda.dto.EmployeeDTO;

/**
 * Created by Sergey on 07.10.2015.
 */
public interface Service {
    public Department departmentFromDTO (DepartmentDTO departmentDTO);
    public  DepartmentDTO departmentToDTO (Department department);

    public Employee employeeFromDTO(EmployeeDTO employeeDTO);
    public EmployeeDTO employeeToDTO (Employee employee);
}
