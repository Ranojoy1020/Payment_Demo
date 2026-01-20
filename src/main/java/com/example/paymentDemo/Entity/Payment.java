package com.example.paymentDemo.Entity;

import com.example.paymentDemo.Enum.PaymentStatus;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;

    private String razorpayOrderId;
    private long amount;
    private String currency;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Instant createdAt;

    protected Payment() {}

    public Payment(String razorpayOrderId, long amount, String currency) {
        this.razorpayOrderId = razorpayOrderId;
        this.amount = amount;
        this.currency = currency;
        this.status = PaymentStatus.CREATED;
        this.createdAt = Instant.now();
    }
}

