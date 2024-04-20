package aspireClothing.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aspireClothing.dao.TimeClockDAO;

@WebServlet("/timeClock")
public class ClockPage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private TimeClockDAO timeClockDAO;
	
	@Override
	public void init() throws ServletException {
		super.init();
		timeClockDAO = new TimeClockDAO();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
			request.getRequestDispatcher("timeClock.jsp").forward(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String action = request.getParameter("action");

		HttpSession session = request.getSession();
		int employeeId = (int) session.getAttribute("employeeId");

		try {
			if (action != null && !action.isEmpty()) {
				if (action.equals("clockIn")) {
					timeClockDAO.clockIn(employeeId);
				} else if (action.equals("clockOut")) {
					timeClockDAO.clockOut(employeeId);
				}
			}

			String clockInTime = timeClockDAO.getClockInTime(employeeId);
			String clockOutTime = timeClockDAO.getClockOutTime(employeeId);

			request.setAttribute("employeeId", employeeId);
			request.setAttribute("clockInTime", clockInTime);
			request.setAttribute("clockOutTime", clockOutTime);

			request.getRequestDispatcher("timeClock.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
