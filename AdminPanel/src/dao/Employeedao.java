package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import userbean.Userbean;

public class Employeedao {

	public static void insert(Userbean user) {

		try {
			ConnectionSteps steps = new ConnectionSteps();
			Connection conn=steps.connection();
			PreparedStatement pstmt = conn.prepareStatement("insert into registration(name,empid,domain,username,password,confirmpassword,emailid,webmail,mobile,designation,sno) values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmpid());
			pstmt.setString(3,user.getDomain());
			pstmt.setString(4,user.getUsername());
			pstmt.setString(5,user.getPassword());
			pstmt.setString(6,user.getConfirmpassword());
			pstmt.setString(7,user.getEmailid());
			pstmt.setString(8,user.getWebmail());
			pstmt.setLong(9,user.getMobile());
			pstmt.setString(10,user.getDesignation());
			pstmt.setInt(11, user.getSno());
			int n =pstmt.executeUpdate();
			if(n==1)
			{
				System.out.println("success");
				user.setValid(true);


			}
			else
			{
				System.out.println("not success");
				user.setValid(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}



	}

}
