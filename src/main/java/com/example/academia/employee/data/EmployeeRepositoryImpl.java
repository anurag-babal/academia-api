package com.example.academia.employee.data;

import com.example.academia.employee.data.dao.EmployeeEntityDao;
import com.example.academia.employee.data.entity.EmployeeEntity;
import com.example.academia.employee.domain.EmployeeRepository;
import com.example.academia.employee.domain.model.Employee;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeEntityDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return mapToDomainEmployees(employeeDao.findAll());
    }

    @Override
    public Employee getEmployeeById(int id) {
        return mapToDomainEmployee(getEmployeeEntityById(id));
    }

    private EmployeeEntity getEmployeeEntityById(int id) {
        return employeeDao.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    private Employee mapToDomainEmployee(EmployeeEntity employeeEntity) {
        Employee employee = Employee.builder()
                .employeeId(employeeEntity.getEmployeeId())
                .email(employeeEntity.getEmail())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .title(employeeEntity.getTitle())
                .photographPath(employeeEntity.getPhotographPath())
                .build();
        return employee;
    }

    private List<Employee> mapToDomainEmployees(List<EmployeeEntity> employeeEntities) {
        return employeeEntities.stream().map(this::mapToDomainEmployee).toList();
    }
}
