package as;

import java.util.Random;

// trieda pre adapter
public class EmailToCardAdapter implements PaymentGateway {
    @Override
    public String convertEmailToCardNumber(String email) {
        String cardNumber = "xxxx-xxxx-xxxx-";
        long seed = email.hashCode();
        Random random = new Random(seed);
        int randomNumber = random.nextInt(10000);
        return cardNumber + String.format("%04d", randomNumber);
    }
}
