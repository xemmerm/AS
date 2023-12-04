package as;

// trieda pre koncovy prvok komponentu (list stromu)
public class ProductLeaf implements ProductComponent {
    private final Product product;

    public ProductLeaf(Product product) {
        this.product = product;
    }

    @Override
    public void displayInfo() {
        System.out.println("Product: " + product.getName() + ", OS: " + product.getOS().getName() + ", Price: " + product.getPrice() + "€");
    }
}
