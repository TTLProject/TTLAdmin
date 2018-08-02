package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Employeedao;
import dao.Executivedao;
import userbean.Userbean;

@WebServlet("/Registerservlet")
public class Registerservlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Userbean user=new Userbean();
		String name = request.getParameter("name");
		String domain=request.getParameter("domain");
		String empid = request.getParameter("empid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirmpassword=request.getParameter("confirmpassword");
		String emailid = request.getParameter("emailid");
		String webmail=request.getParameter("webmail");
		long mobile = Long.parseLong(request.getParameter("mobile"));
		String designation=request.getParameter("designation");
		user.setName(name);
		user.setDomain(domain);
		user.setEmpid(empid);
		user.setUsername(username);
		user.setPassword(password);
		user.setConfirmpassword(confirmpassword);
		user.setEmailid(emailid);
		user.setWebmail(webmail);
		user.setMobile(mobile);
		user.setDesignation(designation);
		
		Employeedao.insert(user);
		Boolean status = user.isValid();
		// System.out.println("adminstatus:::"+adminstatus);
		if (status) {
			HttpSession session = request.getSession(true);
			session.setAttribute("registration", user);
			response.sendRedirect("EmployeeDetails.jsp");
		} else {
			response.sendRedirect("registration.jsp");
		}
		
		
	}
}