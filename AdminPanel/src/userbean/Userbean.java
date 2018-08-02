package userbean;

public class Userbean {
	private String username,empid,password,name,domain,confirmpassword,emailid,webmail,designation;
	
	long mobile;
	int sno;
	boolean isValid;
	
	
	
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getWebmail() {
		return webmail;
	}
	public void setWebmail(String webmail) {
		this.webmail = webmail;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}


	public static Object getStartls() {
		// TODO Auto-generated method stub
		return null;
	}
	public static Object getHost() {
		// TODO Auto-generated method stub
		return null;
	}
	public static Object getPort() {
		// TODO Auto-generated method stub
		return null;
	}
	public static Object getAuth() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
