public class Vrachtauto extends Product {
    private int laadvermogen;
    private int motorinhoud;

    public Vrachtauto(String beschrijving, int laadvermogen, int motorinhoud) {
        super(beschrijving);
        this.laadvermogen = laadvermogen;
        this.motorinhoud = motorinhoud;
    }

    @Override
    public String getDetails() {
        return "Laadvermogen: " + laadvermogen + " kg, Motorinhoud: " + motorinhoud + " cc";
    }

    @Override
    public double getHuurprijsPerDag() {
        return 0.10 * laadvermogen + (0.01 * motorinhoud);
    }
}
