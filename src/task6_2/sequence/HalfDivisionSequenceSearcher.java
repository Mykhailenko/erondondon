package task6_2.sequence;

import java.io.IOException;
import java.util.Map;

import task6_2.SeqResult;

public class HalfDivisionSequenceSearcher extends AbstractSequenceSearcher {
	private static final int CASH_SIZE = 100;
	private static final ThredCount THRED_COUNT = new ThredCount() {
		@Override
		public int adaptibleThreadCount(long fileLength) {
			return 2;
		}
	};
	private int aproximateStepNumber;
	private int currentStepNumber;
	private byte[] bs;
	private final Map<Integer, SeqResult> cachedResults;
	private final ThredCount thredCount;
	public HalfDivisionSequenceSearcher() {
		thredCount = THRED_COUNT;
		cachedResults = new ConstantCash<Integer, SeqResult>(CASH_SIZE);
	}
	
	public HalfDivisionSequenceSearcher(ThredCount thredCount) {
		super();
		this.thredCount = thredCount;
		this.cachedResults = new ConstantCash<Integer, SeqResult>(CASH_SIZE);
	}
	

	public HalfDivisionSequenceSearcher(Map<Integer, SeqResult> cachedResults) {
		super();
		this.thredCount = THRED_COUNT;
		this.cachedResults = cachedResults;
	}
	

	public HalfDivisionSequenceSearcher(Map<Integer, SeqResult> cachedResults,
			ThredCount thredCount) {
		super();
		this.cachedResults = cachedResults;
		this.thredCount = thredCount;
	}

	@Override
	public void seacrh() {
		try {
			bs = Utility.getBytesFromFile(file);
			halfDivisionAlgorithm();
			done = true;
		} catch (IOException e) {
			errorOccurred = true;
		} finally {
			searching = false;
			cachedResults.clear();
		}
	}

	private void halfDivisionAlgorithm() {
		int MIN_SIZE = 2;
		int MAX_SIZE = bs.length / 2;
		aproximateStepNumber = (int) (Math.log(MAX_SIZE-MIN_SIZE)/Math.log(2));
		currentStepNumber = 0;
		System.out.println("apro=" + aproximateStepNumber);
		algorithmStep(MIN_SIZE, MAX_SIZE);
	}

	private void algorithmStep(int minSize, int maxSize) {
		assert minSize <= maxSize : "minSize (" + minSize
				+ ") greate than maxSize (" + maxSize + ")";
		if (minSize == maxSize) {
			result = getResultForSize(minSize); 
		}else{
			int middle = minSize / 2 + maxSize / 2;
			SeqResult temp = getResultForSize(middle);
			if(temp == null){
				if(minSize < middle){
					algorithmStep(minSize, middle - 1);
				}else{
					result = temp;
					return;
				}
			}else{
				if(middle < maxSize){
					SeqResult nextTemp = getResultForSize(middle + 1);
					if(nextTemp == null){
						result = temp;
					}else{
						algorithmStep(middle + 1,  maxSize);
					}
				}else{
					result = temp;
				}
			}
		}
	}

	private SeqResult getResultForSize(int minSize) {
		if(cachedResults.containsKey(minSize)){
			return cachedResults.get(minSize);
		}else{
			SeqResult result = calcultResultForSize(minSize);
			cachedResults.put(minSize, result);
			return result;
		}
	}

	private SeqResult calcultResultForSize(int size) {
		++currentStepNumber;
		progreassStatus = currentStepNumber * 100 / aproximateStepNumber;
		int threadSize = thredCount.adaptibleThreadCount(bs.length);
		if(threadSize > 1){
			int piece = bs.length / threadSize;
			SizeCheckerThread [] arrThreads = new SizeCheckerThread[threadSize];
			Thread [] arr = new Thread[threadSize];
			for (int i = 0; i < arrThreads.length; i++) {
				if(i == arrThreads.length - 1){
					arrThreads[i] = new SizeCheckerThread(bs, size, i * piece, arrThreads.length);
				}else{
					arrThreads[i] = new SizeCheckerThread(bs, size, i * piece, (i+1) * piece);
				}
				arr[i] = new Thread(arrThreads[i]);
				arr[i].start();
			}
			for (int i = 0; i < arr.length; i++) {
				try {
					arr[i].join();
				} catch (InterruptedException e) {
				}
			}
			SeqResult result = null;
			for (int i = 0; i < arrThreads.length && result == null; i++) {
				result = arrThreads[i].getResult();
			}
			return result;
		}else{
			SizeCheckerThread synch = new SizeCheckerThread(bs, size);
			System.out.println(currentStepNumber + " : " + size);
			return synch.getResult();
		}
	}
}
