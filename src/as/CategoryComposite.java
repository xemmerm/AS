package as;

import java.util.ArrayList;
import java.util.List;

// trieda pre kompozitny element - kategoria
public class CategoryComposite implements ProductComponent {
    private String categoryName;

    private List<ProductComponent> children = new ArrayList<>();

    public CategoryComposite(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addProductComponent(ProductComponent component) {
        children.add(component);
    }

    @Override
    public void displayInfo() {
        System.out.println("Category: " + categoryName);
        for (ProductComponent component : children) {
            component.displayInfo();
        }
        System.out.println("\t");
    }
}
