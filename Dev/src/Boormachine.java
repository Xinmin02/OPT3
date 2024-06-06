public class Boormachine extends Product {
    private String merk;
    private String type;

    public Boormachine(String beschrijving, String merk, String type) {
        super(beschrijving);
        this.merk = merk;
        this.type = type;
    }

    @Override
    public String getDetails() {
        return "Merk: " + merk + ", Type: " + type;
    }

    @Override
    public double getHuurprijsPerDag() {
        return 15.0;
    }
}
