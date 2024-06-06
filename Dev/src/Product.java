public abstract class Product {
    private String beschrijving;

    public Product(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public abstract String getDetails();
    public abstract double getHuurprijsPerDag();
}
