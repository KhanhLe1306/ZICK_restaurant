package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import models.*;

public class DBUtil {
	
	public static List<Customer> getAllCustomers() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Customer> list = new ArrayList<>();
		
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Customer";
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();	
			while(rs.next()) {
				Customer customer = new Customer(rs.getInt("Customer_id"), rs.getString("Firstname"), rs.getString("Lastname"), rs.getString("Created_on"));
				System.out.println(customer);
				list.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}
	
	public static Customer getCustomer(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Customer customer = null;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Customer where Customer_id = ?";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();	
			if(rs.next()) { //Found user
				String firstName = rs.getString("Firstname");
				String lastName = rs.getString("Lastname");
				String createdOn = rs.getString("Created_on");
				customer = new Customer(id, firstName, lastName, createdOn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return customer;
	}
	
	public static List<Product> getMenu() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		List<Product> list = new ArrayList<>();
		
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Product";
			preparedStatement = connection.prepareStatement(selectSQL);
			ResultSet rs = preparedStatement.executeQuery();	
			while(rs.next()) {
				Product product = new Product(rs.getString("Product_code"), rs.getString("Name"), rs.getString("Price"), rs.getString("Description"));
//				System.out.println(product);
				list.add(product);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		return list;
	}
	
	public static boolean signup(String firstName, String lastName, String userName, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Identity where Username = ?";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, userName);
			ResultSet rs = preparedStatement.executeQuery();	
			if(!rs.next()) { //Username is unique
				String insertCustomer = "insert into Customer (Firstname, Lastname) values (\"" + firstName + "\",\"" + lastName + "\")";
				preparedStatement = connection.prepareStatement(insertCustomer);
				preparedStatement.executeUpdate();	
				
				String selectLastInsertId = "select last_insert_id()";
				preparedStatement = connection.prepareStatement(selectLastInsertId);
				ResultSet rs1 = preparedStatement.executeQuery();	
				int id = 0;
				if(rs1.next()) {
					System.out.println(id);
					id = rs1.getInt("last_insert_id()");
					System.out.println(id);
				}
				
				String insertIdentity = " insert into Identity (Username, Password, Customer_id) values (\"" + userName + "\", \"" + password +"\" , " + id + ")";
				preparedStatement = connection.prepareStatement(insertIdentity);	
//				preparedStatement.setString(1, userName);
//				preparedStatement.setString(2, password);
//				preparedStatement.setInt(3, id);	//No idea why this setString and setInt dont work
				preparedStatement.executeUpdate();	
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return true;
	}
	
	public static int getIdentity(String userName, String password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int customerId = 0;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Identity where Username = ? and Password = ?";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			ResultSet rs = preparedStatement.executeQuery();	
			while(rs.next()) { //Found user
				customerId = rs.getInt("Customer_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return customerId;
	}
	
	
	public static int getAdminId(int id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int adminId = 0;
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL = "select * from Admin where Customer_id = ?";
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();	
			if(rs.next()) { //Found admin
				adminId = rs.getInt("Admin_id");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return adminId;
	}

	public static int saveOrder(int id, List<CartProduct> cart, float total) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int orderId = 0;
		
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String insertSQL = "insert into OrderList(Customer_id, Date_order, Total, Status) values(?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, getCurrentDate());
			preparedStatement.setString(3, Float.toString(total));
			preparedStatement.setString(4, "ordered");
			preparedStatement.executeUpdate();	
			
			String selectLastInsertedOrderId = "select last_insert_id()";
			preparedStatement = connection.prepareStatement(selectLastInsertedOrderId);
			ResultSet rs = preparedStatement.executeQuery();	
			if(rs.next()) {
				orderId = rs.getInt("last_insert_id()");
			}
			
			
			String insertSQL1 = "insert into OrderDetail(Order_id, Product_code, Quantity) values ";
			for(CartProduct obj : cart) {
				insertSQL1 += "(" + orderId + ", \"" + obj.getProductCode() + "\", \" " + obj.getQuantity() + "\"),";
			}
			
			StringBuilder string = new StringBuilder(insertSQL1);
	        string.setCharAt(insertSQL1.length() - 1, ';');
			
	        preparedStatement = connection.prepareStatement(string.toString());
			preparedStatement.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return orderId;
	}
	
	public static OrderInfo getOrderInfo(int orderId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int customerId = 0;			//selectSQL1
		String dateOrdered = null;
		String total = null;
		String status = null;		
		
		List<Product> products = new ArrayList<>();	//selectSQL2
		
		try {
			DBConnectionLe.getDBConnection();
			connection = DBConnectionLe.connection;
			String selectSQL1 = "select * from OrderList where Order_id = ?";
			preparedStatement = connection.prepareStatement(selectSQL1);
			preparedStatement.setInt(1, orderId);
			ResultSet rs1 = preparedStatement.executeQuery();	
			if(rs1.next()) {		//Only one record cuz orderId is a PK
				customerId = rs1.getInt("Customer_id");
				dateOrdered = rs1.getString("Date_order");
				total = rs1.getString("Total");
				status = rs1.getString("Status");
			}
			
			String selectSQL2 = "select * from Product "
							  + "inner join OrderDetail on OrderDetail.Product_code = Product.Product_code "
							  + "where OrderDetail.Order_id = ?";
			preparedStatement = connection.prepareStatement(selectSQL2);
			preparedStatement.setInt(1, orderId);
			ResultSet rs2 = preparedStatement.executeQuery();
			while(rs2.next()) {
				String pcode = rs2.getString("Product_code");
				String name = rs2.getString("Name");
				String price = rs2.getString("Price");
				String desc = rs2.getString("Description");
				products.add(new Product(pcode, name, price, desc));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException se2) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		
		return new OrderInfo(orderId, customerId, dateOrdered, total, status, products);
	}
	
	public static String getCurrentDate() {
		LocalDateTime myDateObj = LocalDateTime.now();
	
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
	    return formattedDate;
	}
	

//	public static void insertTodo(String title, String done) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			DBConnectionLe.getDBConnection();
//			connection = DBConnectionLe.connection;
//			String insertSQL = "insert into Lists (title, done) values (\"" + title + "\",\"" + done + "\")";
//			System.out.println(insertSQL);
//			// or String insertSQL = "insert into Lists value(?, ?) ";
//			preparedStatement = connection.prepareStatement(insertSQL);
//			// preparedStatement.setString(1, title);
//			// preparedStatement.setString(2, title);
//			preparedStatement.executeUpdate();		
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null)
//					preparedStatement.close();
//			} catch (SQLException se2) {
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
	
//	public static void deleteTodo(String id) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			DBConnectionLe.getDBConnection();
//			connection = DBConnectionLe.connection;
//			String deleteSQL = "delete from Lists where id = ?";
//			System.out.println(deleteSQL);
//			preparedStatement = connection.prepareStatement(deleteSQL);
//			preparedStatement.setInt(1, Integer.parseInt(id));
//			preparedStatement.executeUpdate();		
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null)
//					preparedStatement.close();
//			} catch (SQLException se2) {
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
//	
//	public static void updateTodo(String id, String title) {
//		Connection connection = null;
//		PreparedStatement preparedStatement = null;
//		try {
//			DBConnectionLe.getDBConnection();
//			connection = DBConnectionLe.connection;
//			String updateSQL = "update Lists set title = ? where id = ? ";
////			System.out.println(deleteSQL);
//			preparedStatement = connection.prepareStatement(updateSQL);
//			preparedStatement.setString(1, title);
//			preparedStatement.setInt(2, Integer.parseInt(id));
//			preparedStatement.executeUpdate();		
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (preparedStatement != null)
//					preparedStatement.close();
//			} catch (SQLException se2) {
//			}
//			try {
//				if (connection != null)
//					connection.close();
//			} catch (SQLException se) {
//				se.printStackTrace();
//			}
//		}
//	}
}
