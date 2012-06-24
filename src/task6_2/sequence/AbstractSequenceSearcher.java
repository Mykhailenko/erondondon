package task6_2.sequence;

import java.io.File;

import task6_2.SeqResult;

public abstract class AbstractSequenceSearcher extends Thread implements SequnceSearcher{
	protected volatile boolean searching;
	protected volatile boolean done;
	protected volatile boolean errorOccurred;
	
	protected volatile int progreassStatus;
	protected volatile File file;
	protected volatile SeqResult result;
	
	@Override
	public void run() {
		while(true){
			waitForFile();
			seacrh();
		}
	}
	protected abstract void seacrh() ;
	
	private synchronized void waitForFile(){
		while(searching == false){
			try {
				wait();
			} catch (InterruptedException e) {	}
		}
	}
	
	@Override
	public synchronized boolean setupFileAndStartSearch(File file) {
		if(searching == false){
			initWithFile(file);
			notify();
			return true;
		}else{
			return false;
		}
	}
	
	private void initWithFile(File file) {
		chechFile(file);
		this.file = file;
		errorOccurred = false;
		done = false;
		searching = true;
		progreassStatus = 0;
	}

	private void chechFile(File file) {
		if(file == null){
			throw new IllegalArgumentException("'setupFileAndStartSearch' can not work with NULL pointer.");
		}
	}
	@Override
	public int getProgressStatus() {
		return progreassStatus;
	}

	@Override
	public boolean isReadyToSearch() {
		return searching == false;
	}

	@Override
	public boolean isDone() {
		return done;
	}

	@Override
	public boolean isErrorOccurred() {
		return errorOccurred;
	}

	@Override
	public synchronized SeqResult getResultOfSearchAndResetSearcher() {
		checkIfDone();
		return result;
	}
	private void checkIfDone() {
		if(!isDone()){
			throw new IllegalStateException("you should invoke 'getResultOfSearchAndResetSearcher' only after 'isDone' returned ture");
		}
	}


}
