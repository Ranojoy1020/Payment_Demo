package com.example.paymentDemo.Service;

import com.example.paymentDemo.DTO.CreateOrderRequest;
import com.example.paymentDemo.DTO.CreateOrderResponse;
import com.example.paymentDemo.Entity.Payment;
import com.example.paymentDemo.Gateway.RazorpayClientWrapper;
import com.example.paymentDemo.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final RazorpayClientWrapper razorpayClient;
    private final PaymentRepository repository;

    public PaymentService(RazorpayClientWrapper razorpayClient,
                          PaymentRepository repository) {
        this.razorpayClient = razorpayClient;
        this.repository = repository;
    }

    public CreateOrderResponse createOrder(CreateOrderRequest request) {

        // In Step-1, we trust amount but still control it server-side
        String razorpayOrderId = razorpayClient.createOrder(
                request.getAmount(),
                request.getCurrency()
        );

        Payment order = new Payment(
                razorpayOrderId,
                request.getAmount(),
                request.getCurrency()
        );

        repository.save(order);

        return new CreateOrderResponse(
                razorpayOrderId,
                request.getAmount(),
                request.getCurrency(),
                razorpayClient.getKeyId()
        );
    }
}
