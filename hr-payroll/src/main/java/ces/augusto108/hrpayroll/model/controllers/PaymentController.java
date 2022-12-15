package ces.augusto108.hrpayroll.model.controllers;

import ces.augusto108.hrpayroll.model.entities.Payment;
import ces.augusto108.hrpayroll.model.services.PaymentService;
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

    @GetMapping
    public ResponseEntity<Payment> getPayment(@RequestParam Long id, @RequestParam Integer days) {
        return ResponseEntity.ok(paymentService.getPayment(id, days));
    }
}
