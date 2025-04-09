package net.riya.ems.service.impl;

import lombok.AllArgsConstructor;
import net.riya.ems.dto.EmployeeDto;
import net.riya.ems.entity.Employee;
import net.riya.ems.exception.ResourceNotFoundException;
import net.riya.ems.mapper.EmployeeMapper;
import net.riya.ems.repository.EmployeeRepository;
import net.riya.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeTd) {
        Employee employee = employeeRepository.findById(employeeTd)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with the given id : " + employeeTd));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }
}
