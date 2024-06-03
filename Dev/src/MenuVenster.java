import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuVenster extends Application {
    private Medewerker medewerker;

    public MenuVenster(Medewerker medewerker) {
        this.medewerker = medewerker;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hoofdmenu - " + medewerker.getGebruikersnaam());

        VBox vbox = new VBox();
        Button btnOverzicht = new Button("Overzicht");
        Button btnBeheer = new Button("Beheer");
        Button btnUitloggen = new Button("Uitloggen");

        vbox.getChildren().addAll(btnOverzicht, btnBeheer, btnUitloggen);

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
            try {
                loginVenster.start(new Stage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}