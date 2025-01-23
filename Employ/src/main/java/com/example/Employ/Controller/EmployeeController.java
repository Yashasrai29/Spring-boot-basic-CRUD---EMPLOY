package com.example.Employ.Controller;

import com.example.Employ.Service.EmployeeService;
import com.example.Employ.dto.EmployeeDto;
import com.example.Employ.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.saveEmp(employee);
    }


    @PutMapping(path="{id}")
    public Employee updateEmployee(@PathVariable Integer id,@RequestBody Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @PatchMapping(path="{id}")
    public Employee PartialUpdateEmployee(@PathVariable Integer id,@RequestBody EmployeeDto employeeDto) {
        return employeeService.partialUpdateEmp(employeeDto,id);
    }


    @GetMapping
    public List<Employee> getEmployee(){
        return employeeService.getEmp();
    }

    @GetMapping(path="{id}")
    public Iterable<Employee> getEmployeeById(@PathVariable Integer id){
        return employeeService.getEmpByID(id);
    }

    @DeleteMapping(path="{id}")
    public void deleteEmployee(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
    }

    @GetMapping(value = "/")
    @ResponseBody
    public List<Employee> findByPage(
            @RequestParam (value="pageNumber", defaultValue = "1",required = false) Integer pageNumber,
            @RequestParam (value="pageSize", defaultValue = "10",required = false) Integer pageSize,
            @RequestParam (value="sortBy", defaultValue = "id",required = false) String sortBy,
            @RequestParam (value="filter",defaultValue = "Completed",required = false) String filter)
    {

        return this.employeeService.getEmpBySort(pageNumber,pageSize,sortBy,filter);

    }
    public EmployeeController() {
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


}
