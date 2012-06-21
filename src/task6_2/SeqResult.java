package task6_2;

import java.text.MessageFormat;

public class SeqResult {
	private int size;
	private int firstIndex;
	private int secondIndex;
	
	public SeqResult(int size, int firstIndex, int secondIndex) {
		super();
		this.size = size;
		this.firstIndex = firstIndex;
		this.secondIndex = secondIndex;
	}
	
	
	@Override
	public String toString() {
		return MessageFormat.format(
				"SeqResult [size={0}, firstIndex={1}, secondIndex={2}]",
				size, firstIndex, secondIndex);
	}


	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getFirstIndex() {
		return firstIndex;
	}
	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}
	public int getSecondIndex() {
		return secondIndex;
	}
	public void setSecondIndex(int secondIndex) {
		this.secondIndex = secondIndex;
	}
	
}
