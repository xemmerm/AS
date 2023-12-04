package as;

// rozhranie pre protokol adapteru
public interface PaymentGateway {
    String convertEmailToCardNumber(String email);
}
