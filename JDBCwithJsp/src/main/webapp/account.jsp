<%@ page import ="java.sql.*" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%!
    	Connection con;
    	PreparedStatement ps;
    %>
<%
	int accno =Integer.parseInt(request.getParameter("accno"));
	String lastname=request.getParameter("lastname");
	String firstname=request.getParameter("firstname");
	int bal =Integer.parseInt(request.getParameter("bal"));
try{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?useTimezone=true&serverTimezone=UTC","root","password@123");
	ps=con.prepareStatement("insert into account1(accno,lastname,firstname,bal)values(?,?,?,?)");
	ps.setInt(1,accno);
	ps.setString(2,lastname);
	ps.setString(3,firstname);
	ps.setInt(4,bal);
	int x = ps.executeUpdate();
	if (x==0)
	{
		out.println("Error encountered !!!");
	}else{
		out.println("Values successfully stored in the Database !!!");
	}
}catch(Exception e){
	e.printStackTrace();
}
%>