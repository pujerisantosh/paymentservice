💳 PaymentService Microservice

Secure, multi-gateway payment link generation service built with Spring Boot.

This microservice provides a unified API layer to generate secure, disposable payment links across multiple external gateways — currently Razorpay and Stripe. It abstracts complex vendor SDKs behind simple REST endpoints for seamless integration into modern backend systems.

🧩 Problem Statement

Most modern applications need a reliable and flexible payment system that supports multiple gateways.
However, each payment provider (Razorpay, Stripe, etc.) has its own SDKs, authentication models, and response formats — making direct integration complex, error-prone, and time-consuming.

PaymentService solves this by acting as a common payment microservice that:

Generates payment links from multiple gateways with a single, unified API.

Simplifies backend logic for developers by hiding SDK complexity.

Provides flexibility to switch or add gateways without major code changes.

This service enables teams to build production-grade payment solutions faster with minimal integration effort.

🌟 Key Features

Multi-Gateway Support: Seamless integration with Razorpay and Stripe.

Payment Link Generation: Creates unique, secure payment URLs for customer checkout.

Customer Context: Supports name, email, and contact details for personalized payment links.

Extensible Design: Built with Service Provider Interface (SPI) principles for adding more gateways (e.g., PayPal, PayU).

RESTful API: Designed with Spring Boot for production-ready scalability.

🛠️ Technology Stack
Category	Technology	Purpose
Backend	Java 23	Core language leveraging modern JVM features (Virtual Threads).
Framework	Spring Boot 3.5	REST API development with auto-configuration.
Payment SDKs	Razorpay Java SDK, Stripe Java SDK	External payment gateway integrations.
Build Tool	Maven	Dependency management & project build.
API Testing	Postman	For validating API endpoints and responses.
📐 Architecture and Design

The service follows a layered adapter-based architecture ensuring clean separation and easy extensibility:

Controller Layer: Handles HTTP requests and responses.

Service Layer: Core business logic — decides which gateway to call.

Gateway Adapter (Interface):
Defines generatePaymentLink() in PaymentGatewayService (SPI contract).

Implementations:

RazorpayService

StripeService
Each implements SDK-specific logic.

🧠 This design supports the Open/Closed Principle — new gateways can be added without touching existing logic.

🚀 Getting Started
Prerequisites

Java 23 or higher

Maven

Razorpay Account (Key ID & Secret)

Stripe Account (Secret Key)

Installation & Configuration
git clone https://github.com/pujerisantosh/paymentservice.git
cd paymentservice


Update src/main/resources/application.properties:

# Razorpay Credentials
razorpay.key.id=YOUR_RAZORPAY_KEY_ID
razorpay.key.secret=YOUR_RAZORPAY_KEY_SECRET

# Stripe Credentials
stripe.api.key=YOUR_STRIPE_SECRET_KEY


Run the application:

mvn spring-boot:run


The service will start at http://localhost:8080

🌐 API Endpoints
1️⃣ Generate Razorpay Link

Method: POST
URL: /api/payment/razorpay/{orderId}

Example Request Body

{
  "amount": 1000,
  "currency": "INR",
  "customerName": "Santosh Pujeri",
  "email": "santosh.test@example.com",
  "contact": "+917338110806"
}

2️⃣ Generate Stripe Link

Method: POST
URL: /api/payment/stripe/{orderId}

(Same body structure as Razorpay)

🧾 Screenshots / Demo
✅ Razorpay Payment Link (Test Mode)

Below are the screenshots demonstrating successful Razorpay payment link creation and SMS receipt.

Screenshot	Description

	Razorpay payment link generated for a test order in the dashboard.

	SMS received from Razorpay showing live test payment request sent to the customer.

Details

Amount: ₹10.00

Mode: Test Mode

Customer: Santosh Pujeri

Verified via Postman and Razorpay Test Dashboard

📈 Future Enhancements

Webhook Integration: Listen to payment updates from Razorpay & Stripe for real-time status.

Idempotency Handling: Prevent duplicate payment link creation (using Redis or similar).

Distributed Tracing: Integrate Sleuth/Zipkin for end-to-end microservice tracing.

More Gateways: Extend support to PayPal, PayU, etc.

👨‍💻 Author

Santosh Pujeri
Backend Developer | Payment Integration Specialist
📧 pujersantosh.backend@gmail.com

📞 +91 7338110806
