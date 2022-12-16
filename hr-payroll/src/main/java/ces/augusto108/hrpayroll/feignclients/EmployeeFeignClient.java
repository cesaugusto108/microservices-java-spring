package ces.augusto108.hrpayroll.feignclients;

import ces.augusto108.hrpayroll.model.entities.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-employee", path = "/employees")
public interface EmployeeFeignClient {
    @GetMapping(value = "/list/{id}")
    ResponseEntity<Employee> findById(@PathVariable Long id);
}
