package warehouse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Storage implements IProvider {

	private Map<String, Integer> stockInStorage;
	private IProvider provider;

	public Storage(IProvider provider) {
		if (provider == null) {
			throw new RuntimeException("No provider was added");
		}
		this.provider = provider;
		this.stockInStorage = new HashMap<String, Integer>();

	}

	public Map<String, Integer> getStockInStorage() {
		return Collections.unmodifiableMap(stockInStorage);
	}

	public void fillStorage(ISelable product, int capacity) {
		this.stockInStorage.put(product.getName(), capacity);
	}

	private void deliverStock() {
		for (Entry<String, Integer> prod : this.stockInStorage.entrySet()) {
			if (prod.getValue() < 5) {
				System.out.println("-----------------------------------------------------------");
				System.out.println(this.getClass().getSimpleName() + ": got out of " + prod.getKey()
						+ " and is waiting for delivery.");
				int residue = prod.getValue();
				this.stockInStorage.putAll(this.provider.deliverProduct(prod.getKey()));
				this.stockInStorage.put(prod.getKey(), prod.getValue() + residue);
			}
		}
	}

	@Override
	public Map<String, Integer> deliverProduct(String product) {
		this.deliverStock();
		Map<String, Integer> prod = new HashMap<String, Integer>();
		prod.put(product, 5);
		this.stockInStorage.put(product, this.stockInStorage.get(product)-5);
		System.out.println(this.getClass().getSimpleName() + " delivered the stock with " + product + ".");
		return prod;
	}
}
