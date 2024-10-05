package com.seva.employee.service.impl;

import com.seva.employee.dto.EmployeeDto;
import com.seva.employee.entity.Employee;
import com.seva.employee.exception.EmployeeNotFoundException;
import com.seva.employee.mapper.EmployeeMapper;
import com.seva.employee.repository.EmployeeRepository;
import com.seva.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return employeeMapper.toDto(savedEmployee);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();

            employee.setFirstname(employeeDto.getFirstname());
            employee.setLastname(employeeDto.getLastname());
            employee.setEmail(employeeDto.getEmail());

            employeeRepository.save(employee);

            return employeeMapper.toDto(employee);
        } else {
            throw new EmployeeNotFoundException(id);
        }
    }

    public void deleteEmployee(Long id){
        employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        employeeRepository.deleteById(id);
    }

    public EmployeeDto getEmployeeById(Long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return employeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeMapper.toDtoList(employeeList);
    }

}
