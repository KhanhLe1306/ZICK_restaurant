package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.CartProduct;
import models.Product;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cart() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		List<CartProduct> cart = new ArrayList<>();
		HttpSession session = request.getSession();
	
			
			Enumeration paramNames = request.getParameterNames();	// get all "name" parameters
			while(paramNames.hasMoreElements()) {
				String productCode = (String)paramNames.nextElement(); //1st 4th 7th ... will be product code
				if (!request.getParameter(productCode + "_quantity").equalsIgnoreCase("0")) {
					System.out.println("Product code: " + productCode);
					System.out.println("Product name: " +request.getParameter(productCode + "_name"));
					System.out.println("Price: " +request.getParameter(productCode+ "_price"));
					System.out.println("Quantity: "+request.getParameter(productCode + "_quantity")); // use the product code with _quantity to get the quantity.
					System.out.println("Product description: " +request.getParameter(productCode + "_description"));
					cart.add(new CartProduct(productCode,request.getParameter(productCode + "_name"), request.getParameter(productCode+ "_price"),request.getParameter(productCode + "_description"), request.getParameter(productCode + "_quantity")  ));
				}
				paramNames.nextElement();
				paramNames.nextElement();
				paramNames.nextElement();
				paramNames.nextElement();
				System.out.println();
			}
			session.setAttribute("cart", cart);
			/*
			 * request.setAttribute("cart", cart); RequestDispatcher rd =
			 * request.getRequestDispatcher("cart.jsp"); rd.forward(request, response);
			 */
			
			response.sendRedirect("cart.jsp");
			
			//Store cart information inside session
			
			//Pop and display them when user goes to cart.jsp
			
			//Remove attribute when user places order and redirect to Progress page?
	
	}

}
