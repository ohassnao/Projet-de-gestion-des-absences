<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.sql.*, java.util.ArrayList, java.lang.*"  %>

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
	String ens_name = request.getParameter("ens_name");
	
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
                <span>Pr. <%=ens_name %></span>

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
                    <a href="./home_page.html">
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
						        String nom1 = rs2.getString("nom_ens");
						        String prenom1 = rs2.getString("prenom_ens");
						        String email1 = rs2.getString("mail_ens");
						        String fonction1 = rs2.getString("fonction");
						        String etat1 = rs2.getString("etat");
							%>
							    <div class="transfer">
							        <dl class="transfer-details">
							            <div>
							            	<dt><%= nom1 %></dt>
							                <dd>Nom</dd>
							            </div>
							            <div>
							                <dt><%= prenom1 %></dt>
							                <dd>Prenom</dd>
							            </div>
							            <div>
							                <dt><%= fonction1 %></dt>
							                <dd>Fonction</dd>
							            </div>
							            <div>
							                <dt><%= etat1 %></dt>
							                <dd>Etat</dd>
							            </div>
										<div style="margin-left:30px;">
											<dt style="display:flex;height:50%;">
											  <a href="update.jsp?ens_name=<%=nom1%>" style="display:inline-block;margin-right:10px;">
											    <img src="update_icon.png" alt="Update icon" width="50%">
											  </a>
												<a id="alerto" href="deleteEns.jsp?ens_name=<%=nom1%>" style="display:inline-block;">
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
				
				
				<%
					int idEns=0;
					String nom="", prenom="", dateNaissance="", mail="", fonction="", etat="", statut="", grade="";
					PreparedStatement Query = conn.prepareStatement("SELECT * FROM enseignants WHERE nom_ens = ?");
					Query.setString(1, ens_name);
					ResultSet resQ = Query.executeQuery();
					while(resQ.next()){
						idEns = resQ.getInt("id_enseignant");
						nom = resQ.getString("nom_ens");
						prenom = resQ.getString("prenom_ens");
						dateNaissance = resQ.getString("date_Naissance");
						mail = resQ.getString("mail_ens");
						etat = resQ.getString("etat");
						statut = resQ.getString("statut");
						fonction = resQ.getString("fonction");
						grade = resQ.getString("grade");
					}
				
				%>

                </section>
                </div>
                <div class=" app-body-sidebar">
                <section class="payment-section">
                <p>You can add Professors here!</p>
                    <form method="post"  class="faq">
					    <div>
					        <label for="nom">Nom:</label>
					        <input type="text" value=<%=nom %> id="nom" name="nom" placeholder="Nom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="prenom">Prenom:</label>
					        <input type="text" value=<%=prenom %> id="prenom" name="prenom" placeholder="Prenom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="DateNaissance">Date Naissance:</label>
					        <input type="text" value=<%=dateNaissance %> id="DateNaissance" name="DateNaissance" placeholder="Date Naissance" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Email">Email:</label>
					        <input type="text" value=<%=mail %> id="Email" name="Email" placeholder="Email" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Fonction">Fonction:</label>
					        <input type="text" value=<%=fonction %> id="Fonction" name="Fonction" placeholder="Fonction" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Etat">Etat:</label>
					        <input type="text" value=<%=etat %> id="Etat" name="Etat" placeholder="Etat" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Statut">Statut:</label>
					        <input type="text" value=<%=statut %> id="Statut" name="Statut" placeholder="Statut" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="Grade">Grade:</label>
					        <input type="text" value=<%=grade %> id="Grade" name="Grade" placeholder="Grade" style="color:whitesmoke;">
					    </div>
					    <input type="submit" class="save-button" value="Save Infos">
					</form>
					
					<%
					int res = 0;
					nom = request.getParameter("nom");
					prenom = request.getParameter("prenom");
					dateNaissance = request.getParameter("DateNaissance");
					mail = request.getParameter("Email");
					fonction = request.getParameter("Fonction");
					etat = request.getParameter("Etat");
					statut = request.getParameter("Statut");
					grade = request.getParameter("Grade");

					if (nom != null) {
					  try {
					    // Get the last inserted id_enseignant
					    PreparedStatement qu2 = conn.prepareStatement("SELECT id_enseignant FROM enseignants WHERE nom_ens = ?");
					    qu2.setString(1, ens_name);
					    ResultSet rs_2 = qu2.executeQuery();
					    int lastId1 = 0;
					    while(rs_2.next()){
					    	lastId1 = rs_2.getInt("id_enseignant");
					    }
					    
					    
 

					    // Insert the new enseignant into the enseignants table with the retrieved id_compte
					    PreparedStatement ensStat = conn.prepareStatement("UPDATE enseignants SET nom_ens = ?, prenom_ens = ?, date_Naissance = ?, mail_ens = ?, fonction = ?, etat = ?, statut = ?, grade = ? WHERE id_enseignant = ?");
					    ensStat.setInt(9, lastId1);
					    ensStat.setString(1, nom);
					    ensStat.setString(2, prenom);
					    ensStat.setString(3, dateNaissance);
					    ensStat.setString(4, mail);
					    ensStat.setString(5, fonction);
					    ensStat.setString(6, etat);
					    ensStat.setString(7, statut);
					    ensStat.setString(8, grade); 
					    ensStat.executeUpdate();
					    res = 1;
					  } catch (SQLException ex) {
					    ex.printStackTrace();
					    out.println("<h3>Error</h3>" + ex);
					  }
					}

%>
                </section>
            </div>
  			<script>
  				let res = <%=res%>;
				if(res == 1){
					alert("UPDATE DONE");
					window.location.href = "Admin.jsp";
				}
			</script>
            </div>
        </div>

    <!-- partial -->

    <script src="https://unpkg.com/phosphor-icons"></script>
    <script src="./scriptDashboard.js"></script>
</body>

</html>