package as;

// trieda pre vytvorenie specialnej zlavy (strategia)
public class SpecialDiscountStrategy implements DiscountStrategy {

    @Override
    public double applyDiscount(double totalPrice) {
        // 10% zlava pri nakupe aspon za 1000€
        if (totalPrice >= 1000) {
            return totalPrice * 0.9;
        }
        return totalPrice;
    }
}
