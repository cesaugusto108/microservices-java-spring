package ces.augusto108.hrpayroll.model.controllers;

import ces.augusto108.hrpayroll.model.entities.Payment;
import ces.augusto108.hrpayroll.model.services.PaymentService;
import ces.augusto108.hrpayroll.model.services.exceptions.NotValidResponseException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "displayAltResponse")
    @GetMapping
    public ResponseEntity<Payment> getPayment(@RequestParam Long id, @RequestParam Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(id, days));
    }

    public ResponseEntity<Payment> displayAltResponse(Long id, Integer days) {
        throw new NotValidResponseException("Id not found or application did not get a response.");
    }
}
