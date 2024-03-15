

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
	private StoreDB storeDB;
	
	@Override
	public void init() throws ServletException {
		super.init();
		storeDB = new StoreDB();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeNumber = request.getParameter("storeNumber");
		String password = request.getParameter("password");
		
		if (isValidCredentials(storeNumber, password)) {
			
			HttpSession session = request.getSession();
			session.setAttribute("storeId", storeNumber);
			response.sendRedirect("EmpListPage.jsp");
		} else {
			request.setAttribute("error", "Invalid credentials");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}
	
	private boolean isValidCredentials(String storeNumber, String password) {
		return storeDB.validateStoreCredentials(storeNumber, password);
	}

}
