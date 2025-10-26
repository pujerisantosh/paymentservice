package dev.santosh.paymentservice.services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {
    String generatePaymentLink(Long orderId) throws RazorpayException, StripeException;
}

