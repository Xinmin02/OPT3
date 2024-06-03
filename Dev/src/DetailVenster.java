import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DetailVenster extends Application implements Observer {
    private Product product;
    private Label lblDetails;
    private Label lblStatus;

    public DetailVenster(Product product) {
        this.product = product;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Productdetails");

        VBox vbox = new VBox();
        lblDetails = new Label(product.getDetails());
        lblStatus = new Label(product.isOpVoorraad() ? "Op voorraad" : "Verhuurd");

        vbox.getChildren().addAll(lblDetails, lblStatus);

        if (product.isOpVoorraad()) {
            CheckBox chkVerzekeren = new CheckBox("Verzekeren?");
            Label lblHuurprijs = new Label("Huurprijs per dag: " + product.getPrice());
            TextField txtKlantNaam = new TextField();
            txtKlantNaam.setPromptText("Klantnaam");
            Button btnVerhuur = new Button("Verhuur");

            chkVerzekeren.setOnAction(e -> {
                lblHuurprijs.setText("Huurprijs per dag: " + (chkVerzekeren.isSelected() ? (product.getPrice() + product.getInsurance()) : product.getPrice()));
            });

            btnVerhuur.setOnAction(e -> {
                // Verhuur logica
                product.setOpVoorraad(false);
                // Add logic to update rental information
                update();
            });

            vbox.getChildren().addAll(chkVerzekeren, lblHuurprijs, txtKlantNaam, btnVerhuur);
        } else {
            Label lblKlantInfo = new Label("Verhuurd aan: Klantnaam"); // Fetch actual customer name
            Button btnRetour = new Button("Retour");

            btnRetour.setOnAction(e -> {
                // Retour logica
                product.setOpVoorraad(true);
                update();
            });

            vbox.getChildren().addAll(lblKlantInfo, btnRetour);
        }

        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update() {
        lblDetails.setText(product.getDetails());
        lblStatus.setText(product.isOpVoorraad() ? "Op voorraad" : "Verhuurd");
    }
}