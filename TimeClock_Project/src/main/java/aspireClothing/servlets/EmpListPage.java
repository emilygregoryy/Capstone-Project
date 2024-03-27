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

import aspireClothing.Employee;
import aspireClothing.dao.StoreDB;

@WebServlet("/employeeList")
public class EmpListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreDB storeDB;

	@Override
	public void init() throws ServletException {
		super.init();
		storeDB = new StoreDB();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String storeId = (String) session.getAttribute("storeNumber");

		List<Employee> employeeList = storeDB.getEmployeeList(storeId);

		request.setAttribute("employeeList", employeeList);
		request.getRequestDispatcher("EmpListPage.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String emPassword = request.getParameter("employeePassword");

		HttpSession session = request.getSession();
		session.setAttribute("employeeId", employeeId);

		try {
			if (storeDB.validateEmployeeCredentials(employeeId, emPassword)) {
				request.getRequestDispatcher("timeClock.jsp").forward(request, response);
			} else {
				response.sendRedirect("EmpListPage.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

