package ces.augusto108.hrpayroll.model.services;

import ces.augusto108.hrpayroll.model.entities.Employee;
import ces.augusto108.hrpayroll.model.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {
    @Value("${hr-employee.host}")
    private String host;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long employeeId, Integer numberOfDays) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(employeeId));

        Employee e = restTemplate.getForObject(
                host + "/employees/list/{id}",
                Employee.class,
                uriVariables
        );

        if (e != null) {
            return new Payment(e.getName(), e.getDailyIncome(), numberOfDays);
        } else return null;
    }
}
