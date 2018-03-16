package warehouse;

import java.util.HashMap;
import java.util.Map;

public class Provider implements IProvider{

	@Override
	public Map<String, Integer> deliverProduct(String product) {
		
		Map<String, Integer> prod = new HashMap<String, Integer>();
		prod.put(product, 25);
		System.out.println(this.getClass().getSimpleName() + " delivered " + product + " to the shop.");
		System.out.println("-----------------------------------------------------------");
		return prod;
	}

	

}
