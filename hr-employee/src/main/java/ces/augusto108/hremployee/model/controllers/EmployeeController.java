package ces.augusto108.hremployee.model.controllers;

import ces.augusto108.hremployee.model.entities.Employee;
import ces.augusto108.hremployee.model.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @RequestMapping(value = "/save", method = {RequestMethod.POST, RequestMethod.PATCH})
    public void save(@RequestParam Long id, @RequestParam String name, @RequestParam Double dailyIncome) {
        employeeService.save(id, name, dailyIncome);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}

