package as;

// trieda pre tovaren (factory) na BF objednavky
public class BlackFridayOrderFactory extends OrderFactory {
    @Override
    public Order createOrder(Customer customer) {
        return new BlackFridayOrder(customer);
    }
}
