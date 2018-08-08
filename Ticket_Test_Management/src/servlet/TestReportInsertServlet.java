 	package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import userbean.Userbean;



@WebServlet("/TestReportInsertServlet")
public class TestReportInsertServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String testcaseid[]=request.getParameterValues("testcaseid[]");
		String testdescription[]=request.getParameterValues("testdescription[]");
		String precondition[]=request.getParameterValues("precondition[]");
		String testdesign[]=request.getParameterValues("testdesign[]");
		String expectedresult[]=request.getParameterValues("expectedresult[]");
		/*String actualresult[]=request.getParameterValues("actualresult[]");
		String status[]=request.getParameterValues("status[]");
		String comment[]=request.getParameterValues("comment[]");*/
		HttpSession session= request.getSession(false);
		Userbean user= (Userbean) session.getAttribute("session1");
		
	try {
		for(int i=0;i<=testcaseid.length-1;i++)
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ttm", "ttm");
			PreparedStatement pstmt = conn.prepareStatement("insert into testreporttable(testcaseid,testdescription,precondition,testdesign,expectedresult,projectname,requirementname,modulename) values(?,?,?,?,?,?,?,?)");
			pstmt.setString(1, testcaseid[i]); 
			pstmt.setString(2, testdescription[i]);
			pstmt.setString(3, precondition[i]); 
			pstmt.setString(4, testdesign[i]);
			pstmt.setString(5, expectedresult[i]); 
		/*	pstmt.setString(6, actualresult[i]);
			pstmt.setString(7, status[i]); 
			pstmt.setString(8, comment[i]);*/
			pstmt.setString(6, user.getProjectName());
			pstmt.setString(7, user.getRequirementName());
			pstmt.setString(8, user.getModuleName());
			int n =pstmt.executeUpdate();
			if(n>0) {
				
				System.out.println("success");
			}
			else {
				
				System.out.println("fails");
			}
	
		
		
		
		
		}
	}catch (Exception e) {
System.out.println(e);
	}
		
	   
		
		
		
		
	}

}
