package models;

public class Customer {
	
	int customerId;
	String firstName;
	String lastName;
	String createdOn;

	public Customer(int customerId, String firstName, String lastName, String createdOn) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.createdOn = createdOn;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", createdOn=" + createdOn + "]";
	}
	
}
