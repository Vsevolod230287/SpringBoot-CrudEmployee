package com.seva.employee.mapper;

import com.seva.employee.dto.EmployeeDto;
import com.seva.employee.entity.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);
    Employee toEntity(EmployeeDto employeeDto);
    List<EmployeeDto> toDtoList(List<Employee> employeeDtoList);

}
