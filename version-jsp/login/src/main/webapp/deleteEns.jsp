<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.*, java.util.ArrayList" %>


<%
Connection conn = null; 
try {
    Class.forName("com.mysql.jdbc.Driver"); 
    conn =
    DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase", "root", "");
} 
catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); } %> 
    
<%
	String ens_name = request.getParameter("ens_name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	PreparedStatement stmt = conn.prepareStatement("SELECT id_enseignant FROM enseignants WHERE nom_ens = ?");
	stmt.setString(1, ens_name);
	ResultSet res = stmt.executeQuery();
	int id_ENS = 0; 
	if(res.next())
	{
		id_ENS = res.getInt(1);
	}
	
    
    PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM Module WHERE id_ens = ?");
    pstmt2.setInt(1, id_ENS);
    pstmt2.executeUpdate();
    
    PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM enseignants WHERE id_enseignant = ?");
    pstmt3.setInt(1, id_ENS);
    pstmt3.executeUpdate();
    response.sendRedirect("Admin.jsp");


%>


</body>
</html>