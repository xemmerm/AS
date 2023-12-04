package as;

// trieda pre konkretny produkt
public class Product {
    private String name;
    private double price;
    private final OperatingSystem operatingSystem;

    public Product(String name, double price, OperatingSystem operatingSystem) {
        this.name = name;
        this.price = price;
        this.operatingSystem = operatingSystem;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    public OperatingSystem getOS() {
        return operatingSystem;
    }
}





