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
    String etd_name = request.getParameter("nom");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM etudiants WHERE nom = ?");
    stmt.setString(1, etd_name);
    ResultSet res = stmt.executeQuery();
    int id_etd = 0, id_Insc=0; 
    if(res.next())
    {
        id_etd = res.getInt(1);
        id_Insc = res.getInt("id_ins");
        
    } 

    
    PreparedStatement pstmt0 = conn.prepareStatement("DELETE FROM posseder WHERE id_etd = ?");
    pstmt0.setInt(1, id_etd);
    pstmt0.executeUpdate();
    
    PreparedStatement pstmt2 = conn.prepareStatement("DELETE FROM absence WHERE id_etd = ?");
    pstmt2.setInt(1, id_Insc);
    pstmt2.executeUpdate();    
   
    PreparedStatement pstmt3 = conn.prepareStatement("DELETE FROM etudiants WHERE id_etd = ?");
    pstmt3.setInt(1, id_etd);
    pstmt3.executeUpdate();




    response.sendRedirect("Admin.jsp");
%>


</body>
</html>