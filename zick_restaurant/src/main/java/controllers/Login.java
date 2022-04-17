package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DBUtil;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		System.out.println("inside the post request Login servlet");
		
		int id = DBUtil.getIdentity(request.getParameter("username"), request.getParameter("password"));
		//id = 0 => person does not exit
		//otherwise, person is either customer or admin
		System.out.println(id);
		
		if(id == 0) {
			request.setAttribute("message", "Customer does not exist!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}else {
			int adminId = DBUtil.getAdminId(id);
			if(adminId == 0) { //not an admin
				HttpSession session = request.getSession();
				session.setAttribute("customerId", id);
				response.sendRedirect("home.jsp");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("customerId", id);
				session.setAttribute("adminId", adminId);
				response.sendRedirect("home.jsp");
			}
		}
	}

}
