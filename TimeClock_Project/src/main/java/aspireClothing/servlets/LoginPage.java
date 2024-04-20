package aspireClothing.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aspireClothing.dao.StoreDAO;

import java.sql.SQLException;

@WebServlet("/login")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreDAO storeDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		storeDAO = new StoreDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int storeNumber = Integer.parseInt(request.getParameter("storeNumber"));
		String storePassword = request.getParameter("storePassword");

		try {
			if (isValidCredentials(storeNumber, storePassword)) {

				HttpSession session = request.getSession();
				session.setAttribute("storeNumber", storeNumber);
				response.sendRedirect("employeeList");
			} else {
				request.setAttribute("error", "Invalid credentials");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | IOException | ServletException | SQLException e) {

			e.printStackTrace();
		}

	}

	private boolean isValidCredentials(int storeNumber, String storePassword)
			throws ClassNotFoundException, SQLException {
		return storeDAO.validateStoreCredentials(storeNumber, storePassword);
	}

}
