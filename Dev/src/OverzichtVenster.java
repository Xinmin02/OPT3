import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OverzichtVenster extends Application implements Observer {
    private ProductRepository productRepository;
    private ObservableList<Product> productenObservable;

    public OverzichtVenster(ProductRepository productRepository) {
        this.productRepository = productRepository;
        this.productRepository.addObserver(this);
        this.productenObservable = FXCollections.observableArrayList(productRepository.getProducten());
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overzicht");

        VBox vbox = new VBox();
        Label lblOverzicht = new Label("Overzicht van alle producten");

        ListView<Product> listView = new ListView<>(productenObservable);
        listView.setCellFactory(param -> new ListCell<Product>() {
            @Override
            protected void updateItem(Product item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.getBeschrijving() == null) {
                    setText(null);
                } else {
                    setText(item.getBeschrijving());
                }
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                DetailVenster detailVenster = new DetailVenster(newValue);
                detailVenster.start(new Stage());
            }
        });

        vbox.getChildren().addAll(lblOverzicht, listView);

        Scene scene = new Scene(vbox, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void update() {
        productenObservable.setAll(productRepository.getProducten());
    }
}
