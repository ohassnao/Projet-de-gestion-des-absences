package oussama;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Loginadminservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get parameters from request
        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        // Get database connection
        

        try {
            // Prepare SQL query
        	Connection connection = database.getInstance().getConnection();
            String query = "SELECT a.nom_admin FROM compte c INNER JOIN admin a ON c.id_compte = a.id_compte WHERE c.login = ? AND c.pwd = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            // Execute query
            //String query2 = "Select nom_admin From compte , admin where compte.id_compte = admin.id_compteSELECT a.nom_admin FROM compte c INNER JOIN admin a ON c.id_compte = a.id_compte WHERE c.login = ? AND c.pwd = ?";
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Login successful
                String adminNom = resultSet.getString("nom_admin");
            	response.sendRedirect("Admin.jsp?username=" + adminNom);
            } else {
                // Login failed
                request.setAttribute("errorMessage", "Login or password is wrong. Please try again.");
                request.getRequestDispatcher("loginadmin.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            // Handle SQL exception
            out.println("<h2>SQL exception:</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        } finally {
            // Close database connection
            try {
            	Connection connection = database.getInstance().getConnection();
                connection.close();
            } catch (SQLException e) {
                // Ignore exception
            }
        }

        out.close();
    }
}
