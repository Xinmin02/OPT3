import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends Observable {
    private List<Product> producten = new ArrayList<>();

    public List<Product> getProducten() {
        return producten;
    }

    public void addProduct(Product product) {
        producten.add(product);
        notifyObservers();
    }
}
