import java.util.*;

public class InventoryManager {
    private Map<String, Product> products = new HashMap<>();

    public boolean addProduct(String id, String name, int quantity, double price) {
        if (products.containsKey(id)) {
            return false;
        }
        products.put(id, new Product(id, name, quantity, price));
        return true;
    }

    public boolean updateProduct(String id, int quantity, double price) {
        Product product = products.get(id);
        if (product == null) {
            return false;
        }
        product.setQuantity(quantity);
        product.setPrice(price);
        return true;
    }

    public boolean deleteProduct(String id) {
        return products.remove(id) != null;
    }

    public List<Product> listProducts() {
        return new ArrayList<>(products.values());
    }

    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        manager.addProduct("1", "Laptop", 10, 999.99);
        manager.addProduct("2", "Smartphone", 20, 499.99);

        System.out.println("All products: " + manager.listProducts());

        manager.updateProduct("1", 8, 899.99);
        System.out.println("Updated products: " + manager.listProducts());
    }
}