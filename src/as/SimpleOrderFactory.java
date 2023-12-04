package as;

// trieda pre tovaren (factory) na obycajne objednavky
public class SimpleOrderFactory extends OrderFactory {
    @Override
    public Order createOrder(Customer customer) {
        return new SimpleOrder(customer);
    }
}
