public class Boormachine extends Product {
    private String merk;
    private String type;
    private boolean verzekerd;

    public Boormachine(String beschrijving, String merk, String type, boolean verzekerd) {
        super(beschrijving);
        this.merk = merk;
        this.type = type;
        this.verzekerd = verzekerd;
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