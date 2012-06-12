package task2_2;

public abstract class AbstractArticul {
	final protected String articul;
	final protected int hash;
	protected AbstractArticul(String articul) {
		super();
		this.articul = articul;
		if(this.articul == null){
			throw new IllegalArgumentException();
		}
		hash = calculateHashCode();
	}
	
	protected abstract int calculateHashCode();
	
	@Override
	public int hashCode() {
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractArticul other = (AbstractArticul) obj;
		if (articul == null) {
			if (other.articul != null)
				return false;
		} else if (!articul.equals(other.articul))
			return false;
		return true;
	}



	public String getArticul() {
		return articul;
	}
	
	@Override
	public String toString() {
		return articul;
	}
}
