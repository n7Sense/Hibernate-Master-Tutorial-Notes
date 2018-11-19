<%@page import="java.sql.*" %>
<%@page import="model.isA.tpsc.Programmer" %>
<%@page import="model.isA.tpsc.ProductManager" %>
<%@page import="model.isA.tpsc.InventoryManager" %>
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
				String programmer = null;
				String productManager = null;
				String inventoryManager = null;

				int userId = Integer.parseInt(request.getParameter("userId"));
				String userName = request.getParameter("userName");
				String userEmail = request.getParameter("userEmail");
				programmer = request.getParameter("programmer");
				productManager = request.getParameter("productManager");
				inventoryManager = request.getParameter("inventoryManager");

			    Programmer prog = new Programmer(userId, userName, userEmail, programmer);
			    ProductManager prod = new ProductManager(userId, userName, userEmail, productManager);
			    InventoryManager invent = new InventoryManager(userId, userName, userEmail, inventoryManager);

			    Session  sessionObj = sf.openSession();
			    Transaction transaction = sessionObj.beginTransaction();
			    
			    if(programmer!=null)
			   		sessionObj.save(prog);
			   	if(productManager!=null)
			  		sessionObj.save(prod);
			  	if(inventoryManager!=null)
			   		sessionObj.save(invent);

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
				out.println("<h1>Welcome .... .... User With INHERITENCE(IS-A) Relation WITh Table-Per-Sub-Class Startegy</h1>");
			    out.println("</center>");
				out.println("</body>");
				out.println("</html>");
				out.close();
			%>
		</center>
	</body>
</html>