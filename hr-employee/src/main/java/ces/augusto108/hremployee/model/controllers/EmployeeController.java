package ces.augusto108.hremployee.model.controllers;

import ces.augusto108.hremployee.model.entities.Employee;
import ces.augusto108.hremployee.model.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.of(employeeRepository.findById(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }
}
