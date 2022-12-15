package ces.augusto108.hremployee.model.services;

import ces.augusto108.hremployee.model.entities.Employee;
import ces.augusto108.hremployee.model.repositories.EmployeeRepository;
import ces.augusto108.hremployee.model.services.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Not found. Id: " + id + ", Type: " + Employee.class.getName()
        ));
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void save(Long id, String name, Double dailyIncome) {
        employeeRepository.save(new Employee(id, name, dailyIncome));
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
