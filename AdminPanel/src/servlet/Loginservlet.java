package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import dao.Executivedao;
import userbean.Userbean;


@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

	/*	String name = request.getParameter("name");
		String domain=request.getParameter("domain");
		String EmpId = request.getParameter("empid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		String emailid = request.getParameter("emailid");
		String webmail=request.getParameter("webmail");
		String mobile = request.getParameter("mobile");
		String designation=request.getParameter("designation");*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Userbean user=new Userbean();
	
			if ((username != null) && (password != null)) {
				user.setUsername(username);
				user.setPassword(password);
				Executivedao.insert(user);
				Boolean status = user.isValid();
				// System.out.println("adminstatus:::"+adminstatus);
				if (status) {
					HttpSession session = request.getSession(true);
					session.setAttribute("Admin", user);
					response.sendRedirect("EmployeeDetails.jsp");
				} else {
					response.sendRedirect("LoginFailure.jsp");
				}


		}
	}
}
