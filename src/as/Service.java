package as;

// trieda pre Service (adapter)
public class Service {
    private PaymentGateway paymentGateway;

    public Service(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void makePayment(String email, double amount) {
        String cardNumber = paymentGateway.convertEmailToCardNumber(email);
        System.out.println("Processing payment of " + amount + "€ with card number: " + cardNumber + "\n");
    }
}
