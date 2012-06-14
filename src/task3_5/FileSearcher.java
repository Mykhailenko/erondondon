package task3_5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher {
	final private BaseFileFilter fileFilter;
	final private String root;
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
		File [] children = file.listFiles(fileFilter);
		for(File child : children){
			if(child.isDirectory()){
				result.addAll(search(child.getPath()));
			}else{
				result.add(child);
			}
		}
		return result;
	}
}
