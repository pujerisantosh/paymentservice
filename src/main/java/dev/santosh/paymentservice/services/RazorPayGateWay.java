package dev.santosh.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RazorPayGateWay implements PaymentService {

    private final RazorpayClient razorpayClient;

    public RazorPayGateWay(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {
        JSONObject paymentLinkRequest = new JSONObject();

        // Amount in paise (₹10.00)
        paymentLinkRequest.put("amount", 1000);
        paymentLinkRequest.put("currency", "INR");

        // Razorpay requires expire_by at least 15 minutes in future
        long fifteenMinutesInSeconds = 15 * 60;
        long bufferSeconds = 60; // 1-minute buffer
        long expireBy = System.currentTimeMillis() / 1000 + fifteenMinutesInSeconds + bufferSeconds;
        paymentLinkRequest.put("expire_by", expireBy);

        paymentLinkRequest.put("reference_id", orderId.toString());
        paymentLinkRequest.put("description", "Test payment for order " + orderId);

        // Customer details
        JSONObject customer = new JSONObject();
        customer.put("name", "Santosh Pujeri");
        customer.put("contact", "+91 7338110806");
        customer.put("email", "pujerisantosh.backend@gmail.com");
        paymentLinkRequest.put("customer", customer);

        // Notification settings
        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("notify", notify);

        paymentLinkRequest.put("reminder_enable", true);

        // Callback settings
        paymentLinkRequest.put("callback_url", "https://www.scaler.com/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        return payment.toString();
    }
}