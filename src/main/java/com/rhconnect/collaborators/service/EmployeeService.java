package com.rhconnect.collaborators.service;

import com.rhconnect.collaborators.dto.EmployeeDTO;
import com.rhconnect.collaborators.model.Employee;
import com.rhconnect.collaborators.model.Occupation;
import com.rhconnect.collaborators.repository.EmployeeRepository;
import com.rhconnect.collaborators.repository.OccupationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @SuppressWarnings("unused")
    @Autowired
    private EmployeeRepository employeeRepository;

    @SuppressWarnings("unused")
    @Autowired
    private OccupationRepository occupationRepository;

    public EmployeeService() {
    }

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<EmployeeDTO> findById(Long id) {
        return employeeRepository.findById(id).map(this::convertToDTO);
    }

    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        Employee savedEmployee = employeeRepository.save(employee);
        return convertToDTO(savedEmployee);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setEmail(employee.getEmail());
        dto.setSalary(employee.getSalary());
        dto.setOccupationId(employee.getOccupation().getId());
        dto.setOccupationName(employee.getOccupation().getName());
        return dto;
    }

    private Employee convertToEntity(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setSalary(dto.getSalary());

        Occupation occupation = (Occupation) occupationRepository.findById(dto.getOccupationId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid Occupation ID"));
        employee.setOccupation(occupation);

        return employee;
    }
}