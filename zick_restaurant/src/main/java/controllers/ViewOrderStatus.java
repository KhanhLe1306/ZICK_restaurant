package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.OrderInfo;
import util.DBUtil;

/**
 * Servlet implementation class ViewOrderStatus
 */
@WebServlet("/ViewOrderStatus")
public class ViewOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrderStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		int orderId = (int) request.getAttribute("orderId");
		
		if(session.getAttribute("adminId") != null) {			//admin
			
		}else if (session.getAttribute("customerId") != null) {	//customer
			
			// get order 
			OrderInfo orderInfo = DBUtil.getOrderInfo(orderId);
			
			System.out.println(orderInfo);
			
			request.setAttribute("orderInfo", orderInfo);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/viewOrderStatus.jsp");
			dispatcher.forward(request, response);
			
		}else {
			response.sendRedirect("home.jsp");					//the person is not logged in 
		}
		
		// If admin then show all orders with "ordered" and "in progress" status
		
		
		// else (customer) then show only their order
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
