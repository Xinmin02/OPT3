import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginVenster extends Application {

    private LoginHandler loginHandler;

    public LoginVenster() {
        MedewerkerRepository medewerkerRepository = new MedewerkerRepository();
        this.loginHandler = new LoginHandler(medewerkerRepository);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Venster");

        GridPane grid = new GridPane();
        Label lblGebruikersnaam = new Label("Gebruikersnaam:");
        TextField txtGebruikersnaam = new TextField();
        Label lblWachtwoord = new Label("Wachtwoord:");
        PasswordField txtWachtwoord = new PasswordField();
        Button btnLogin = new Button("Inloggen");

        grid.add(lblGebruikersnaam, 0, 0);
        grid.add(txtGebruikersnaam, 1, 0);
        grid.add(lblWachtwoord, 0, 1);
        grid.add(txtWachtwoord, 1, 1);
        grid.add(btnLogin, 1, 2);

        btnLogin.setOnAction(e -> {
            String gebruikersnaam = txtGebruikersnaam.getText();
            String wachtwoord = txtWachtwoord.getText();
            Medewerker medewerker = loginHandler.verifieer(gebruikersnaam, wachtwoord);
            if (medewerker != null) {
                loginHandler.verwerkLogin(medewerker);
                // Maak een nieuwe ProductRepository
                ProductRepository productRepository = new ProductRepository();
                MenuVenster menuVenster = new MenuVenster(medewerker, productRepository);
                menuVenster.start(new Stage());
                primaryStage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Onjuiste inloggegevens");
                alert.showAndWait();
            }
        });

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
