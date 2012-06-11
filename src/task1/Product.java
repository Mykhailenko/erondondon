package task1;

import java.text.MessageFormat;

public abstract class Product {
	private String id;
	private String title;
	private String producer;
	private String description;
	protected Product() {
		super();
	}
	
	
	protected Product(String id, String title, String producer, String description) {
		super();
		this.id = id;
		this.title = title;
		this.producer = producer;
		this.description = description;
	}
	

	@Override
	public String toString() {
		return MessageFormat.format(
				"Product [id={0}, title={1}, producer={2}, description={3}]",
				id, title, producer, description);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
