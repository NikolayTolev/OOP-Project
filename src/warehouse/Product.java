package warehouse;

public abstract class Product implements ISelable {

	private String name;
	
	public Product(String productName) {
		if (productName == null || productName.isEmpty()) {
			throw new RuntimeException("Invalid product name int class" + this.getClass().getSimpleName());
		}
		this.name = productName;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
