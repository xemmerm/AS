package as;

import java.util.ArrayList;
import java.util.List;

// trieda pre produktoveho manazera - aplikacia Singletonu
public class ProductManager {
    private static ProductManager instance;
    private final List<Product> products;

    private ProductManager() {
        products = new ArrayList<>();
    }

    public static ProductManager getInstance() {
        if (instance == null) {
            instance = new ProductManager();
        }
        return instance;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}

















