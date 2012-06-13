package task2_2;

public class Articul1 extends AbstractArticul {

	protected Articul1(String articul) {
		super(articul);
	}

	@Override
	protected int calculateHashCode() {
		int numberOfFirstSymbols = 4;
		int result = 0;
		int founed = 0;
		for(int i = 0; i < articul.length() && founed < numberOfFirstSymbols; ++i){
			char ch = articul.charAt(i);
			if(Character.isDigit(ch)){
				result += (ch - '0');
				++founed;
			}
		}
		return result;
	}

}
