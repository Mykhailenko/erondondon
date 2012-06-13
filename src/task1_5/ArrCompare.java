package task1_5;

import java.util.Comparator;

public class ArrCompare implements Comparator{
	private Comparator [] comparators;

	public ArrCompare(Comparator ... args) {
		super();
		this.comparators = args;
	}
	@Override
	public int compare(Object a, Object b) {
		int result = 0;
    	for(Comparator c : comparators){
    		result = c.compare(a, b);
    		if(result != 0){
    			break;
    		}
    	}
    	return result;
    }
}
