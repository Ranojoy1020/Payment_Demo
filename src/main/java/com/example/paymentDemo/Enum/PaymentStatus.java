package com.example.paymentDemo.Enum;

public enum PaymentStatus {

    CREATED,        // Order created locally and/or on Razorpay
    AUTHORIZED,     // Payment authorized by bank (not yet captured)
    CAPTURED,       // Money successfully captured
    FAILED,         // Payment attempt failed
    REFUNDED,       // Full refund completed
    PARTIALLY_REFUNDED; // Partial refund completed
}