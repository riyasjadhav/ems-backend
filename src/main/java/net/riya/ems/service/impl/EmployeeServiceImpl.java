package net.riya.ems.service.impl;

import lombok.AllArgsConstructor;
import net.riya.ems.dto.EmployeeDto;
import net.riya.ems.entity.Employee;
import net.riya.ems.exception.ResourceNotFoundException;
import net.riya.ems.mapper.EmployeeMapper;
import net.riya.ems.repository.EmployeeRepository;
import net.riya.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeTd) {
        Employee employee = employeeRepository.findById(employeeTd)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exist with the given id : " + employeeTd));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

         Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

         employee.setFirstName(updatedEmployee.getFirstName());
         employee.setLastName(updatedEmployee.getLastName());
         employee.setEmail(updatedEmployee.getEmail());

         Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
}
