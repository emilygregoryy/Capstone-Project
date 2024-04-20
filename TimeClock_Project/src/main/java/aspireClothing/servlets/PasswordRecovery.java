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

/**
 * Servlet implementation class passwordRecovery
 */
@WebServlet("/recoverPassword")
public class PasswordRecovery extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userDAO = new UserDAO();
	}
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String managerPassword = request.getParameter("managerPassword");
		
		try {
			if (userDAO.validateEmployeesManager(employeeId, managerPassword)) {
				HttpSession session = request.getSession();
				session.setAttribute("employeeId", employeeId);
				request.getRequestDispatcher("passwordReset.jsp").forward(request, response);
			} else {
			System.out.println("error: invalid employee ID or manager password");
			response.sendRedirect("recoverPassword.jsp");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
