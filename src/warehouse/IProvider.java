package warehouse;

import java.util.Map;

public interface IProvider {

	Map<String, Integer> deliverProduct(String product);
}
