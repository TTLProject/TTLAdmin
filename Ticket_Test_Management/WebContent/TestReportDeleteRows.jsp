	
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setDateHeader("Expires", 0);
	response.setHeader("Pragma", "no-cache");
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	String[] id = request.getParameterValues("test");
	
	
	%>

	<%
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ttm", "ttm");

			for (int a = 0; a < id.length; a++) {

				PreparedStatement pstmt = conn.prepareStatement("DELETE  FROM testreporttable where testcaseid=?");
				pstmt.setString(1, id[a]);
				System.out.println(id[a]);
				int n = pstmt.executeUpdate();
				if(n>0){
					System.out.println("success");
					
				}else{
					System.out.println("failed");
				}
			}
		
        	  response.sendRedirect("TestReport.jsp");
       

		} catch (Exception e) {
			System.out.println(e);
		}
	%>
	
	
	
	
</body>
</html>