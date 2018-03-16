package warehouse;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

public class Shop {

	private HashSet<IClient> clients;
	private Map<String, Integer> products;
	private Storage storage;
	private String name;
	private static int count = 1;

	public Shop(Storage storage) {
		if (storage == null) {
			throw new RuntimeException("No storage was added");
		}
		this.storage = storage;
		this.clients = this.addClients();
		this.products = new HashMap<String, Integer>();
		this.products.putAll(this.storage.getStockInStorage());
		this.name = this.getClass().getSimpleName() + " " + count;
		count++;
	}

	private HashSet<IClient> addClients() {

		HashSet<IClient> buyers = new HashSet<IClient>();
		for (int i = 0; i < 3; i++) {
			buyers.add(new Client());
		}
		return buyers;
	}

	public void open() throws InterruptedException {
		for (IClient client : clients) {
			String product = "";
			int size = this.products.size();
			int item = new Random().nextInt(size);
			int i = 0;
			for (String prod : this.products.keySet()) {
				if (i == item) {
					product = prod;
					break;
				}
				i++;
			}
			int quantity = new Random().nextInt(4) + 1;
			client.buyProduct(product, quantity);
			this.sellProduct(product, quantity);
			Thread.sleep(500);
		}
	}

	private void sellProduct(String product, int quantity) {
		if (this.products.get(product) < quantity) {
			System.out.println("\n" + this.name + ": We don't have enough of this product. We'll order.");
			int residue = this.products.get(product);
			this.products.putAll(this.storage.deliverProduct(product));
			this.products.put(product, this.products.get(product) + residue);
			System.out.println("We received a delivery with " + product + ".\n");
		}
		this.products.put(product, this.products.get(product) - quantity);
	}
}
