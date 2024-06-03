import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OverzichtVenster extends Application implements Observer {
    private ProductCatalogus catalogus;
    private ListView<String> listView;

    public OverzichtVenster() {
        this.catalogus = new ProductCatalogus(); // Voorbeeld
        catalogus.addObserver(this);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overzicht");

        VBox vbox = new VBox();
        listView = new ListView<>();

        for (Product product : catalogus.getProducten()) {
            listView.getItems().add(product.getBeschrijving() + " - " + (product.isOpVoorraad() ? "Op voorraad" : "Verhuurd"));
        }

        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            Product selectedProduct = catalogus.getProducten().stream()
                    .filter(p -> (p.getBeschrijving() + " - " + (p.isOpVoorraad() ? "Op voorraad" : "Verhuurd")).equals(selectedItem))
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
                DetailVenster detailVenster = new DetailVenster(selectedProduct);
                detailVenster.start(new Stage());
            }
        });

        vbox.getChildren().add(listView);
        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update() {
        listView.getItems().clear();
        for (Product product : catalogus.getProducten()) {
            listView.getItems().add(product.getBeschrijving() + " - " + (product.isOpVoorraad() ? "Op voorraad" : "Verhuurd"));
        }
    }
}