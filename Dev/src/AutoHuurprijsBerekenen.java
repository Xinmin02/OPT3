public class AutoHuurprijsBerekenen extends HuurprijsBerekenen {
    @Override
    protected double getBasisPrijs(Product product) {
        return 50; // Basisprijs per dag
    }

    @Override
    protected double getVerzekeringsPrijs(Product product) {
        // Voorbeeld: Verzekeringsprijs berekenen
        //return 0.01 * ((ConcreteProduct) product).getMotorInhoud();
        System.out.println("prijs is dit....");
        return 50;
    }
}