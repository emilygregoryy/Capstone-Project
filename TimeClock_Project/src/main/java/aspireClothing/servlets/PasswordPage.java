package aspireClothing.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aspireClothing.beans.User;
import aspireClothing.dao.UserDAO;

@WebServlet("/passwordSettings")
public class PasswordPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private User employee;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = new UserDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int employeeId = (int) session.getAttribute("employeeId");
		
		try {
			employee = userDAO.getUserById(employeeId);
			request.setAttribute("employeeId", employee.getEmployeeId());
			request.getRequestDispatcher("passwordSettings.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String emPassword = request.getParameter("newPassword");		
		try {
			userDAO.updatePassword(employeeId, emPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("passwordSettings");
			
	}
}
