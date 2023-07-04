<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.sql.*, java.util.ArrayList" %>

<%-- Connect to the database --%> 

<%
Connection conn = null; 
try {
    Class.forName("com.mysql.jdbc.Driver"); 
    conn =
    DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase", "root", "");
} 
catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); } %> 
<%
    String actual_name = (String) session.getAttribute("NAME");
    String course_name = request.getParameter("course_name"); 
    String name = request.getParameter("username");
%>




<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dashboard Professor</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" />
    <link rel="stylesheet" href="./css/style.css" />
    <style>
        a {
            text-decoration: none;
            /* no underline */
        }
    </style>
</head>
<body>
    <!-- partial:index.partial.html -->
    <div class="app">
        <header class="app-header">
            <div class="app-header-logo">
                <div class="logo">
                    <span class="logo-icon">
                        <img src="./images/metamask-logo-white.png" />
                    </span>
                    <h1 class="logo-title">
                        <span>Metamask</span>
                        <span>Management</span>
                    </h1>
                </div>
            </div>
            <div class="app-header-navigation">
                <div class="tabs">
                    <a href="#"> Personal </a>
                    <a href="#" class="active"> Overview</a>
                    <a href="#"> Account </a>
                    <a href="#"> System </a>
                    <a href="#"> Departement</a>
                </div>
            </div>
            <div class="app-header-actions">
                <span>Pr. <%=name %></span>

                <div class="app-header-actions-buttons">
                    <button class="icon-button large">
                        <i class="ph-magnifying-glass"></i>
                    </button>
                    <button class="icon-button large">
                        <i class="ph-bell"></i>
                    </button>
                </div>
            </div>
            <div class="app-header-mobile">
                <button class="icon-button large">
                    <i class="ph-list"></i>
                </button>
            </div>
        </header>
        <div class="app-body">
            <div class="app-body-navigation">
                <nav class="navigation">
                    <a href="./Admin.jsp">
                        <i class="ph-browsers"></i>
                        <span>Dashboard</span>
                    </a>
                    <a href="./modules.jsp">
                        <i class="ph-check-square"></i>
                        <span>Modules</span>
                    </a>
                    <a href="#">
                        <i class="ph-swap"></i>
                        <span>Reunions</span>
                    </a>
                    <a href="#">
                        <i class="ph-file-text"></i>
                        <span>Doctorants</span>
                    </a>
                    <a href="#">
                        <i class="ph-globe"></i>
                        <span>Exams</span>
                    </a>
                    <a href="./index.jsp">
                        <i class="ph-clipboard-text"></i>
                        <span>Home</span>
                    </a>
                </nav>
                <footer class="footer">
                    <h1>Metamask<small>©</small></h1>
                    <div>
                        Metamsk ©<br />
                        Academic Web Project 2023
                    </div>
                </footer>
            </div>
            <div class="app-body-main-content">


               <section class="transfer-section">
                    <div class="transfer-section-header">
                        <h2>Reset Code</h2>
                        <div class="filter-options">
                            <p>ENSA KHOURIBGA</p>
                        </div>
                    </div>
					<div class="transfers">
						<p>You can Reset your password!</p>
                    <form method="post" action="" class="faq">
					    <div>
					        <label for="login">Old Password</label>
					        <input type="password" id="passwo" name="oldpassword" placeholder="Old Password" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="password">New Password:</label>
					        <input type="password" id="password" name="newpassword" placeholder="New Password" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="password">Confirm Password</label>
					        <input type="password" id="password" name="confirmpassword" placeholder="Confirm Password" style="color:whitesmoke;">
					    </div>
					    <input type="submit" class="save-button" value="Reset Password">
					</form>
					<%
String oldPassword = request.getParameter("oldpassword");
String newPassword = request.getParameter("newpassword");
String confirmPassword = request.getParameter("confirmpassword");

// Check if the new password and confirm password match
if (newPassword != null && newPassword.equals(confirmPassword)   ) {
    try {
        // Connect to the database
        // Prepare the update statement
        String updateQuery = "UPDATE compte SET pwd = ? WHERE pwd = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(updateQuery);
        preparedStatement.setString(1, newPassword);
        preparedStatement.setString(2, oldPassword);

        // Execute the update statement
        int rowsAffected = preparedStatement.executeUpdate();

        // Close the connection and prepared statement
        preparedStatement.close();
        conn.close();

        if (rowsAffected > 0) {
            // Password reset successful
            out.println("<h3>Password reset successfully!</h3>");
        } else {
            // Old password incorrect
            out.println("<h3>Old password is incorrect!</h3>");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        out.println("<h3>Error</h3>" + ex);
    }
} else {
    // New password and confirm password do not match
    out.println("<h3>New password and confirm password do not match!</h3>");
}
%>

					</div>
                </div>
            </div>
            </div>
        </div>

    <!-- partial -->

    <script src="https://unpkg.com/phosphor-icons"></script>
    <script src="./scriptDashboard.js"></script>
</body>

</html>