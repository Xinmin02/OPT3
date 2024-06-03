public abstract class Product {
    private String id;
    private String beschrijving;
    private boolean opVoorraad;

    public Product(String id, String beschrijving, boolean opVoorraad) {
        this.id = id;
        this.beschrijving = beschrijving;
        this.opVoorraad = opVoorraad;
    }

    public String getId() {
        return id;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public boolean isOpVoorraad() {
        return opVoorraad;
    }

    public void setOpVoorraad(boolean opVoorraad) {
        this.opVoorraad = opVoorraad;
    }
    public void setBeschrijving(String beschrijving) {this.beschrijving = beschrijving;}

    public abstract String getDetails();
    public abstract double getPrice();
    public abstract double getInsurance();


}