package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				String insertIdentity = "insert into Identity (Username, Password) values (\"" + userName + "\",\"" + password + "\")";
				preparedStatement = connection.prepareStatement(insertCustomer);
				preparedStatement.executeUpdate();	
				preparedStatement = connection.prepareStatement(insertIdentity);
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
