package ces.augusto108.hrpayroll.model.services;

import ces.augusto108.hrpayroll.feignclients.EmployeeFeignClient;
import ces.augusto108.hrpayroll.model.entities.Employee;
import ces.augusto108.hrpayroll.model.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private EmployeeFeignClient employeeFeignClient;

    public Payment getPayment(Long employeeId, Integer numberOfDays) {
        Employee e = employeeFeignClient.findById(employeeId).getBody();

        if (e != null) return new Payment(e.getName(), e.getDailyIncome(), numberOfDays);
        else return null;
    }
}
