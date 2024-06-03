import java.util.ArrayList;
import java.util.List;

public class ProductCatalogus {
    private List<Product> producten = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    public void voegProductToe(Product product) {
        producten.add(product);
        notifyObservers();
    }

    public void updateProduct(Product product) {
        notifyObservers();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public List<Product> getProducten() {
        return producten;
    }
}