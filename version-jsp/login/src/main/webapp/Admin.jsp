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
                    <a href="reset.jsp?username=<%=name%>"> Account </a>
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
                    <a href="./Admin.jsp?username=<%=name%>">
                        <i class="ph-browsers"></i>
                        <span>Dashboard</span>
                    </a>
                    <a href="./modules.jsp?username=<%=name%>">
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
                <section class="service-section">
                    <h2>ENSAKH Professors Dashboard</h2>
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
                        <h2>Establishment Professors</h2>
                        <div class="filter-options">
                            <p>ENSA KHOURIBGA</p>
                        </div>
                    </div>
					<div class="transfers">
					    <% 
						    PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM enseignants");
						    ResultSet rs2 = pstmt1.executeQuery();
						        
						    
						    while (rs2.next()) {
						        String nom = rs2.getString("nom_ens");
						        String prenom = rs2.getString("prenom_ens");
						        String email = rs2.getString("mail_ens");
						        String fonction = rs2.getString("fonction");
						        String etat = rs2.getString("etat");
							%>
							    <div class="transfer">
							        <dl class="transfer-details">
							            <div>
							            	<dt><%= nom %></dt>
							                <dd>Nom</dd>
							            </div>
							            <div>
							                <dt><%= prenom %></dt>
							                <dd>Prenom</dd>
							            </div>
							            <div>
							                <dt><%= fonction %></dt>
							                <dd>Fonction</dd>
							            </div>
							            <div>
							                <dt><%= etat %></dt>
							                <dd>Etat</dd>
							            </div>
										<div style="margin-left:30px;">
											<dt style="display:flex;height:50%;">
											  <a href="update.jsp?ens_name=<%=nom%>" style="display:inline-block;margin-right:10px;">
											    <img src="update_icon.png" alt="Update icon" width="50%">
											  </a>
												<a id="alerto" href="deleteEns.jsp?ens_name=<%=nom%>" style="display:inline-block;">
												  <img src="delete_icon.png" alt="Delete icon" width="50%">
												</a>
												


											</dt>
											
										</div>

							        </dl>
							    </div>
							<% 
							    }
							%>

					</div>


                </section>      
                

                <section class="transfer-section">
                    <div class="transfer-section-header">
                        <h2>Establishment Student</h2>
                        <div class="filter-options">
                            <p>ENSA KHOURIBGA</p>
                        </div>
                    </div>
					<div class="transfers">
					    <% 
						    PreparedStatement pstmt2 = conn.prepareStatement("SELECT * FROM etudiants");
						    ResultSet rs3 = pstmt2.executeQuery();
						        
						    
						    while (rs3.next()) {
						        String nom = rs3.getString("nom");
						        String prenom = rs3.getString("prenom");
						        String date = rs3.getString("date_Naissance");
							%>
							    <div class="transfer">
							        <dl class="transfer-details">
							            <div>
							            	<dt><%= nom %></dt>
							                <dd>Nom</dd>
							            </div>
							            <div>
							                <dt><%= prenom %></dt>
							                <dd>Prenom</dd>
							            </div>
							            <div>
							                <dt><%= date %></dt>
							                <dd>Date de Naissance</dd>
							            </div>
										<div style="margin-left:30px;">
											<dt style="display:flex;height:50%;">
											  <a href="update_etud.jsp?etd_name=<%=nom%>" style="display:inline-block;margin-right:10px;">
											    <img src="update_icon.png" alt="Update icon" width="50%">
											  </a>
												<a id="alerto" href="delete_etud.jsp?nom=<%=nom%>" style="display:inline-block;">
												  <img src="delete_icon.png" alt="Delete icon" width="50%">
												</a>
												


											</dt>
											
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
                <p>You can add Professors here!</p>
                    <form method="post" action="./Admin.jsp?username=<%=name %>" class="faq">
					    <div>
					        <label for="login">New Login:</label>
					        <input type="text" id="login" name="login" placeholder="New Login" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="password">New Password:</label>
					        <input type="text" id="password" name="password" placeholder="New Password" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="nom">Nom:</label>
					        <input type="text" id="nom" name="nom" placeholder="Nom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="prenom">Prenom:</label>
					        <input type="text" id="prenom" name="prenom" placeholder="Prenom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="DateNaissance">Date Naissance:</label>
					        <input type="text" id="DateNaissance" name="DateNaissance" placeholder="Date Naissance" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Email">Email:</label>
					        <input type="text" id="Email" name="Email" placeholder="Email" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Fonction">Fonction:</label>
					        <input type="text" id="Fonction" name="Fonction" placeholder="Fonction" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Etat">Etat:</label>
					        <input type="text" id="Etat" name="Etat" placeholder="Etat" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Statut">Statut:</label>
					        <input type="text" id="Statut" name="Statut" placeholder="Statut" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Grade">Grade:</label>
					        <input type="text" id="Grade" name="Grade" placeholder="Grade" style="color:whitesmoke;">
					    </div>
					    <input type="submit" class="save-button" value="Insert new Porfessor">
					</form>
					
					<%
					    String login = request.getParameter("login");
					    String password = request.getParameter("password");
					    String nom = request.getParameter("nom");
					    String prenom = request.getParameter("prenom");
					    String dateNaissance = request.getParameter("DateNaissance");
					    String email = request.getParameter("Email");
					    String fonction = request.getParameter("Fonction");
					    String etat = request.getParameter("Etat");
					    String statut = request.getParameter("Statut");
					    String grade = request.getParameter("Grade");
					    if(login != null){
							
					    try {
					    	
					        // Get the last inserted id_compte
					        String query = "SELECT id_compte FROM compte ORDER BY id_compte DESC LIMIT 1";
					        Statement getLastIdStmt = conn.createStatement();
					        ResultSet resultSet = getLastIdStmt.executeQuery(query);
					        int lastId = 0;
					        if (resultSet.next()) {
					            lastId = resultSet.getInt("id_compte");
					        }
					
					        // Close the ResultSet and the Statement
					        resultSet.close();
					        getLastIdStmt.close();
					
					        // Get the last inserted id_enseignant
					        String query1 = "SELECT id_enseignant FROM enseignants ORDER BY id_enseignant DESC LIMIT 1";
					        Statement getLastIdStmt1 = conn.createStatement();
					        ResultSet resultSet1 = getLastIdStmt1.executeQuery(query1);
					        int lastId1 = 0;
					        if (resultSet1.next()) {
					            lastId1 = resultSet1.getInt("id_enseignant");
					        }
					
					        // Close the ResultSet and the Statement
					        resultSet1.close();
					        getLastIdStmt1.close();
					
					        // Insert the new record into the compte table
					        PreparedStatement statement = conn.prepareStatement("INSERT INTO compte (id_compte, login, pwd) VALUES (?, ?, ?)");
					        statement.setInt(1, lastId + 1);
					        statement.setString(2, login);
					        statement.setString(3, password);
					        statement.executeUpdate();
					        statement.close();
					
					        // Insert the new enseignant into the enseignants table with the retrieved id_compte
					        PreparedStatement ensStat = conn.prepareStatement("INSERT INTO enseignants (id_enseignant, nom_ens, prenom_ens, date_Naissance, mail_ens, fonction, etat, statut, grade, id_compte) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
					        ensStat.setInt(1, lastId1 + 1);
					        ensStat.setString(2, nom);
					        ensStat.setString(3, prenom);
					        ensStat.setString(4, dateNaissance);
					        ensStat.setString(5, email);
					        ensStat.setString(6, fonction);
					        ensStat.setString(7, etat);
					        ensStat.setString(8, statut);
					        ensStat.setString(9, grade);
					        ensStat.setInt(10, lastId + 1);
					        ensStat.executeUpdate();
					        ensStat.close();
					
					        // Close the connection
					        conn.close();
					
					        // Display a message to confirm the insertion
					        out.println("<h3>Enseignant inserted successfully!</h3>");
					    } catch (SQLException ex) {
					        ex.printStackTrace();
					        out.println("<h3>Error</h3>"+ex);}
					    }
%>
                </section>
                <section class="payment-section">
                <p><br>You can add Students here!</p>
                    <form method="post" action="./Admin.jsp?username=<%=name %>" class="faq">
                    	<div>
					        <label for="anneeuniv">Annee universitaire:</label>
					        <input type="text" id="anneeunniv" name="anneeuniv" placeholder="Annee Universitaire" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="niveau">Niveau:</label>
					        <input type="text" id="Email" name="niveau" placeholder="Niveau" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Classe">Classe:</label>
					        <input type="text" id="Fonction" name="classe" placeholder="Classe" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Nom">Nom:</label>
					        <input type="text" id="login" name="nom" placeholder="Nom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Prenom">Prenom:</label>
					        <input type="text" id="Prenom" name="prenom" placeholder="Prenom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="DateNaiss">Date de Naissance:</label>
					        <input type="text" id="nom" name="date_naiss" placeholder="date_naiss" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Email">Email:</label>
					        <input type="text" id="mail" name="mail" placeholder="mail" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Email">module:</label>
					        <input type="text" id="module" name="module" placeholder="module" style="color:whitesmoke;">
					    </div>
					    <input type="submit" class="save-button" value="Insert new Student">
					</form>
					
					<%
				    	String anneeuniv = request.getParameter("anneeuniv");
					    String niveau = request.getParameter("niveau");
					    String classe = request.getParameter("classe");
					    String nom2 = request.getParameter("nom");
					    String prenom2 = request.getParameter("prenom");
					    String dateNaissance2 = request.getParameter("date_naiss");
					    String mail = request.getParameter("mail");
					    String module = request.getParameter("module");
					    if(niveau != null){
							
					    try {
					    	
					        // Get the last inserted id_inscription
					        String query2 = "SELECT id_inscription FROM inscription ORDER BY id_inscription DESC LIMIT 1";
					        Statement getLastIdStmt2 = conn.createStatement();
					        ResultSet resultSet2 = getLastIdStmt2.executeQuery(query2);
					        int lastId2 = 0;
					        if (resultSet2.next()) {
					            lastId2 = resultSet2.getInt("id_inscription");
					        }
					
					        // Close the ResultSet and the Statement
					        resultSet2.close();
					        getLastIdStmt2.close();
					
					        // Get the last inserted id_etudiants
					        String query3 = "SELECT id_etd FROM etudiants ORDER BY id_etd DESC LIMIT 1";
					        Statement getLastIdStmt3 = conn.createStatement();
					        ResultSet resultSet3 = getLastIdStmt3.executeQuery(query3);
					        int lastId3 = 0;
					        if (resultSet3.next()) {
					            lastId3 = resultSet3.getInt("id_etd");
					        }
					
					        // Close the ResultSet and the Statement
					        resultSet3.close();
					        getLastIdStmt3.close();
					
					        // Insert the new record into the compte table
					        PreparedStatement statement = conn.prepareStatement("INSERT INTO inscription VALUES (?, ?, ?, ?)");
					        statement.setInt(1, lastId2 + 1);
					        statement.setString(2, anneeuniv);
					        statement.setString(3, niveau);
					        statement.setString(4, classe);
					        statement.executeUpdate();
					        statement.close();
					
					        // Insert the new enseignant into the enseignants table with the retrieved id_compte
					        PreparedStatement ensStat = conn.prepareStatement("INSERT INTO etudiants VALUES (?, ?, ?, ?, ?, ?)");
					        ensStat.setInt(1, lastId3 + 1);
					        ensStat.setString(2, nom2);
					        ensStat.setString(3, prenom2);
					        ensStat.setString(4, dateNaissance2);
					        ensStat.setString(5, mail);
					        ensStat.setInt(6, lastId2 + 1);
					        ensStat.executeUpdate();
					        ensStat.close();
					
					        
					        PreparedStatement ensStat1 = conn.prepareStatement("INSERT INTO posseder VALUES (?, ?, ?)");
					        ensStat1.setInt(1, lastId3 + 1);
					        ensStat1.setString(2, module);
					        ensStat1.setString(3, null);
					        ensStat1.executeUpdate();
					        ensStat1.close();
					        // Close the connection
					        conn.close();
					
					        // Display a message to confirm the insertion
					        out.println("<h3>student inserted successfully!</h3>");
					    } catch (SQLException ex) {
					        ex.printStackTrace();
					        out.println("<h3>Error</h3>"+ex);}
					    }
%>
                </section>
            </div>

            </div>
        </div>

    <!-- partial -->

    <script src="https://unpkg.com/phosphor-icons"></script>
    <script src="./scriptDashboard.js"></script>
</body>

</html>