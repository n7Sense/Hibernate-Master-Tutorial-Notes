<%@page import="java.sql.*" %>
<%@page import="model.isA.tpcc.SoftwereUser" %>
<%@page import="model.isA.tpcc.HardwereUser" %>
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
				String softwereUser=null;
				String hardwereUser = null;
				int userId = Integer.parseInt(request.getParameter("userId"));
				String userName = request.getParameter("userName");
				String userEmail = request.getParameter("userEmail");
				softwereUser = request.getParameter("softwereUser");
				hardwereUser = request.getParameter("hardwereUser");

			    SoftwereUser su = new SoftwereUser(userId, userName, userEmail, softwereUser);
			    HardwereUser hu = new HardwereUser(userId, userName, userEmail, hardwereUser);
			    
			    Session  sessionObj = sf.openSession();
			    Transaction transaction = sessionObj.beginTransaction();
			   	
			   	if(softwereUser!=null)
			   		sessionObj.save(su);
			   	if(hardwereUser!=null)
			   		sessionObj.save(hu);

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
				out.println("<h1>Welcome .... .... User With INHERITENCE(IS-A) Relation WITh Table-Per-Concrete Class Startegy</h1>");
			    out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			%>
		</center>
	</body>
</html>