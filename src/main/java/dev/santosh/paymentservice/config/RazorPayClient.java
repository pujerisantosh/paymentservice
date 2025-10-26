package dev.santosh.paymentservice.config;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class RazorPayClient {
 //  RAZORPAY_KEY_ID = "rzp_test_RXyJ7NvdUj631f" ; RAZORPAY_KEY_SECRET = "fh1wuznXDnV2Xt1a7vVcCuFc"
    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;
    @Bean
    @Lazy
    public RazorpayClient createRazorPayClient() throws RazorpayException {
        System.out.println("Razorpay Key ID Loaded: " + razorpayKeyId);
        System.out.println(" Razorpay Key Secret Loaded: " + razorpayKeySecret);
        return new RazorpayClient(razorpayKeyId, razorpayKeySecret);
    }
}
