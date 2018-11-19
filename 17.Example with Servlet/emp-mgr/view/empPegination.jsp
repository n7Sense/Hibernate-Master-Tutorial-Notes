<%@page import="java.sql.*" %>
<%@page import="model.Employee" %>
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
				Query query  = null;
				int fr = Integer.parseInt(request.getParameter("firstResult"));
				int maxResult = Integer.parseInt(request.getParameter("maxResult"));
			    Session  sessionObj = sf.openSession();
			    
			    Transaction transaction = sessionObj.beginTransaction();
			    String sql  = "from Employee";
		        
		        query = sessionObj.createQuery(sql);
		        query.setFirstResult(fr);
		        query.setMaxResults(maxResult);
		        List<Employee>  employeeList = query.list();
			    transaction.commit();
			    sessionObj.close();
				out.println("<html>");
				out.println("<head><h1>Employee Pegination Demo</h1></head>");
				out.println("<body bgcolor='lightgreen'>");
				out.println("<center>");
				out.println("<table><tr><th>Employee Id</th><th>Employee Name</th></tr>");
				
        	for(Employee emp:employeeList){
					out.println("<tr><td>"+emp.getEmployeeId()+"</td><td>"+emp.getFirstName()+"</td><td>"+emp.getEmail()+"</td><td>"+emp.getSalary()+"</td></tr>");
			    }
			    out.println("</table>");
			    out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			%>
		</center>
	</body>
</html>