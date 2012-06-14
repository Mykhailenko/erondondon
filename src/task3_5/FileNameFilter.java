package task3_5;

import java.io.File;

public class FileNameFilter extends BaseFileFilter {
	private String[] fileNames;
	private boolean caseSensitive;

	public FileNameFilter(BaseFileFilter baseFileFilter) {
		super(baseFileFilter);
		caseSensitive = true;
	}
	public FileNameFilter() {
		super();
		caseSensitive = true;
	}
	public class F {
		FileNameFilter fileNameFilter;

		public F(FileNameFilter fileNameFilter) {
			super();
			this.fileNameFilter = fileNameFilter;
		}

		public FileNameFilter create() {
			return fileNameFilter;
		}
		public F insensitive() {
			fileNameFilter.caseSensitive = false;
			return this;
		}
		public F sensitive(){
			fileNameFilter.caseSensitive = true;
			return this;
		}
		public F names(String ...names){
			fileNameFilter.fileNames = names;
			return this;
		}
	}

	public F insensitive() {
		F f = new F(this);
		return f.insensitive();
	}
	public F sensitive(){
		F f = new F(this);
		return f.sensitive();
	}
	public F names(String ...names){
		F f = new F(this);
		return f.names(names);
	}
	@Override
	protected boolean realAccept(File file) {
		if(fileNames == null){
			return true;
		}
		if (caseSensitive) {
			for (String s : fileNames) {
				if (s.equals(getOnlyName(file.getName()))) {
					return true;
				}
			}
			return false;
		} else {
			for (String s : fileNames) {
				if (s.equalsIgnoreCase(getOnlyName(file.getName()))) {
					return true;
				}
			}
			return false;
		}
	}
}
