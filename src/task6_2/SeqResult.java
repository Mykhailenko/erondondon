package task6_2;

import java.text.MessageFormat;

public class SeqResult {
	private int size;
	private int firstIndex;
	private int secondIndex;
	private String result;
	
	
	public SeqResult(int size, int firstIndex, int secondIndex, String result) {
		super();
		this.size = size;
		this.firstIndex = firstIndex;
		this.secondIndex = secondIndex;
		this.result = result;
	}
	@Override
	public String toString() {
		return MessageFormat
				.format("SeqResult [size={0}, firstIndex={1}, secondIndex={2}, result={3}]",
						size, firstIndex, secondIndex, result);
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
}
