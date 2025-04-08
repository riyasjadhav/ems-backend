package net.riya.ems.service.impl;

import lombok.AllArgsConstructor;
import net.riya.ems.dto.EmployeeDto;
import net.riya.ems.entity.Employee;
import net.riya.ems.mapper.EmployeeMapper;
import net.riya.ems.repository.EmployeeRepository;
import net.riya.ems.service.EmployeeService;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class EmployeeServiceimpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
