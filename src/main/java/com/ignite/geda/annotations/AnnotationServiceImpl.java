package com.ignite.geda.annotations;

import com.ignite.geda.AbstractService;
import com.ignite.geda.Service;
import com.ignite.geda.annotations.dto.impl.DepartmentDTOImpl;
import com.ignite.geda.annotations.dto.impl.EmployeeDTOImpl;
import com.ignite.geda.converters.IdConverter;
import com.ignite.geda.domain.Department;
import com.ignite.geda.domain.Employee;
import com.ignite.geda.domain.impl.DepartmentImpl;
import com.ignite.geda.domain.impl.EmployeeImpl;
import com.ignite.geda.dto.DepartmentDTO;
import com.ignite.geda.dto.EmployeeDTO;
import com.inspiresoftware.lib.dto.geda.adapter.BeanFactory;
import com.inspiresoftware.lib.dto.geda.adapter.EntityRetriever;
import com.inspiresoftware.lib.dto.geda.assembler.Assembler;
import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sergey on 07.10.2015.
 */
public class AnnotationServiceImpl extends AbstractService {
    public Department departmentFromDTO(DepartmentDTO departmentDTO) {
        Department department = new DepartmentImpl();

        Map<String, Object> converters = getConvertersMap();

        Assembler assembler = DTOAssembler.newAssembler(DepartmentDTOImpl.class, DepartmentImpl.class);
        assembler.assembleEntity(departmentDTO, department, converters, createEntityBeanFactory());

        return department;
    }

    public DepartmentDTO departmentToDTO(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTOImpl();

        Map<String, Object> converters = getConvertersMap();

        Assembler assembler = DTOAssembler.newAssembler(DepartmentDTOImpl.class, DepartmentImpl.class);
        assembler.assembleDto(departmentDTO, department, converters, createDtoBeanFactory());

        return departmentDTO;
    }

    public Employee employeeFromDTO(EmployeeDTO employeeDTO) {
        Employee employee = new EmployeeImpl();

        Assembler assembler = DTOAssembler.newAssembler(EmployeeDTOImpl.class, EmployeeImpl.class);
        assembler.assembleEntity(employeeDTO, employee, getConvertersMap(), null);

        return employee;
    }

    public EmployeeDTO employeeToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTOImpl();

        Assembler assembler = DTOAssembler.newAssembler(EmployeeDTOImpl.class, EmployeeImpl.class);
        assembler.assembleDto(dto, employee, getConvertersMap(), null);

        return dto;
    }
}
