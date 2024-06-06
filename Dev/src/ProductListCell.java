import javafx.scene.control.ListCell;

public class ProductListCell extends ListCell<Product> {
    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null || item.getBeschrijving() == null) {
            setText(null);
        } else {
            setText(item.getBeschrijving());
        }
    }
}