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
	String module_name = request.getParameter("module_name");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	PreparedStatement stmt = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé = ?");
	stmt.setString(1, module_name);
	ResultSet res = stmt.executeQuery();
	int id_module = 0; 
	if(res.next())
	{
		id_module = res.getInt(1);
	}
	
	PreparedStatement pstmt4 = conn.prepareStatement("DELETE FROM  absence WHERE id_module = ?");
    pstmt4.setInt(1, id_module);
    pstmt4.executeUpdate();
    
    PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM posseder WHERE id_module = ?");
    pstmt3.setInt(1, id_module);
    pstmt3.executeUpdate();
    
    PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM Module WHERE id_module = ?");
    pstmt2.setInt(1, id_module);
    pstmt2.executeUpdate();
    

    response.sendRedirect("modules.jsp");


%>


</body>
</html>