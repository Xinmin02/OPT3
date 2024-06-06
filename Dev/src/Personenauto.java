
public class Personenauto extends Product {
    private String merk;
    private int gewicht;
    private int motorinhoud;

    public Personenauto(String beschrijving, String merk, int gewicht, int motorinhoud) {
        super(beschrijving);
        this.merk = merk;
        this.gewicht = gewicht;
        this.motorinhoud = motorinhoud;
    }

    @Override
    public String getDetails() {
        return "Merk: " + merk + ", Gewicht: " + gewicht + " kg, Motorinhoud: " + motorinhoud + " cc";
    }

    @Override
    public double getHuurprijsPerDag() {
        return 50 + (0.01 * motorinhoud);
    }
}
