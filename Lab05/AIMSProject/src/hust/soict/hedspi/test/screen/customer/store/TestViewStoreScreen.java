package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.screen.customer.controller.ViewStoreController;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store;
    private static Cart cart;


    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        Parent root = loader.load(); // Chỉ cần gọi load()
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", 19.95f, 120, "Adam Lavine");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, 135, "David Dean");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f, 211, "Lucas Vasquez");
        Book book1 = new Book("The Alchemist", "Novel", 12.5f);
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", 9.99f, "Michael Jackson", "Hannah");
        Track track1 = new Track("Billie Jean", 236);
        Track track2 = new Track("Beat It", 252);
        Track track3 = new Track("Man in the Mirror", 331);
        cd1.addTrack(track1); cd1.addTrack(track2); cd1.addTrack(track3);
        CompactDisc cd2 = new CompactDisc("LastDance", "Rock", 20.2f, "Michael B", "Adam Rockstar");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(cd1);
        store.addMedia(cd2);
        launch(args);
    }
}
