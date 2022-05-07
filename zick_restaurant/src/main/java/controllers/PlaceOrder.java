package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartProduct;
import util.DBUtil;

/**
 * Servlet implementation class PlaceOrder
 */
@WebServlet("/PlaceOrder")
public class PlaceOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		System.out.println("\nInside the PlaceOrder doGet");
		int id = (int) session.getAttribute("customerId");
		/*
		 * if (session.getAttribute("customerId") != null && (int)
		 * session.getAttribute("customerId") != 0) { id = (int)
		 * session.getAttribute("customerId"); }else { id = (int)
		 * session.getAttribute("adminId"); }
		 */
		System.out.println("id of customer is : " + id);
		System.out.println();
		
		if (session.getAttribute("cart") != null) {
			System.out.println("Cart is not null");
			List<CartProduct> cart = (List<CartProduct>) session.getAttribute("cart");
			session.removeAttribute("cart");		//In case the user refreshes the page! So there is no reorder same thing
			float total = (float) session.getAttribute("total");
			/*
			 * for (CartProduct obj : cart) { System.out.println(obj.getName()); }
			 */
			
			int orderId = DBUtil.saveOrder(id, cart, total);
			
			session.setAttribute("orderId", orderId);
			request.setAttribute("orderId", orderId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewOrderStatus");
			dispatcher.forward(request, response);
		}else {
			System.out.println("Cart is null");
			request.setAttribute("orderId", session.getAttribute("orderId"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewOrderStatus");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		List<CartProduct> cart = (List<CartProduct>) request.getAttribute("cart");
		
		for (CartProduct obj : cart) {
			System.out.println(obj.getName());
		}
	}

}
