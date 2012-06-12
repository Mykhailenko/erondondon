package task1;

import java.text.MessageFormat;

import task2_2.AbstractArticul;

public abstract class Product {
	private AbstractArticul articul;
	private String title;
	private String producer;
	private String description;
	protected Product() {
		super();
	}
	
	
	protected Product(AbstractArticul articul, String title, String producer, String description) {
		super();
		this.articul = articul;
		this.title = title;
		this.producer = producer;
		this.description = description;
	}
	

	@Override
	public String toString() {
		return MessageFormat.format(
				"Product [id={0}, title={1}, producer={2}, description={3}]",
				articul, title, producer, description);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articul == null) ? 0 : articul.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Product other = (Product) obj;
		if (articul == null) {
			if (other.articul != null)
				return false;
		} else if (!articul.equals(other.articul))
			return false;
		return true;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getProducer() {
		return producer;
	}


	public void setProducer(String producer) {
		this.producer = producer;
	}

	

	public AbstractArticul getArticul() {
		return articul;
	}


	public void setArticul(AbstractArticul articul) {
		this.articul = articul;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
