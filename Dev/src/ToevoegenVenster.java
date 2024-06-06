import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ToevoegenVenster extends Application {
    private ProductRepository productRepository;

    public ToevoegenVenster(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Product Toevoegen");

        GridPane grid = new GridPane();
        Label lblType = new Label("Type:");
        ComboBox<String> cmbType = new ComboBox<>();
        cmbType.getItems().addAll("Personenauto", "Vrachtauto", "Boormachine");

        Label lblBeschrijving = new Label("Beschrijving:");
        TextField txtBeschrijving = new TextField();

        Label lblMerk = new Label("Merk:");
        TextField txtMerk = new TextField();

        Label lblGewicht = new Label("Gewicht:");
        TextField txtGewicht = new TextField();

        Label lblMotorinhoud = new Label("Motorinhoud:");
        TextField txtMotorinhoud = new TextField();

        Label lblLaadvermogen = new Label("Laadvermogen:");
        TextField txtLaadvermogen = new TextField();

        Label lblTypeBoormachine = new Label("Type Boormachine:");
        TextField txtTypeBoormachine = new TextField();

        Button btnOpslaan = new Button("Opslaan");

        grid.add(lblType, 0, 0);
        grid.add(cmbType, 1, 0);
        grid.add(lblBeschrijving, 0, 1);
        grid.add(txtBeschrijving, 1, 1);
        grid.add(lblMerk, 0, 2);
        grid.add(txtMerk, 1, 2);
        grid.add(lblGewicht, 0, 3);
        grid.add(txtGewicht, 1, 3);
        grid.add(lblMotorinhoud, 0, 4);
        grid.add(txtMotorinhoud, 1, 4);
        grid.add(lblLaadvermogen, 0, 5);
        grid.add(txtLaadvermogen, 1, 5);
        grid.add(lblTypeBoormachine, 0, 6);
        grid.add(txtTypeBoormachine, 1, 6);
        grid.add(btnOpslaan, 1, 7);

        btnOpslaan.setOnAction(e -> {
            String type = cmbType.getValue();
            String beschrijving = txtBeschrijving.getText();
            String merk = txtMerk.getText();

            if (type.equals("Personenauto")) {
                int gewicht = Integer.parseInt(txtGewicht.getText());
                int motorinhoud = Integer.parseInt(txtMotorinhoud.getText());
                Product nieuwePersonenauto = new Personenauto(beschrijving, merk, gewicht, motorinhoud);
                productRepository.addProduct(nieuwePersonenauto);
            } else if (type.equals("Vrachtauto")) {
                int laadvermogen = Integer.parseInt(txtLaadvermogen.getText());
                int motorinhoud = Integer.parseInt(txtMotorinhoud.getText());
                Product nieuweVrachtauto = new Vrachtauto(beschrijving, laadvermogen, motorinhoud);
                productRepository.addProduct(nieuweVrachtauto);
            } else if (type.equals("Boormachine")) {
                String typeBoormachine = txtTypeBoormachine.getText();
                Product nieuweBoormachine = new Boormachine(beschrijving, merk, typeBoormachine);
                productRepository.addProduct(nieuweBoormachine);
            }

            primaryStage.close();
        });

        Scene scene = new Scene(grid, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
