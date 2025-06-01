package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

import java.util.Scanner;
public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation",19.95f, 87, "Roger Allers");
        cart.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", 24.95f, 87, "George Lucas");
        cart.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
                "Animation", 18.99f);
        cart.addMedia(dvd3);
        cart.print();
        System.out.println("Enter the id of DVD you want to search: ");
        Scanner keyboard = new Scanner(System.in);
        int idForSearch = keyboard.nextInt();
        cart.searchById(idForSearch);
        System.out.println("Enter the title of DVD you want to search: ");
        keyboard.close();
        keyboard = new Scanner(System.in);
        String titleForSearch = keyboard.nextLine();
        cart.searchByTitle(titleForSearch);
        keyboard.close();
    }
} 