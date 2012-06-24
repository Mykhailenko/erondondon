package task6_2.sequence;

import java.io.File;

import task6_2.SeqResult;

/**
 * Search for the longest repeated sequences in the file.
 * @author tas
 *
 */
public interface SequnceSearcher {
	/**
	 * 
	 * @return true - if ready to search.
	 */
	boolean isReadyToSearch();
	
	/**
	 * Set up the file and start to search for the longest repeated sequences in the file.
	 * @param file
	 * @return true - if file set, false - if file not set(because search in progress already)
	 */
	boolean setupFileAndStartSearch(File file);
	
	/**
	 * 
	 * @return percents completeness of task
	 */
	int getProgressStatus();

	/**
	 * 
	 * @return true - if task done, false - if task have not done yet, or error occurred.  
	 */
	boolean isDone();
	
	/**
	 * 
	 * @return true - if some error occurred.
	 */
	boolean isErrorOccurred();
	
	/**
	 * This method should be called after method <code>isDode</code> return true, and before next start searching.
	 * @return
	 */
	SeqResult getResultOfSearchAndResetSearcher();
	
}
