package task3_5;

import java.io.File;

public class FileSizeFilter extends BaseFileFilter{
	private enum WorkMode {
		FROM, TO, FROMTO, EXACTLY, NOTSET; 
	}

	private long from;
	private long to;
	private long exactly;
	private WorkMode mode;
	public FileSizeFilter(BaseFileFilter baseFileFilter) {
		super(baseFileFilter);
		mode = WorkMode.NOTSET;
	}
	public FileSizeFilter() {
		super();
		mode = WorkMode.NOTSET;
	}
	public class F {
		FileSizeFilter fileSizeFilter;

		public F(FileSizeFilter fileSizeFilter) {
			super();
			this.fileSizeFilter = fileSizeFilter;
		}
		public FileSizeFilter create(){
			return fileSizeFilter;
		}
		public F from(long from){
			fileSizeFilter.from = from;
			fileSizeFilter.mode = WorkMode.FROM;
			return this;
		}
		public F to(long to){
			fileSizeFilter.to = to;
			fileSizeFilter.mode = WorkMode.TO;
			return this;
		}
		public F fromTo(long from, long to){
			fileSizeFilter.from = from;
			fileSizeFilter.to = to;
			fileSizeFilter.mode = WorkMode.FROMTO;
			return this;
		}
		public F exactly(long exactly){
			fileSizeFilter.exactly = exactly;
			fileSizeFilter.mode = WorkMode.EXACTLY;
			return this;
		}
	}
	public F from(long from){
		F f = new F(this);
		return f.from(from);
	}
	public F to(long to){
		F f = new F(this);
		return f.to(to);
	}
	public F fromTo(long from, long to){
		F f = new F(this);
		return f.fromTo(from, to);
	}
	public F exactly(long exactly){
		F f = new F(this);
		return f.exactly(exactly);
	}
	@Override
	protected boolean realAccept(File file) {
		switch (mode) {
		case FROM:
			return from <= file.length();
		case TO:
			return file.length() <= to; 
		case FROMTO:
			return ((from <= file.length()) && (file.length() <= to));
		case EXACTLY:
			return file.length() == exactly;
		case NOTSET:
			return true;
		default:
			return false;
		}
	}

}
