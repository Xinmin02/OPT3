public class Vrachtauto extends Product {
    private int laadvermogen;
    private int motorinhoud;
    private boolean verzekerd;

    public Vrachtauto(String beschrijving, int laadvermogen, int motorinhoud, boolean verzekerd) {
        super(beschrijving);
        this.laadvermogen = laadvermogen;
        this.motorinhoud = motorinhoud;
        this.verzekerd = verzekerd;
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