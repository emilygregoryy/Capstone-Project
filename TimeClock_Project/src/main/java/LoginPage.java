

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@WebServlet("/login")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeId = request.getParameter("storeId");
		String password = request.getParameter("password");
		
		if (isValidCredentials(storeId, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("storeId", storeId);
			response.sendRedirect("EmpListPage.jsp");
		} else {
			request.setAttribute("error", "Invalid credentials");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	private boolean isValidCredentials(String storeId, String password) {
		return "user".equals(storeId) && "password".equals(password);
	}

}
