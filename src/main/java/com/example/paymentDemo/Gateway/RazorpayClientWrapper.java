package com.example.paymentDemo.Gateway;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class RazorpayClientWrapper {

    private final RazorpayClient razorpayClient;
    private final String keyId;

    public RazorpayClientWrapper(RazorpayClient razorpayClient, String keyId) {
        this.razorpayClient = razorpayClient;
        this.keyId = keyId;
    }

    public String createOrder(long amount, String currency) {
        try {
            JSONObject options = new JSONObject();
            options.put("amount", amount);
            options.put("currency", currency);
            options.put("receipt", "rcpt_" + System.currentTimeMillis());

            Order order = razorpayClient.orders.create(options);
            return order.get("id");

        } catch (Exception e) {
            throw new RuntimeException("Failed to create Razorpay order", e);
        }
    }

    public String getKeyId() {
        return keyId;
    }
}

