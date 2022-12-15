package ces.augusto108.hrpayroll.model.services;

import ces.augusto108.hrpayroll.model.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(Long employeeId, Integer numberOfDays) {
        return new Payment("Juliana", 158.90, numberOfDays);
    }
}
