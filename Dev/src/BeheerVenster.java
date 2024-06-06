import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BeheerVenster extends Application {
    private Medewerker ingelogdeMedewerker;

    public BeheerVenster(Medewerker medewerker) {
        this.ingelogdeMedewerker = medewerker;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Beheer");

        VBox vbox = new VBox();
        Label lblBeheer = new Label("Beheer van producten");

        Button btnToevoegen = new Button("Product Toevoegen");

        btnToevoegen.setOnAction(e -> {
            ToevoegenVenster toevoegenVenster = new ToevoegenVenster(ingelogdeMedewerker);
            toevoegenVenster.start(new Stage());
        });

        vbox.getChildren().addAll(lblBeheer, btnToevoegen);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
