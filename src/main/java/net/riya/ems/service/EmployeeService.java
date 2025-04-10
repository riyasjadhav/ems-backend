package net.riya.ems.service;

import net.riya.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeTd);

    List<EmployeeDto> getAllEmployees();
}
