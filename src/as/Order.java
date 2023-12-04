package as;

import java.util.ArrayList;
import java.util.List;

// trieda pre objednavku
public interface Order {
    void setDiscountStrategy(DiscountStrategy discountStrategy);
    void addProduct(Product product);
    double calculateTotalPrice();
    void summarizeOrder();
    Customer getCustomer();
}
