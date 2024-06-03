public class AutoFactory extends ProductFactory {
    @Override
    public Product maakProduct(String id, String beschrijving, boolean opVoorraad) {
        return new ConcreteProduct(id, beschrijving, opVoorraad, "AutoMerk", "AutoModel");
    }
}