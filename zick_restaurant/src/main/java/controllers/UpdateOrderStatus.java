package controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.OrderInfo;
import util.DBUtil;

/**
 * Servlet implementation class UpdateOrderStatus
 */
@WebServlet("/UpdateOrderStatus")
public class UpdateOrderStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("status") != null) {
			String status = request.getParameter("status");
			int orderId = Integer.parseInt(request.getParameter("orderId"));
			DBUtil.updateOrderStatus(orderId, status);
			
			response.sendRedirect("ViewOrderStatus");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("Inside UpdateOrderStatus post request!!");
		int orderId = Integer.parseInt(request.getParameter("orderId")); 
		OrderInfo orderInfo = DBUtil.getOrderInfo(orderId);
		
		request.setAttribute("orderInfo", orderInfo);
		RequestDispatcher rd = request.getRequestDispatcher("updateOrderStatus.jsp");
		rd.forward(request, response);
	}

}
