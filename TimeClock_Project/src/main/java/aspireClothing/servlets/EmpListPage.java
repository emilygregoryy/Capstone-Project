package aspireClothing.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aspireClothing.beans.User;
import aspireClothing.dao.StoreDAO;

@WebServlet("/employeeList")
public class EmpListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreDAO storeDAO;

	@Override
	public void init() throws ServletException {
		super.init();
		storeDAO = new StoreDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int storeNumber = (int) session.getAttribute("storeNumber");
		
		List<User> employeeList;
		try {
			employeeList = storeDAO.getEmployeeList(storeNumber);
			request.setAttribute("employeeList", employeeList);
			request.getRequestDispatcher("employeeList.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String emPassword = request.getParameter("employeePassword");

		HttpSession session = request.getSession();
		session.setAttribute("employeeId", employeeId);

		try {
			if (storeDAO.validateEmployeeCredentials(employeeId, emPassword)) {
				request.getRequestDispatcher("timeClock.jsp").forward(request, response);
			} else {
				response.sendRedirect("employeeList.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

