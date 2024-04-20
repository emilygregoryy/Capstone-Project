package aspireClothing.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aspireClothing.dao.UserDAO;

@WebServlet("/passwordReset")
public class PasswordReset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = new UserDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int employeeId = (int) session.getAttribute("employeeId");
		String password = request.getParameter("newPassword");		
		try {
			userDAO.updatePassword(employeeId, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("login.jsp");
			
	}
}
