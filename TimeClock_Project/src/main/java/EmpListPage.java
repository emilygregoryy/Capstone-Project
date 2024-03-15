

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmployeeList")
public class EmpListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StoreDB storeDB;
	
	@Override
	public void init() throws ServletException {
		super.init();
		storeDB = new StoreDB();
	}
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String storeId = (String) session.getAttribute("storeId");
		
		List<Employee> employeeList = storeDB.getEmployeeList(storeId);
		
		request.setAttribute("employeeList", employeeList);
		request.getRequestDispatcher("EmpListPage.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
