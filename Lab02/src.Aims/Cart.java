package lab;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[]= new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	int qtyOrder = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrder < MAX_NUMBERS_ORDERED-1) {
			itemOrdered[qtyOrder] = disc;
			qtyOrder ++;
			System.out.println("The disc has been added");
		}else if(qtyOrder >= MAX_NUMBERS_ORDERED-1) {
			System.out.println("The cart is full");
		}else {
			itemOrdered[qtyOrder] = disc;
			qtyOrder ++;
			System.out.println("The cart is almost full");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrder <1) {
			System.out.println("The cart is empty");
		}else {
			int check = 0 ;
			int pos = 0;
			for(int i=0; i<MAX_NUMBERS_ORDERED; i++) {
				if(itemOrdered[qtyOrder] == disc ) {
					check = 1;
					pos = i;
				}
			}
			if(check == 0) {
				for(int j=pos+1; j<MAX_NUMBERS_ORDERED; j++) {
					itemOrdered[j-1] = itemOrdered[j];
				}
				itemOrdered[MAX_NUMBERS_ORDERED-1] = null;
				qtyOrder--;
			}
		}
	}
	public float totalCost() {
		float sum = 0;
		for(int i=0; i<MAX_NUMBERS_ORDERED; i++) {
			if(itemOrdered[i] != null) {
				sum += itemOrdered[i].getCost();
			}
		}
		return sum;
	}
	public void displayCart() {
    	for(int i = 0; i < qtyOrder; i++) {
    		System.out.println((i+1) + " " + itemOrdered[i].getTitle() + " " +itemOrdered[i].getCost());
    	}
    }
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
	    for (DigitalVideoDisc disc : dvdList) {
	        if (qtyOrder >= MAX_NUMBERS_ORDERED) {
	            System.out.println("The cart is full!");
	            break;
	        }
	        
	        addDigitalVideoDisc(disc);
	    }
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
}