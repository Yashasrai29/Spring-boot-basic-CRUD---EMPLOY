package com.example.Employ.Service;

import com.example.Employ.Repo.EmployeeRepository;
import com.example.Employ.dto.EmployeeDto;
import com.example.Employ.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeDto employeeDto;


    public Employee saveEmp(Employee emp) {
        return this.employeeRepository.save(emp);
    }

    public Employee updateEmp(Employee emp) {
        return employeeRepository.save(emp);
    }


    public List<Employee> getEmp() {
        List<Employee> e1 = this.employeeRepository.findAll();
        return e1;

    }
    public Iterable<Employee> getEmpByID(Integer id) {
        return employeeRepository.findAllById(Collections.singleton(id));
    }

    public List<Employee> getEmpBySort(Integer pageNumber, Integer pageSize, String sortBy, String filter) {


        Pageable p = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Employee> pageTodo = this.employeeRepository.findAll(p);
        List<Employee> content = pageTodo.getContent();
        return content.stream().filter(Employee -> Employee.getStatus().equals(filter)).map((Employee) -> Employee).collect(Collectors.toList());


    }

    public Employee deleteEmp(Integer id) {
        employeeRepository.deleteById(id);
        return null;
    }

    public Employee partialUpdateEmp(EmployeeDto employeeDto, Integer id) {

        Optional<Employee> itemOptional = employeeRepository.findById(id);
        if (itemOptional.isPresent()) {
            Employee item = itemOptional.get();
            if (employeeDto.getName() != null) {
                item.setName(employeeDto.getName());

            } else {
                item.setName(item.getName());
            }
            if (employeeDto.getStatus() != null) {
                item.setStatus(employeeDto.getStatus());
            } else {
                item.setStatus(item.getStatus());
            }
            if (employeeDto.getDuedate() != null) {
                item.setDuedate(employeeDto.getDuedate());
            } else {
                item.setDuedate(item.getDuedate());
            }

            employeeRepository.save(item);


        }
        return null;
    }


    public EmployeeService() {
        }

    public EmployeeService(EmployeeRepository employeeRepository) {
            this.employeeRepository = employeeRepository;
        }

    }



