package dev.santosh.paymentservice.controllers;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import dev.santosh.paymentservice.dtos.GeneratePaymentLinkRequestDTO;
import dev.santosh.paymentservice.services.RazorPayGateWay;
import dev.santosh.paymentservice.services.StripeGateWay;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final RazorPayGateWay razorPayGateWay;
    private final StripeGateWay stripeGateWay;

    public PaymentController(RazorPayGateWay razorPayGateWay, StripeGateWay stripeGateWay) {
        this.razorPayGateWay = razorPayGateWay;
        this.stripeGateWay = stripeGateWay;
    }

    @PostMapping
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDTO requestDTO)
            throws RazorpayException, StripeException {

        // For now, using Razorpay — switch easily later
        return razorPayGateWay.generatePaymentLink(requestDTO.getOrderId());
    }
}
