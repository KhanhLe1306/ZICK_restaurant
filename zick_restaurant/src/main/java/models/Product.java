package models;

public class Product {
	String productCode;
	String name;
	String price;
	String description;
	
	public Product(String productCode, String name, String price, String description) {
		this.productCode = productCode;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", name=" + name + ", price=" + price + ", description="
				+ description + "]";
	}
	
	
}
