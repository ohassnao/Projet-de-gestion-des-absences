<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ page import="java.sql.*, java.util.ArrayList, java.lang.*" %>

<%-- Connect to the database --%> 

<%
Connection conn = null; 
try {
    Class.forName("com.mysql.jdbc.Driver"); 
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javabase?useUnicode=true&characterEncoding=UTF-8", "root", "");
} 
catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); } %> 
<%
    String actual_name = (String) session.getAttribute("NAME");
    String course_name = request.getParameter("course_name"); 
	session.setAttribute("course_name", course_name);
    String name = request.getParameter("username"); 

%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Dashboard Std</title>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
    />
    <link rel="stylesheet" href="./css/style.css" />
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
          <span>Pr.<%=name %></span>

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
            <a href="index.jsp">
              <i class="ph-clipboard-text"></i>
              <span>Home</span>
            </a>
          </nav>
          <footer class="footer">
            <h1>Metamask<small>IID</small></h1>
            <div>
              Metamask<br />
              Academic Web Project 2023
            </div>
          </footer>
        </div>
        <div class="app-body-main-content">
          <section class="service-section">
            <h2 id="abs">ENSAKH Dashboard</h2>
			<form method="GET" action="./generate_Infos.jsp">
			  <input type="hidden" name="course_name" value="<%=course_name%>">
			  <div class="service-section-header">
			    <div class="search-field">
			      <i class="ph-magnifying-glass"></i>
			      <input type="text" placeholder="Search" name="search_for" style="color:whitesmoke" id="search"/>
			    </div>
			    <div class="dropdown-field">
			      <select id="select_id" name="search">
			        <option value="etudiants.nom">Nom</option>
			        <option value="etudiants.prenom">Prenom</option>
			        <option>ID</option>
			      </select>
			      <i class="ph-caret-down"></i>
			    </div>
			    <button class="flat-button" type="submit" id="submit">Search</button>
			  </div>
			</form>
			
            
            <div class="mobile-only">
              <button class="flat-button">Toggle search</button>
            </div>
            <div class="tiles">
              <article class="tile" id="Abscence">
                <div class="tile-header">
                  <i class="ph-lightning-light"></i>
                  <h3>
                    <span>Absence</span>
                    <span>Fiche d'Absence</span>
                  </h3>
                </div>
                <a>
                  <span>Go to service</span>
                  <span class="icon-button">
                    <i class="ph-caret-right-bold"></i>
                  </span>
                </a>
              </article>
              <article class="tile" id="Lnote">
                <div class="tile-header">
                  <i class="ph-fire-simple-light"></i>
                  <h3>
                    <span>Notes</span>
                    <span>Fiche de Notes</span>
                  </h3>
                </div>
                <a>
                  <span>Go to service</span>
                  <span class="icon-button">
                    <i class="ph-caret-right-bold"></i>
                  </span>
                </a>
              </article>
              <article class="tile" id="Letd">
                <div class="tile-header">
                  <i class="ph-file-light"></i>
                  <h3>
                    <span>Liste Etudiant</span>
                    <span>Fiche des Etudiants</span>
                  </h3>
                </div>
                <a >
                  <span>Go to service</span>
                  <span class="icon-button">
                    <i class="ph-caret-right-bold"></i>
                  </span>
                </a>
              </article>
            </div>
            <div class="service-section-footer">
              <p>
                Veuillez contacter l'administration si vous rencontrez un
                probléme technique!
              </p>
            </div>
          </section>

          <section class="transfer-section">
            <div class="abscence" style="display: none">
              <div class="transfer-section-header">
                <h2>Les Absences</h2>
                <div class="filter-options">
                  <p><%= course_name %></p>
                </div>
              </div>
              <div class="transfers">

				<%				
				String sql = "SELECT etudiants.nom, etudiants.prenom, absence.type_absence, absence.date FROM etudiants JOIN absence ON absence.id_etd = etudiants.id_etd JOIN module ON module.id_module = absence.id_module WHERE module.intitulé = ?";
				
				String textOfInput = request.getParameter("search_for");
				String typeOfInput = request.getParameter("search");
				
				if (typeOfInput != null) {
				  sql += " AND " + typeOfInput + " = ?";
				}

				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setString(1, course_name);

				if (typeOfInput != null) {
				  stmt.setString(2, textOfInput);
				}

				//out.println(stmt);
				//out.println(textOfInput);
                ResultSet absences = stmt.executeQuery(); 
                
                
                while(absences.next()) { %>
                <div class="transfer">
                  <dl class="transfer-details">
                    <div>
                      <dt>
                        <%= absences.getString("prenom") + " " +
                        absences.getString("nom") %>
                      </dt>
                      <dd>Etudiant</dd>
                    </div>
                    <div>
                      <dt><%= absences.getString("type_absence") %></dt>
                      <dd>Type Absence</dd>
                    </div>
                    <div>
                      <dt><%= course_name%></dt>
                      <dd>Module</dd>
                    </div>
                    <div>
                      <dt><%= absences.getString("date") %></dt>
                      <dd>Date Absence</dd>
                    </div>
                  </dl>
                </div>
                <% } %>
              </div>
            </div>

            <div class="ListeEtd" style="display: none">
              <br />
              <div class="transfer-section-header">
                <h2>Liste Etudiants</h2>
                <div class="filter-options">
                  <p><%= course_name%></p>
                </div>
                <div>
                	<form method="GET" action="./generate_Infos.jsp?course_name=<%=course_name%>">
					
					  <select name="sort" id="select" class="save-button" >
					    <option value="" hidden>Sort By</option>
					    <option value="etudiants.id_etd">ID</option>
					    <option value="etudiants.nom">Nom</option>
					    <option value="etudiants.prenom">Prenom</option>
					    <option value="etudiants.mail">Mail</option>
					  </select>
					
						<script>
						document.addEventListener("DOMContentLoaded", () => {
						  document.getElementById("select").addEventListener("change", function() {
						    var selectedValue = this.value;
						    window.location.href = "generate_Infos.jsp?course_name=<%=course_name%>&sort=" + encodeURIComponent(selectedValue);
						  });
						});
						</script>

					</form>
                </div>
              </div>
              <!-- e.cne, e.nom, e.prenom, e.filiere -->
              <div class="transfers">
              	
                <% 
                String orderBy = request.getParameter("sort");
                if(orderBy==null){
                	orderBy = "etudiants.id_etd";
                }
				
				String sql1 = "SELECT DISTINCT etudiants.nom, etudiants.prenom, etudiants.mail, module.description FROM etudiants JOIN posseder ON posseder.id_etd = etudiants.id_etd JOIN module ON module.id_module = posseder.id_module	 WHERE module.intitulé= ?";
				if (typeOfInput != null) {
					  sql1 += " AND " + typeOfInput + " = ?";
					}
				 sql1 += " ORDER BY " +orderBy;
				
				PreparedStatement stmt1 = conn.prepareStatement(sql1);
				

				stmt1.setString(1, course_name);

				if (typeOfInput != null) {
				  stmt1.setString(2, textOfInput);
				}
				
				
                 ResultSet liste = stmt1.executeQuery();
                
                while (liste.next())
                { %>
                	
					<% 
					int nbrAbsences = 0;
					PreparedStatement stmt9 = conn.prepareStatement("SELECT id_etd FROM etudiants WHERE nom = ?");
			        stmt9.setString(1, liste.getString("nom"));
			        ResultSet res = stmt9.executeQuery();
			        int EtdId1 = 0;
			        if(res.next()){EtdId1 = res.getInt(1);}
			        
			        PreparedStatement query_Id_Module1 = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé=?");
			        query_Id_Module1.setString(1, course_name);
			        ResultSet res_Query = query_Id_Module1.executeQuery();
			        int ModuleId1 = 0;
			        while(res_Query.next()) {ModuleId1 = res_Query.getInt("id_module");}
					
					PreparedStatement nbrAbsence = conn.prepareStatement("SELECT COUNT(*) FROM absence WHERE absence.id_etd=? and absence.id_module=?");
		            nbrAbsence.setInt(1, EtdId1);
		            nbrAbsence.setInt(2, ModuleId1);
		            ResultSet nbrAbs = nbrAbsence.executeQuery();
		            nbrAbsences = 0;
		            while(nbrAbs.next()) {nbrAbsences=nbrAbs.getInt(1);}
		            %>
                <div class="transfer">
                  <dl class="transfer-details">
                    <div>
                      <dt>
                        <%= liste.getString("prenom") + " " +
                        liste.getString("nom") %>
                      </dt>
                      <dd>Etudiant</dd>
                    </div>
                    <div>
                      <dt><%= liste.getString("mail") %></dt>
                      <dd>Email</dd>
                    </div>
                    <div>
                      <dt><%= course_name%></dt>
                      <dd>Module</dd>
                    </div>
                    <div>
                      <dt><%= liste.getString("description") %></dt>
                      <dd>Description</dd>
                    </div>
                    <div>
                      <% 
                      String stm = null;
                      if(nbrAbsences >= 5){
                      	stm = "Ne passe pas l'Exam";
                      }
                      else{
                    	stm = "Nothing";
                      }
                      %>
                      <dt><%= stm %></dt>
                      <dd>Nature de Sanction</dd>
                    </div>
                  </dl>
                </div>
                <% } %>
              </div>
            </div>
            
            <div class="ListeNote" style="display: none">
              <br />
              <div class="transfer-section-header">
                <h2>Liste Notes</h2>
                <div class="filter-options">
                  <p><%= course_name%></p>
                </div>
              </div>
              <!-- e.cne, e.nom, e.prenom, e.filiere -->
              <div class="transfers">
                <%
					String sql10 = "SELECT * FROM etudiants JOIN posseder ON posseder.id_etd = etudiants.id_etd JOIN module ON module.id_module = posseder.id_module WHERE module.intitulé= ? and note IS NOT NULL ";
					if (typeOfInput != null) {
						  sql10 += " AND " + typeOfInput + " = ?";
						}
					
					PreparedStatement stmt10 = conn.prepareStatement(sql10);
	                stmt10.setString(1, course_name);
				
					if (typeOfInput != null) {
					  stmt10.setString(2, textOfInput);
					}
	                ResultSet listeNotes = stmt10.executeQuery(); 

				int nbrAbsences = 0;	 
                while (listeNotes.next()) { %>

                <div class="transfer">
                  <dl class="transfer-details">
                    <div>
                      <dt>
                        <%= listeNotes.getString("prenom") + " " +
                        listeNotes.getString("nom") %>
                      </dt>
                      <dd>Etudiant</dd>
                    </div>
                    <div>
                      <dt><%= listeNotes.getString("note") %></dt>
                      <dd>Note</dd>
                    </div>
                    <div>
                      <dt><%=course_name%></dt>
                      <dd>Module</dd>
                    </div>

                  </dl>
                </div>
                <% } %>
              </div>
            </div>
            
          </section>
                 
        </div>
                  <div class=" app-body-sidebar">
                <section class="payment-section">
                    <form method="post">
                        <div class="faq">
                            <p>Marquer Absence ici</p>
                            <div>
                                <label for="name">Etudiant</label>
                                <input type="text" placeholder="Type here" name="name" autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
                            <div>
                                <label for="department">Date Absence</label>
                                <input type="text" placeholder="Type here" name="dateAbsence" required autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
							<div>
                                <label for="department">Justification?</label>
                                <input type="text" placeholder="Type here" name="justification" required autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
                        </div>
                        <div class="payment-section-footer">
                            <button class="save-button" name="submit">Save Abscence</button>
                        </div>
							<%
							    //String justificatif = "";
							    String nomEtd = request.getParameter("name");
							    String dateAbsence = request.getParameter("dateAbsence");
							    String justificatif = request.getParameter("justification");
							    String module = course_name;
							    
							    try {
							        
							        PreparedStatement stmt2 = conn.prepareStatement("SELECT id_etd FROM etudiants WHERE nom = ?");
							        stmt2.setString(1, nomEtd);
							        ResultSet res = stmt2.executeQuery();
							        int EtdId = 0;
							        while(res.next()){EtdId = res.getInt("id_etd");}
							        
							        PreparedStatement query_Id_Module = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé=?");
							        query_Id_Module.setString(1, module);
							        ResultSet res_Query = query_Id_Module.executeQuery();
							        int ModuleId = 0;
							        while(res_Query.next()) {ModuleId = res_Query.getInt("id_module");}
							        
							        // Find the maximum ID from the absence table
							        Statement stmtMaxId = conn.createStatement();
							        ResultSet rsMaxId = stmtMaxId.executeQuery("SELECT MAX(id_absence) FROM absence");
							        int maxId = 0;
							        if (rsMaxId.next()) {
							            maxId = rsMaxId.getInt(1);
							        }
							           
							        // Insert the record into the "absence" table
							        PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO absence (id_absence, date, type_absence, id_etd, id_module) VALUES (?, ?, ?, ?, ?)");
							        stmt3.setInt(1, maxId + 1);
							        stmt3.setString(2, dateAbsence);
							        stmt3.setString(3, justificatif);
							        stmt3.setInt(4, EtdId);
							        stmt3.setInt(5, ModuleId);
							        stmt3.executeUpdate();

							        // Display a success message
							        out.println("<script>alert('Record inserted successfully.');</script>");
							        //response.sendRedirect(request.getRequestURI());
							    } catch (SQLException ex) {
							        // Display an error message if there's a problem with the database
							        out.println("<script>alert('Error inserting record: " + ex.getMessage() + "');</script>");
							    }
							    
							%>
                    </form>
                   
					<form method="post" >
                        <div class="faq">
                            <p>Ajout des Notes</p>
                            <div>
                                <label for="name1">Etudiant</label>
                                <input type="text" placeholder="Type here" name="name1" autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
                            <div>
                                <label for="note">Note</label>
                                <input type="text" placeholder="Type here" name="note" required autocomplete="off"
                                    style="color:whitesmoke;" />
                            </div>
                        </div>
                        <div class="payment-section-footer">
                            <button class="save-button" name="submit">Save Note</button>
                            <button class="settings-button">
                                <i class="ph-gear"></i>
                                <span>More settings</span>
                            </button>
                        </div>
                        
                        <%
							    String nomEtudiant = request.getParameter("name1");
							    String note = request.getParameter("note");
							    int noteInt = 0;
							    if (note != null && !note.isEmpty()){
							    	noteInt = Integer.parseInt(note);
							    }
							    
								if(nomEtudiant != null){
								    
								    try {
								        
								        PreparedStatement stmt4 = conn.prepareStatement("SELECT id_etd FROM etudiants WHERE nom = ?");
								        stmt4.setString(1, nomEtudiant);
								        ResultSet res = stmt4.executeQuery();
								        int EtdId1 = 0;
								        if(res.next()){EtdId1 = res.getInt("id_etd");}
								        
								        PreparedStatement query_Id_Module1 = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé=?");
								        query_Id_Module1.setString(1, module);
								        ResultSet res_Query = query_Id_Module1.executeQuery();
								        int ModuleId1 = 0;
								        while(res_Query.next()) {ModuleId1 = res_Query.getInt("id_module");}
								        

								           
								        // Insert the record into the "absence" table
								        PreparedStatement stmt5 = conn.prepareStatement("INSERT INTO posseder (id_etd, id_module, note) VALUES (?, ?, ?)");
								        stmt5.setInt(1, EtdId1);
								        stmt5.setInt(2, ModuleId1);
								        stmt5.setInt(3, noteInt);
								        stmt5.executeUpdate();

								        // Display a success message
								        out.println("<script>alert('Record inserted successfully.');</script>");
								        //response.sendRedirect(request.getRequestURI());
								    } catch (SQLException ex) {
								        // Display an error message if there's a problem with the database
								        out.println("<script>alert('Error inserting record: " + ex.getMessage() + "');</script>");
								    }
								}

							    
						%>
                        
                    </form>

                </section>
            </div>
        
      </div>
      
    </div>
    

    
    <!-- partial -->
    <script src="https://unpkg.com/phosphor-icons"></script>
    <script src="./scriptDashboard.js"></script>
  </body>

  <script>
    document.addEventListener("DOMContentLoaded", () => {
      document
        .getElementById("Abscence")
        .addEventListener("click", function () {
          const element = document.querySelector(".abscence");
          element.style.opacity = 0;
          element.style.display = "block";
          setTimeout(() => {
            element.style.opacity = 1;
          }, 10);
        });
      document.getElementById("Letd").addEventListener("click", function () {
        const element = document.querySelector(".ListeEtd");
        element.style.opacity = 0;
        element.style.display = "block";
        setTimeout(() => {
          element.style.opacity = 1;
        }, 10);
      });
      document.getElementById("Lnote").addEventListener("click", function () {
          const element = document.querySelector(".ListeNote");
          element.style.opacity = 0;
          element.style.display = "block";
          setTimeout(() => {
            element.style.opacity = 1;
          }, 10);
        });
    });
  </script>
</html>
