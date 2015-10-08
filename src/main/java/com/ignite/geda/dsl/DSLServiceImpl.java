package com.ignite.geda.dsl;

import com.ignite.geda.AbstractService;
import com.ignite.geda.converters.EmployeeMatcher;
import com.ignite.geda.domain.Department;
import com.ignite.geda.domain.Employee;
import com.ignite.geda.domain.impl.DepartmentImpl;
import com.ignite.geda.domain.impl.EmployeeImpl;
import com.ignite.geda.dsl.dto.impl.DepartmentDTOImpl;
import com.ignite.geda.dsl.dto.impl.EmployeeDTOImpl;
import com.ignite.geda.dto.DepartmentDTO;
import com.ignite.geda.dto.EmployeeDTO;
import com.inspiresoftware.lib.dto.geda.adapter.ExtensibleBeanFactory;
import com.inspiresoftware.lib.dto.geda.assembler.Assembler;
import com.inspiresoftware.lib.dto.geda.assembler.DTOAssembler;
import com.inspiresoftware.lib.dto.geda.dsl.Registries;
import com.inspiresoftware.lib.dto.geda.dsl.Registry;
import com.inspiresoftware.lib.dto.geda.examples.usecases.SimpleMapExtensibleBeanFactory;

import java.util.Map;

/**
 * Created by Sergey on 07.10.2015.
 */
public class DSLServiceImpl  extends AbstractService {
    public Department departmentFromDTO(DepartmentDTO departmentDTO) {
        final ExtensibleBeanFactory bf = new SimpleMapExtensibleBeanFactory();

        Registry registry = Registries.registry(bf);
        bf.registerDto("EmployeeDto", EmployeeDTOImpl.class.getCanonicalName());
        bf.registerEntity("Employee", EmployeeImpl.class.getCanonicalName(), Employee.class.getCanonicalName());
        bf.registerDto("DepartmentDto", DepartmentDTOImpl.class.getCanonicalName());
        bf.registerEntity("Department", DepartmentImpl.class.getCanonicalName(), Department.class.getCanonicalName());

        registry.dto("DepartmentDto").forEntity("Department")
                .withField("name").forField("name")
                .and()
                .withField("head").forField("head")
                .dtoBeanKey("EmployeeDto").entityBeanKeys("Employee")
                .and()
                .withCollection("staff").forField("staff")
                .dtoBeanKey("EmployeeDto").entityBeanKeys("Employee").dtoToEntityMatcher(EmployeeMatcher.class)
        ;
        registry.dto("EmployeeDto").forEntity("Employee")
                .withField("id").forField("id").converter("id_converter")
                .and()
                .withField("fullName").forField("firstName")
                .and()
                .withField("position").forField("position")
                .and()
                .withField("phoneNumber").forField("phone")
        ;

        Department department = new DepartmentImpl();

        Map<String, Object> converters = getConvertersMap();

        Assembler assembler = DTOAssembler.newAssembler(DepartmentDTOImpl.class, DepartmentImpl.class, registry);
        assembler.assembleEntity(departmentDTO, department, converters, null);

        return department;
    }

    public DepartmentDTO departmentToDTO(Department department) {
        final ExtensibleBeanFactory bf = new SimpleMapExtensibleBeanFactory();

        Registry registry = Registries.registry(bf);
        bf.registerDto("EmployeeDto", EmployeeDTOImpl.class.getCanonicalName());
        bf.registerEntity("Employee", EmployeeImpl.class.getCanonicalName(), Employee.class.getCanonicalName());
        bf.registerDto("DepartmentDto", DepartmentDTOImpl.class.getCanonicalName());
        bf.registerEntity("Department", DepartmentImpl.class.getCanonicalName(), Department.class.getCanonicalName());

        registry.dto("DepartmentDto").forEntity("Department")
                .withField("name").forField("name")
                .and()
                .withField("head").forField("head")
                .dtoBeanKey("EmployeeDto").entityBeanKeys("Employee")
                .and()
                .withCollection("staff").forField("staff")
                .dtoBeanKey("EmployeeDto").entityBeanKeys("Employee").dtoToEntityMatcher(EmployeeMatcher.class)
        ;
        registry.dto("EmployeeDto").forEntity("Employee")
                .withField("id").forField("id").converter("id_converter")
                .and()
                .withField("fullName").forField("firstName")
                .and()
                .withField("position").forField("position")
                .and()
                .withField("phoneNumber").forField("phone")
        ;

        DepartmentDTO departmentDTO = new DepartmentDTOImpl();

        Map<String, Object> converters = getConvertersMap();

        Assembler assembler = DTOAssembler.newAssembler(DepartmentDTOImpl.class, DepartmentImpl.class, registry);
        assembler.assembleDto(departmentDTO, department, converters, null);

        return departmentDTO;
    }

    public Employee employeeFromDTO(EmployeeDTO employeeDTO) {
        final ExtensibleBeanFactory bf = new SimpleMapExtensibleBeanFactory();

        Registry registry = Registries.registry(bf);
        bf.registerDto("employeeDto", EmployeeDTOImpl.class.getCanonicalName());
        bf.registerEntity("employee", EmployeeImpl.class.getCanonicalName(), Employee.class.getCanonicalName());

        registry.dto("employeeDto").forEntity("employee")
                .withField("id").forField("id").converter("id_converter")
                .and()
                .withField("fullName").forField("firstName")
                .and()
                .withField("position").forField("position")
                .and()
                .withField("phoneNumber").forField("phone")
        ;

        Employee employee = new EmployeeImpl();

        Assembler assembler = DTOAssembler.newAssembler(EmployeeDTOImpl.class, EmployeeImpl.class, registry);
        assembler.assembleEntity(employeeDTO, employee, getConvertersMap(), null);

        return employee;
    }

    public EmployeeDTO employeeToDTO(Employee employee) {
        final ExtensibleBeanFactory bf = new SimpleMapExtensibleBeanFactory();

        Registry registry = Registries.registry(bf);
        bf.registerDto("employeeDto", EmployeeDTOImpl.class.getCanonicalName());
        bf.registerEntity("employee", EmployeeImpl.class.getCanonicalName(), Employee.class.getCanonicalName());

        registry.dto("employeeDto").forEntity("employee")
                .withField("id").forField("id").converter("id_converter")
                .and()
                .withField("fullName").forField("firstName")
                .and()
                .withField("position").forField("position")
                .and()
                .withField("phoneNumber").forField("phone")
        ;

        EmployeeDTO employeeDTO = new EmployeeDTOImpl();

        Assembler assembler = DTOAssembler.newAssembler(EmployeeDTOImpl.class, EmployeeImpl.class, registry);
        assembler.assembleDto(employeeDTO, employee, getConvertersMap(), null);

        return employeeDTO;
    }
}
