package task6_2.sequence;

import java.util.Arrays;

import task6_2.SeqResult;

public class SizeCheckerThread implements Runnable{
	private byte [] bs;
	private int size;
	private int ifrom;
	private int ito;
	private SeqResult result = null;
	
	
	public SizeCheckerThread(byte[] bs, int size) {
		super();
		this.bs = bs;
		this.size = size;
		this.ifrom = 0;
		this.ito = this.bs.length;
	}
	
	
	
	public SizeCheckerThread(byte[] bs, int size, int ifrom, int ito) {
		super();
		this.bs = bs;
		this.size = size;
		this.ifrom = ifrom;
		this.ito = ito;
	}



	private void calculateSeqResult(){
		for (int i = ifrom; i < ito; ++i) {
			for (int j = i + size; j < ito - size; j++) {
				if(Utility.compareArrays(bs, i, bs, j, size)){
					result = new SeqResult(size, i, j, new String(Arrays.copyOfRange(bs, i, i + size)));
					return;
				}
			}
		}
		result = null;
	}
	
	public SeqResult getResult(){
		if(result == null){
			calculateSeqResult();
		}
		return result;
	}
	
	@Override
	public void run() {
		calculateSeqResult();
	}
	
}
