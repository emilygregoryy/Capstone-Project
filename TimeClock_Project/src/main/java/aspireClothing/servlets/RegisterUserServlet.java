package aspireClothing.servlets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aspireClothing.beans.User;
import aspireClothing.dao.RegisterDAO;


@WebServlet("/registerUser")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int employeeId = Integer.parseInt(req.getParameter("employeeId"));
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String jobTitle = req.getParameter("jobTitle");
		String emPassword = req.getParameter("emPassword");
		int storeNumber = Integer.parseInt(req.getParameter("storeNumber"));
		String phoneNumber = req.getParameter("phoneNumber");
		
		User employee = new User(employeeId, firstName, lastName, jobTitle, emPassword, storeNumber, phoneNumber);
		
		RegisterDAO dao = new RegisterDAO();
		boolean registrationStatus = dao.registerUser(employee);
		
		String infoMessage = registrationStatus ? "User registered successfully!" : "Sorry, an error occured!";

		String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), infoMessage);
		resp.getWriter().write(page);
	}
	
	public String getHTMLString(String filePath, String message) throws IOException{
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		
		StringBuffer buffer = new StringBuffer();
		String line;
		while((line=reader.readLine())!=null){
			buffer.append(line);
		}
		
		String page = buffer.toString();
		return MessageFormat.format(page, message);	
		
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = getHTMLString(req.getServletContext().getRealPath("/html/register.html"), "");
		resp.getWriter().write(page);
	}
}
