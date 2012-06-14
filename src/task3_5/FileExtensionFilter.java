package task3_5;

import java.io.File;


public class FileExtensionFilter extends BaseFileFilter {
	private String[] extensions;
	private boolean caseSensitive;

	public FileExtensionFilter(BaseFileFilter baseFileFilter) {
		super(baseFileFilter);
		caseSensitive = true;
	}
	public FileExtensionFilter() {
		super();
		caseSensitive = true;
	}
	public class F {
		FileExtensionFilter fileExtensionFilter;

		public F(FileExtensionFilter fileExtensionFilter) {
			super();
			this.fileExtensionFilter = fileExtensionFilter;
		}

		public FileExtensionFilter create() {
			return fileExtensionFilter;
		}
		public F insensitive() {
			fileExtensionFilter.caseSensitive = false;
			return this;
		}
		public F sensitive(){
			fileExtensionFilter.caseSensitive = true;
			return this;
		}
		public F names(String...names){
			fileExtensionFilter.extensions = names;
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
	public F names(String...exts){
		F f = new F(this);
		return f.names(exts);
	}
	@Override
	protected boolean realAccept(File file) {
		if(extensions == null){
			return true;
		}
		if(caseSensitive){
			for(String s : extensions){
				if(s.equals(getOnlyExtension(file.getName()))){
					return true;
				}
			}
			return false;
		}else{
			for(String s : extensions){
				if(s.equalsIgnoreCase(getOnlyExtension(file.getName()))){
					return true;
				}
			}
			return false;
		}
	}

}

