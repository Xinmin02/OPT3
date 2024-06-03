public abstract class HuurprijsBerekenen {
    public double berekenPrijs(Product product) {
        double basisPrijs = getBasisPrijs(product);
        double verzekeringsPrijs = getVerzekeringsPrijs(product);
        return basisPrijs + verzekeringsPrijs;
    }

    protected abstract double getBasisPrijs(Product product);
    protected abstract double getVerzekeringsPrijs(Product product);
}