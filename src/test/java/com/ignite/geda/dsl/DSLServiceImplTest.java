package com.ignite.geda.dsl;

import com.ignite.geda.Service;
import com.ignite.geda.domain.Department;
import com.ignite.geda.domain.Employee;
import com.ignite.geda.dsl.dto.impl.DepartmentDTOImpl;
import com.ignite.geda.dsl.dto.impl.EmployeeDTOImpl;
import com.ignite.geda.dto.DepartmentDTO;
import com.ignite.geda.dto.EmployeeDTO;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Sergey on 07.10.2015.
 */
public class DSLServiceImplTest {
    Service service = new DSLServiceImpl();

    @Test
    public void testEmployeeFromDTO() throws Exception {
        EmployeeDTO dto = createEmployee(Long.valueOf(1), "User Name", "Employee position", "11234569", "3002");

        Employee employee = service.employeeFromDTO(dto);

        assertNotNull(employee);
        assertEquals("1", employee.getId());
        assertEquals("User Name", employee.getFirstName());
        assertEquals("Employee position", employee.getPosition());
        assertEquals("11234569", employee.getPhone());
    }

    @Test
    public void testEmployeeToDTO() {
        Employee employee = service.employeeFromDTO(createEmployee(Long.valueOf(1), "User Name", "Employee position", "11234569", "3002"));

        EmployeeDTO dto = service.employeeToDTO(employee);

        assertNotNull(dto);
        assertEquals(Long.valueOf(1), dto.getId());
        assertEquals("User Name", dto.getFullName());
        assertEquals("Employee position", dto.getPosition());
        assertEquals("11234569", dto.getPhoneNumber());
        assertNull(dto.getDeskNumber());
    }

    @Test
    public void testDepartmentFromDTO() {
        DepartmentDTO dto = createDepartment("Dep1");

        Department department = service.departmentFromDTO(dto);

        assertEquals("Dep1", department.getName());
        assertNotNull(department.getHead());
        assertEquals("Department \"Dep1\" Head", department.getHead().getFirstName());
        assertNotNull(department.getStaff());
        assertEquals(3, department.getStaff().size());
        assertEquals("Department \"Dep1\" Head", department.getStaff().get(0).getFirstName());
        assertEquals("Department \"Dep1\" Employee 1", department.getStaff().get(1).getFirstName());
        assertEquals("Department \"Dep1\" Employee 2", department.getStaff().get(2).getFirstName());
    }

    @Test
    public void testDepartmentToDTO() {
        Department department = service.departmentFromDTO(createDepartment("Dep1"));

        DepartmentDTO dto = service.departmentToDTO(department);

        assertEquals("Dep1", dto.getName());
        assertNotNull(dto.getHead());
        assertEquals("Department \"Dep1\" Head", dto.getHead().getFullName());
        assertNotNull(dto.getStaff());
        assertEquals(3, dto.getStaff().size());
        assertEquals("Department \"Dep1\" Head", dto.getStaff().get(0).getFullName());
        assertEquals("Department \"Dep1\" Employee 1", dto.getStaff().get(1).getFullName());
        assertEquals("Department \"Dep1\" Employee 2", dto.getStaff().get(2).getFullName());
    }

    private EmployeeDTO createEmployee(Long id, String userName, String position, String phone, String desk) {
        EmployeeDTO dto = new EmployeeDTOImpl();
        dto.setId(id);
        dto.setFullName(userName);
        dto.setPosition(position);
        dto.setPhoneNumber(phone);
        dto.setDeskNumber(desk);
        return dto;
    }
    private DepartmentDTO createDepartment(String departmentName) {
        DepartmentDTO dto = new DepartmentDTOImpl();

        dto.setName(departmentName);
        dto.setHead(createEmployee(Long.valueOf(1), "Department \"" + departmentName + "\" Head", "Department Head", "12345678", null));

        dto.setStaff(new ArrayList<EmployeeDTO>());
        dto.getStaff().add(createEmployee(Long.valueOf(1), "Department \"" + departmentName + "\" Head", "Department Head", "12345678", null));
        dto.getStaff().add(createEmployee(Long.valueOf(2), "Department \"" + departmentName + "\" Employee 1", "Employee 1", "12345678", null));
        dto.getStaff().add(createEmployee(Long.valueOf(3), "Department \"" + departmentName + "\" Employee 2", "Employee 2", "12345678", null));

        return dto;
    }
}