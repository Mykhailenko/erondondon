package task2_2;

public class Articul0 extends AbstractArticul {

	protected Articul0(String articul) {
		super(articul);
	}

	@Override
	protected int calculateHashCode() {
		return articul.length();
	}

}
