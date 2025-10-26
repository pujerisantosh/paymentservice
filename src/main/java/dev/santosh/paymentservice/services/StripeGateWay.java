package dev.santosh.paymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripeGateWay implements  PaymentService{


    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException, StripeException, RazorpayException, StripeException {
        return "";
    }
}
