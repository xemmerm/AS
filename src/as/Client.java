package as;

public class Client {

    public static void main(String[] args) {
        // Singleton - productManager
        ProductManager productManager = ProductManager.getInstance();

        // vytvorenie OS
        OperatingSystem androidOS = new OperatingSystem("Android");
        OperatingSystem iosOS = new OperatingSystem("iOS");
        OperatingSystem windowsOS = new OperatingSystem("Windows");
        OperatingSystem macosOS = new OperatingSystem("macOS");
        OperatingSystem linuxOS = new OperatingSystem("Linux");

        // vytvorenie produktov
        Product laptop = new Product("Laptop", 1000, windowsOS);
        Product macbook = new Product("MacBook", 1800, macosOS);
        Product desktop = new Product("Desktop PC", 750, windowsOS);
        Product linuxLaptop = new Product("Linux Laptop", 300, linuxOS);
        Product smartphone = new Product("Smartphone", 500, androidOS);
        Product tablet = new Product("Tablet", 300, androidOS);
        Product iphone = new Product("iPhone", 1200, iosOS);

        // pridanie produktov do sortimentu
        productManager.addProduct(smartphone);
        productManager.addProduct(tablet);
        productManager.addProduct(iphone);
        productManager.addProduct(laptop);
        productManager.addProduct(macbook);
        productManager.addProduct(desktop);
        productManager.addProduct(linuxLaptop);

        // vytvorenie kompozitnych struktur (kategorii)
        CategoryComposite phonesAndTabletsCategory = new CategoryComposite("Phones and Tablets");
        CategoryComposite pcAndLaptopsCategory = new CategoryComposite("PC and Laptops");

        // pridanie produktov do kategorii
        phonesAndTabletsCategory.addProductComponent(new ProductLeaf(smartphone));
        phonesAndTabletsCategory.addProductComponent(new ProductLeaf(tablet));
        phonesAndTabletsCategory.addProductComponent(new ProductLeaf(iphone));

        pcAndLaptopsCategory.addProductComponent(new ProductLeaf(laptop));
        pcAndLaptopsCategory.addProductComponent(new ProductLeaf(macbook));
        pcAndLaptopsCategory.addProductComponent(new ProductLeaf(desktop));
        pcAndLaptopsCategory.addProductComponent(new ProductLeaf(linuxLaptop));

        // vytvorenie korena stromu
        CategoryComposite allCategory = new CategoryComposite("All");
        allCategory.addProductComponent(phonesAndTabletsCategory);
        allCategory.addProductComponent(pcAndLaptopsCategory);

        // zobrazenie celeho sortimentu (stromu produktov)
        System.out.println("Our deals:");
        allCategory.displayInfo();

        // Vytvorenie zakaznikov
        Customer customer1 = new Customer("Adam Decembrovy", "adamkooo@gmail.com");
        Customer customer2 = new Customer("Lucia Novembrova", "lucinkaaa@gmail.com");

        // vytvorenie tovarni
        SimpleOrderFactory simpleOrderFactory = new SimpleOrderFactory();
        BlackFridayOrderFactory blackFridayOrderFactory = new BlackFridayOrderFactory();

        // vytvorenie objednavky
        Order simpleOrder = simpleOrderFactory.createOrder(customer1);

        // pridanie produktov do obycajnej objednavky nad 1000€
        simpleOrder.addProduct(macbook);
        simpleOrder.addProduct(iphone);
        simpleOrder.summarizeOrder();

        // pridanie specialnej zlavy
        simpleOrder.setDiscountStrategy(new SpecialDiscountStrategy());

        // adapter platobnej brany pre konverziu mailu na cislo karty
        PaymentGateway adapter = new EmailToCardAdapter();
        Service service = new Service(adapter);
        service.makePayment(simpleOrder.getCustomer().getEmail(), simpleOrder.calculateTotalPrice());

        // vytvorenie objednavky
        Order blackFridayOrder = blackFridayOrderFactory.createOrder(customer2);

        // pridanie produktov do BF objednavky do 1000€
        blackFridayOrder.addProduct(tablet);
        blackFridayOrder.addProduct(linuxLaptop);
        blackFridayOrder.summarizeOrder();

        // suma po aplikovani BF zlavy
        blackFridayOrder.calculateTotalPrice();

        // pridanie specialnej zlavy
        blackFridayOrder.setDiscountStrategy(new SpecialDiscountStrategy());

        // adapter platobnej brany pre konverziu mailu na cislo karty
        service.makePayment(blackFridayOrder.getCustomer().getEmail(), blackFridayOrder.calculateTotalPrice());
    }
}
