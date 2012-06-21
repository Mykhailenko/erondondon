package task3_5;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSearcher {
	final private BaseFileFilter fileFilter;
	final private String root;
	final private static BaseFileFilter directoryFilter = new FileDirectoryFilter();
	public FileSearcher(BaseFileFilter fileFilter, String root) {
		super();
		this.fileFilter = fileFilter;
		this.root = root;
	}
	public List<File> search(){
		return search(root);
	}
	public List<File> search(String root){
		List<File> result = new ArrayList<File>();
		File file = new File(root);
		result.addAll(Arrays.asList(file.listFiles(fileFilter)));
		File [] children = file.listFiles(directoryFilter);
		for(File child : children){
			result.addAll(search(child.getPath()));
		}
		return result;
	}
}
