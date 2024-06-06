import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailVenster extends Application {
    private Product product;

    public DetailVenster(Product product) {
        this.product = product;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Productdetails");

        VBox vbox = new VBox();
        Label lblBeschrijving = new Label("Beschrijving: " + product.getBeschrijving());
        Label lblDetails = new Label("Details: " + product.getDetails());
        Label lblHuurprijs = new Label("Huurprijs per dag: " + product.getHuurprijsPerDag());

        vbox.getChildren().addAll(lblBeschrijving, lblDetails, lblHuurprijs);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
