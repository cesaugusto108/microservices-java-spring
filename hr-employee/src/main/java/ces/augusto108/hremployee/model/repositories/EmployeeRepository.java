package ces.augusto108.hremployee.model.repositories;

import ces.augusto108.hremployee.model.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
