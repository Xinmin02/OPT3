
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuVenster extends Application {
    private Medewerker ingelogdeMedewerker;

    public MenuVenster(Medewerker medewerker) {
        this.ingelogdeMedewerker = medewerker;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hoofdmenu");

        VBox vbox = new VBox();
        Label lblWelkom = new Label("Welkom, " + ingelogdeMedewerker.getGebruikersnaam());
        Button btnOverzicht = new Button("Overzicht");
        Button btnBeheer = new Button("Beheer");
        Button btnUitloggen = new Button("Uitloggen");

        vbox.getChildren().addAll(lblWelkom, btnOverzicht, btnBeheer, btnUitloggen);

        btnOverzicht.setOnAction(e -> {
            OverzichtVenster overzichtVenster = new OverzichtVenster();
            overzichtVenster.start(new Stage());
        });

        btnBeheer.setOnAction(e -> {
            BeheerVenster beheerVenster = new BeheerVenster();
            beheerVenster.start(new Stage());
        });

        btnUitloggen.setOnAction(e -> {
            primaryStage.close();
            LoginVenster loginVenster = new LoginVenster();
            loginVenster.start(new Stage());
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
