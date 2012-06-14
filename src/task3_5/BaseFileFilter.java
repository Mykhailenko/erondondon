package task3_5;

import java.io.File;
import java.io.FileFilter;

public abstract class BaseFileFilter implements FileFilter{
	private BaseFileFilter baseFilter;
	public BaseFileFilter() {
		baseFilter = null;
	}
	public BaseFileFilter(BaseFileFilter baseFilter) {
		super();
		this.baseFilter = baseFilter;
	}
	protected abstract boolean realAccept(File file);
	@Override
	public boolean accept(File file) {
		if(realAccept(file)){
			if(baseFilter != null){
				return baseFilter.accept(file);
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
	protected static String getOnlyName(String fileName){
		int index = fileName.lastIndexOf('.');
		if(index > 0){
			return fileName.substring(0, index);
		}else{
			return fileName;
		}
	}
	protected static String getOnlyExtension(String fileName){
		int index = fileName.lastIndexOf('.');
		if(index > 0){
			return fileName.substring(index + 1);
		}else{
			return "";
		}
	}
}
