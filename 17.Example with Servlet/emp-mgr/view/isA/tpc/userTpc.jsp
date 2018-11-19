<%@page import="java.sql.*" %>
<%@page import="model.isA.tpc.SuperUser" %>
<%@page import="model.isA.tpc.AdminUser" %>
<%@page import="model.isA.tpc.ProjectManager" %>
<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.Query" %>
<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.cfg.Configuration" %>
<%@page import="org.hibernate.Criteria" %>
<%@page import="org.hibernate.criterion.Criterion" %>
<%@page import="org.hibernate.criterion.Restrictions" %>
<%@page import="org.hibernate.criterion.Projection" %>
<%@page import="org.hibernate.criterion.Projections" %>
<%@page import="java.util.List" %>
<html>
	<body bgcolor="lightgreen">
		<center>
			<%! 
				SessionFactory sf;
				public void jspInit(){
					Configuration cfg = new Configuration();
					cfg.configure("hibernate.cfg.xml");
					sf = cfg.buildSessionFactory();
				}

				public void jspDestroyed(){
					sf.close();
				}

			%>
			
			<%  
				/*int superUserId = Integer.parseInt(request.getParameter("superUserId"));
				int adminUserId = Integer.parseInt(request.getParameter("adminUserId"));
				int managerUserId = Integer.parseInt(request.getParameter("managerUserId"));*/
				String userName = request.getParameter("userName");
				String userEmail = request.getParameter("userEmail");
				String superUser = request.getParameter("superUser");
				String adminUser = request.getParameter("adminUser");
				String projectManager = request.getParameter("projectManager");

			    SuperUser su = new SuperUser(0, userName, userEmail, superUser);
			    AdminUser au = new AdminUser(0, userName, userEmail, adminUser);
			    ProjectManager pm = new ProjectManager(0, userName, userEmail, projectManager);

			    Session  sessionObj = sf.openSession();
			    Transaction transaction = sessionObj.beginTransaction();
			   	sessionObj.save(su);
			  	sessionObj.save(au);
			   	sessionObj.save(pm);
			   	transaction.commit();
			    sessionObj.close();			  
			  /*  Criteria criteria = sessionObj.createCriteria(User.class);
			    List<> userList = criteria.list();
*/

				
				out.println("<html>");
				out.println("<head><h1>Users Record</h1></head>");
				out.println("<body bgcolor='yellow'>");
				//out.println("<h1>Find Unique Record</h1><h2>	"+region1.getRegionId()+" : "+region1.getRegionName()+"</h2>");
				out.println("<center>");
				out.println("<h1>Welcome .... ....<br> User With INHERITENCE(IS-A) Relation <br> WITh Table-Per-Class Startegy</h1>");
			    out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			%>
		</center>
	</body>
</html>