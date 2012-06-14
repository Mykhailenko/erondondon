package task3_5;

import java.io.File;
import java.util.Date;

import task3_5.FileSizeFilter.F;

public class FileLastModifiedFilter extends BaseFileFilter{
	private enum WorkMode {
		FROM, TO, FROMTO, EXACTLY, NOTSET; 
	}
	private Date from;
	private Date to;
	private Date exactly;
	private WorkMode mode;

	public FileLastModifiedFilter(BaseFileFilter baseFileFilter){
		super(baseFileFilter);
		mode = WorkMode.NOTSET;
	}
	public FileLastModifiedFilter() {
		super();
		mode = WorkMode.NOTSET;
	}
	public class F {
		FileLastModifiedFilter filter;

		public F(FileLastModifiedFilter filter) {
			super();
			this.filter = filter;
		}
		public FileLastModifiedFilter create(){
			return filter;
		}
		public F from(Date from){
			filter.from = from;
			filter.mode = WorkMode.FROM;
			return this;
		}
		public F to(Date to){
			filter.to = to;
			filter.mode = WorkMode.TO;
			return this;
		}
		public F fromTo(Date from, Date to){
			filter.from = from;
			filter.to = to;
			filter.mode = WorkMode.FROMTO;
			return this;
		}
		public F exactly(Date exactly){
			filter.exactly = exactly;
			filter.mode = WorkMode.EXACTLY;
			return this;
		}
	}
	
	public F from(Date from){
		F f = new F(this);
		return f.from(from);
	}
	public F to(Date to){
		F f = new F(this);
		return f.to(to);
	}
	public F fromTo(Date from, Date to){
		F f = new F(this);
		return f.fromTo(from, to);
	}
	public F exactly(Date exactly){
		F f = new F(this);
		return f.exactly(exactly);
	}
	@Override
	protected boolean realAccept(File file) {
		switch (mode) {
		case FROM:
			return from.getTime() <= file.lastModified();
		case TO:
			return file.lastModified() <= to.getTime(); 
		case FROMTO:
			return ((from.getTime() <= file.lastModified()) && (file.lastModified() <= to.getTime()));
		case EXACTLY:
			return file.lastModified() == exactly.getTime();
		default:
			return false;
		}
	}
}
