package as;

// trieda pre vytvorenie BF zlavy (strategia)
public class BlackFridayDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalPrice) {
        return totalPrice * 0.8;    // 20% extra zlava na vsetko
    }
}
