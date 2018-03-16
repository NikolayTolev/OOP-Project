package warehouse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		try {
			IProvider provider = new Provider();
			Storage market = new Storage(provider);
			
			market.fillStorage(new Fruit("Banana"), 15);
			market.fillStorage(new Fruit("Apple"), 15);
			market.fillStorage(new Fruit("Orange"), 15);
			market.fillStorage(new Vegetable("Cucumper"), 15);
			market.fillStorage(new Vegetable("Patato"), 15);
			market.fillStorage(new Vegetable("Eggplant"), 15);
			market.fillStorage(new Meat("Beef"), 15);
			market.fillStorage(new Meat("Pork"), 15);
			market.fillStorage(new Meat("Chicken"), 15);


			List<Shop> shops = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				shops.add(new Shop(market));
			}
			
			while(true) {
				for (Shop shop : shops) {
					shop.open();
				}
			}
		} catch (Exception e) {
			System.out.println("Sorry.");
		}
	}
}
