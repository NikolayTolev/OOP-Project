package warehouse;

class Client implements IClient {

	private String name;
	private static int count = 1;

	public Client() {
		this.name = this.getClass().getSimpleName() + count;
		count++;
	}

	@Override
	public void buyProduct(String product, int quantity) {
		System.out.println(this.name + ": Very tasty " + product + ". I want " + quantity + " !");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
