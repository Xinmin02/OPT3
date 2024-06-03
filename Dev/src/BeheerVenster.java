import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BeheerVenster extends Application implements Observer {
    private ProductCatalogus catalogus;
    private ListView<String> listView;

    public BeheerVenster() {
        this.catalogus = new ProductCatalogus(); // Voorbeeld
        catalogus.addObserver(this);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Beheer");

        VBox vbox = new VBox();
        listView = new ListView<>();

        for (Product product : catalogus.getProducten()) {
            listView.getItems().add(product.getBeschrijving());
        }

        listView.setOnMouseClicked(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            Product selectedProduct = catalogus.getProducten().stream()
                    .filter(p -> p.getBeschrijving().equals(selectedItem))
                    .findFirst()
                    .orElse(null);

            if (selectedProduct != null) {
                ToevoegenVenster toevoegenVenster = new ToevoegenVenster(selectedProduct);
                toevoegenVenster.start(new Stage());
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
            listView.getItems().add(product.getBeschrijving());
        }
    }
}