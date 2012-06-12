package task2_2;

public class Articul1 extends AbstractArticul {

	protected Articul1(String articul) {
		super(articul);
	}

	@Override
	protected int calculateHashCode() {
		int numberOfFirstSymbols = 4;
		int result = 0;
		if(articul.length() < numberOfFirstSymbols){
			numberOfFirstSymbols = articul.length();
		}
		for(int i = 0; i < numberOfFirstSymbols; ++i){
			result += articul.charAt(i);
		}
		return result;
	}

}
