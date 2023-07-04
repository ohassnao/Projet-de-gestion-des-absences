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
                    <a href="resetprof.jsp?username=<%=name%>"> Account </a>
                    <a href="#"> System </a>
                    <a href="#"> Departement</a>
                </div>
            </div>
            <div class="app-header-actions">
                <span>Pr.<%= name%></span>

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
                    <a href="add-courses.jsp?username=<%= name%>">
                        <i class="ph-browsers"></i>
                        <span>Dashboard</span>
                    </a>
                    <a href="#">
                        <i class="ph-check-square"></i>
                        <span>Emplois</span>
                    </a>
                    <a href="#">
                        <i class="ph-swap"></i>
                        <span>Etudiants</span>
                    </a>
                    <a href="#">
                        <i class="ph-file-text"></i>
                        <span>Doctorants</span>
                    </a>
                    <a href="#">
                        <i class="ph-globe"></i>
                        <span>Exams</span>
                    </a>
                    <a href="index.jsp">
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
                <section class="service-section">
                    <h2>ENSAKH Dashboard</h2>
                    <div class="service-section-header">
                        <div class="search-field">
                            <i class="ph-magnifying-glass"></i>
                            <input type="text" placeholder="Account number" style="color:whitesmoke"/>
                        </div>
                        <div class="dropdown-field">
                            <select>
                                <option>Home</option>
                                <option>Work</option>
                            </select>
                            <i class="ph-caret-down"></i>
                        </div>
                        <button class="flat-button">Search</button>
                    </div>
                    <div class="mobile-only">
                        <button class="flat-button">Toggle search</button>
                    </div>
                </section>

                <section class="transfer-section">
                    <div class="transfer-section-header">
                        <h2>My Courses</h2>
                        <div class="filter-options">
                            <p>ENSA KHOURIBGA</p>
                        </div>
                    </div>
					<div class="transfers">
					    <% 
					    PreparedStatement pstmt1 = conn.prepareStatement("SELECT id_enseignant FROM enseignants WHERE nom_ens = ? LIMIT 1");
					    pstmt1.setString(1, name);
					    ResultSet rs2 = pstmt1.executeQuery();
					    int ensID = 0;
					    if (rs2.next()) {
					        ensID = rs2.getInt("id_enseignant");
					    }
					        
					    PreparedStatement stmtModules = conn.prepareStatement("SELECT * FROM module WHERE id_ens = ?");
					    stmtModules.setInt(1, ensID);
					    ResultSet resModules = stmtModules.executeQuery();
					    
					    while (resModules.next()) {
					        String intitule = resModules.getString("intitulé");
					        String description = resModules.getString("description");
					        String abv = resModules.getString("abreveation");
					        
					        PreparedStatement stmt1 = conn.prepareStatement("SELECT COUNT(*) FROM etudiants JOIN posseder ON posseder.id_etd = etudiants.id_etd JOIN module ON module.id_module = posseder.id_module WHERE module.intitulé = ?");
					        stmt1.setString(1, intitule);
					        ResultSet liste = stmt1.executeQuery();
					        int count = 0;
					        if (liste.next()) { 
					            count = liste.getInt(1);
					        }
							%>
							    <div class="transfer">
							        <dl class="transfer-details">
							            <div>
							            	<dt><a href="./generate_Infos.jsp?course_name=<%= intitule %>&username=<%= name%>"><%= intitule %></a></dt>
							                <dd>Nom Module</dd>
							            </div>
							            <div>
							                <dt><%= abv %></dt>
							                <dd>Abreveation</dd>
							            </div>
							            <div>
							                <dt><%= description %></dt>
							                <dd>Description</dd>
							            </div>
							            <div>
							                <dt><%= count %></dt>
							                <dd>Nbr Etudiant</dd>
							            </div>
							        </dl>
							    </div>
							<% 
							    }
							%>

					</div>


                </section>
                </div>
				<div class=" app-body-sidebar">
                <section class="payment-section">
                    <form method="post">
                        <div class="faq">
                            <p>You can add courses here!</p>
                            <div>
                                <label for="name">Course</label>
                                <input type="text" placeholder="Type here" name="name" autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
                            <div>
                                <label for="department">Departement</label>
                                <input type="text" placeholder="Type here" name="department" required autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
                        </div>
                        <div class="payment-section-footer">
                            <button class="save-button" name="submit">Save</button>
                            <button class="settings-button">
                                <i class="ph-gear"></i>
                                <span>More settings</span>
                            </button>
                        </div>
                    </form>

                </section>
            </div>
            </div>
        </div>

    <!-- partial -->

    <script src="https://unpkg.com/phosphor-icons"></script>
    <script src="./scriptDashboard.js"></script>
</body>

</html>