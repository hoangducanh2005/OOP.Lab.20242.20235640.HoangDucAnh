package lab;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion king", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation","Thomas Alan", 87 , 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.displayCart();
//		anOrder.removeDigitalVideoDisc(dvd1);
//		anOrder.displayCart();
		System.out.println("Total Cost is: "+anOrder.totalCost());
	}
}
