package com.example.paymentDemo.Controller;

import com.example.paymentDemo.DTO.CreateOrderRequest;
import com.example.paymentDemo.DTO.CreateOrderResponse;
import com.example.paymentDemo.Service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateOrderResponse> createPayment(
            @RequestBody CreateOrderRequest request) {

        CreateOrderResponse response = paymentService.createOrder(request);
        return ResponseEntity.ok(response);
    }
}

