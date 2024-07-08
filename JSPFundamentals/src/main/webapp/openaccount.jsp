<%@ page import = "java.sql.*" 
language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
Connection con;
PreparedStatement ps;
%>
<%
int accno=Integer.parseInt(request.getParameter("accno")); 
String lastname=request.getParameter("lastname");
String firstname=request.getParameter("firstname");
int bal=Integer.parseInt(request.getParameter("bal"));

try{
	Class.forName("com.mysql.jdbc.Driver");			
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC", "root", "password@123"); 		
	ps=con.prepareStatement("insert into account(accno,lastname,firstname,bal)values(?,?,?,?)");
	
	ps.setInt(1, accno);
	ps.setString(2, lastname);
	ps.setString(3, firstname);
	ps.setInt(4, bal);

	int res=ps.executeUpdate();
	if(res==0) {
		out.println("Record not Stored into Database ");
	}else {
		out.println("Record Stored into Database ");
	}

}
catch(Exception e)
{
	e.printStackTrace();
}



%>