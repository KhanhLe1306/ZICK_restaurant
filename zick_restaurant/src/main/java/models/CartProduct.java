package models;

public class CartProduct {
	String productCode;
	String name;
	String price;
	String description;
	String quantity;
	public CartProduct(String productCode, String name, String price, String description, String quantity) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartProduct [productCode=" + productCode + ", name=" + name + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + "]";
	}
}
