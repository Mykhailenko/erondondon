package task6_2.sequence;

import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public final class ConstantCash <K, V> extends
		LinkedHashMap <K,V>{
	private final int cashSize;
	
	public ConstantCash(int cashSize) {
		super();
		this.cashSize = cashSize;
	}

	protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
		return size() > cashSize;
	}
}