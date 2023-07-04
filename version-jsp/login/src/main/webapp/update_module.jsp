
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
	String module_name = request.getParameter("module_name");
	String name = request.getParameter("username"); 
%>



<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dashboard Module</title>
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
                        <h2>Establishment Students</h2>
                        <div class="filter-options">
                            <p>ENSA KHOURIBGA</p>
                            
                        </div>
                    </div>
					<div class="transfers">
					    <% 
						    PreparedStatement pstmt1 = conn.prepareStatement("SELECT * FROM module");
						    ResultSet rs2 = pstmt1.executeQuery();
						        
						    
						    while (rs2.next()) {
						    	  	String nom = rs2.getString("intitulé");
							        String prenom = rs2.getString("description");
							        String email = rs2.getString("abreveation");
							%>
							    <div class="transfer">
							        <dl class="transfer-details">
							            <div>
							            	<dt><%= nom %></dt>
							                <dd>intitulé</dd>
							            </div>
							            <div>
							                <dt><%= prenom %></dt>
							                <dd>description</dd>
							            </div>
							            <div>
							                <dt><%= email %></dt>
							                <dd>abreveation</dd>
							            </div>
										<div style="margin-left:30px;">
											<dt style="display:flex;height:50%;">
											  <a href="update_module.jsp?module_name=<%=nom%>" style="display:inline-block;margin-right:10px;">
											    <img src="update_icon.png" alt="Update icon" width="50%">
											  </a>
												<a id="alerto" href="deleteEns.jsp?module_name=<%=nom%>" style="display:inline-block;">
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
					String nom="", prenom="", dateNaissance="", mail="";
					String id="";
					PreparedStatement Query = conn.prepareStatement("SELECT * FROM module WHERE intitulé = ?");
					Query.setString(1, module_name);
					ResultSet resQ = Query.executeQuery();
					while(resQ.next()){
						nom = resQ.getString("intitulé");
						prenom = resQ.getString("description");
						mail = resQ.getString("abreveation");
						id = resQ.getString("id_ens");
					}
				
				%>

                </section>
                </div>
                <div class=" app-body-sidebar">
                <section class="payment-section">
                <p>You can update module here!</p>
                    <form method="post"  class="faq">
					    <div>
					        <label for="nom">intitulé:</label>
					        <input type="text" value=<%=nom %> id="nom" name="nom" placeholder="Nom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="prenom">description:</label>
					        <input type="text" value=<%=prenom %> id="prenom" name="prenom" placeholder="Prenom" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="mail">abreveation</label>
					        <input type="text" value=<%=mail %> id="mail" name="mail" placeholder="mail" style="color:whitesmoke;">
					    </div>
					    <div>
					        <label for="mail">Id eseignant</label>
					        <input type="text" value=<%=id %> id="id" name="id" placeholder="id enseignant" style="color:whitesmoke;">
					    </div>

					    <input type="submit" class="save-button" value="Save Infos">
					</form>
					
					<%
					int res = 0;
					nom = request.getParameter("nom");
					prenom = request.getParameter("prenom");
					mail = request.getParameter("mail");
					id = request.getParameter("id");


					if (nom != null) {
					  try {
					    // Get the last inserted id_enseignant
					    PreparedStatement qu2 = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé = ?");
					    qu2.setString(1, nom);
					    ResultSet rs_2 = qu2.executeQuery();
					    int lastId1 = 0;
					    while(rs_2.next()){
					    	lastId1 = rs_2.getInt(1);
					    }
					    
					    
			

					    // Insert the new enseignant into the enseignants table with the retrieved id_compte
					    PreparedStatement ensStat = conn.prepareStatement("UPDATE module SET intitulé = ?, description = ?, abreveation = ?, id_ens = ?  WHERE id_module = ?");
					    ensStat.setInt(4, Integer.parseInt(id));
					    ensStat.setInt(5, lastId1);
					    ensStat.setString(1, nom);
					    ensStat.setString(2, prenom);
					    ensStat.setString(3, mail); 
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
					window.location.href = "modules.jsp";
				}
			</script>
            </div>
        </div>

    <!-- partial -->

    <script src="https://unpkg.com/phosphor-icons"></script>
    <script src="./scriptDashboard.js"></script>
</body>

</html>