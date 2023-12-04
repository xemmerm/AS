package as;

import java.util.ArrayList;
import java.util.List;

// trieda pre obycajnu objednavku
public class SimpleOrder implements Order {
    private final Customer customer;
    private final List<Product> products;
    private double totalPrice;
    private DiscountStrategy discountStrategy;

    public SimpleOrder(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void addProduct(Product product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public double calculateTotalPrice() {
        if (discountStrategy != null) {
            totalPrice = discountStrategy.applyDiscount(totalPrice);
            System.out.println("Total Price (with discount): " + totalPrice + "€");
        }
        else {
            System.out.println("Total Price: " + totalPrice + "€");
        }
        return totalPrice;
    }
    public void summarizeOrder() {
        System.out.println("Customer: " + customer.getName());
        System.out.println("Cart contains " + products.size() + " products:");
        for (Product product: products) {
            System.out.println("Product: " + product.getName() + ", OS: " + product.getOS().getName() + ", Price: " + product.getPrice() + "€");
        }
        System.out.println("Total Price: " + totalPrice + "€\t");
    }
    public Customer getCustomer() {
        return customer;
    }
}
