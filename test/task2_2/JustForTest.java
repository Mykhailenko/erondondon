package task2_2;

import task1.Product;

public class JustForTest extends Product {
	protected JustForTest() {
		super();
	}
	
	
	protected JustForTest(AbstractArticul articul, String title, String producer, String description) {
		super(articul, title, producer, description);
	}
	@Override
	public String toString() {
		return getArticul().hash + " " + super.toString();
	}
}
