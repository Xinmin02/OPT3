import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ToevoegenVenster extends Application {
    private Product product;

    public ToevoegenVenster(Product product) {
        this.product = product;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Product toevoegen");

        GridPane grid = new GridPane();
        Label lblBeschrijving = new Label("Beschrijving:");
        TextField txtBeschrijving = new TextField(product.getBeschrijving());
        Label lblMerk = new Label("Merk:");
        TextField txtMerk = new TextField(); // Populate for specific product
        Label lblModel = new Label("Model:");
        TextField txtModel = new TextField(); // Populate for specific product
        Button btnToevoegen = new Button("Toevoegen");

        grid.add(lblBeschrijving, 0, 0);
        grid.add(txtBeschrijving, 1, 0);
        grid.add(lblMerk, 0, 1);
        grid.add(txtMerk, 1, 1);
        grid.add(lblModel, 0, 2);
        grid.add(txtModel, 1, 2);
        grid.add(btnToevoegen, 1, 3);

        btnToevoegen.setOnAction(e -> {
            // Voeg product toe logica
            product.setBeschrijving(txtBeschrijving.getText());
            // Set other product properties
            // catalogus.voegProductToe(product);
            primaryStage.close();
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}