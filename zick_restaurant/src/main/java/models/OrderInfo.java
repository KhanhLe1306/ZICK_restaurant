package models;

import java.util.List;

public class OrderInfo {
	int orderId; 
	int customerId;
	String firstName;
	String dateOrdered;
	String total;
	String status;
	List<Product> products;

	public OrderInfo(int orderId, int customerId, String firstName, String dateOrdered, String total, String status,
			List<Product> products) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.firstName = firstName;
		this.dateOrdered = dateOrdered;
		this.total = total;
		this.status = status;
		this.products = products;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(String dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	} 
	
	
}
