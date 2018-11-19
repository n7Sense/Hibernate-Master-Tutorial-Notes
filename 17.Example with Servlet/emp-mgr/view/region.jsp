<%@page import="java.sql.*" %>
<%@page import="manage.Region" %>
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
				int regionId = Integer.parseInt(request.getParameter("regionId"));
				String regionName = (String)request.getParameter("regionName");
			    Region region = new Region();
			    region.setRegionId(regionId);
			    region.setRegionName(regionName);
			    Session  sessionObj = sf.openSession();
			    Transaction transaction = sessionObj.beginTransaction();
			   //  sessionObj.save(region);
			    String sql = "INSERT INTO regions(region_id, region_name) SELECT re.region_id, re.region_name FROM oradb.regions de";
			    //Query q= sessionObj.createQuery(sql);
			    //int i = q.executeUpdate();
			    //System.out.println("No. Of rows Dumped from oradb.Employees : "+i);
			    Criteria criteria = sessionObj.createCriteria(Region.class);
			    
			    List<Region> regionList = criteria.list();
			    
			    /**		Selecting The Record By ID
			    	Criterion criterion = Restrictions.eq("regionId", 1);
				    criteria.add(criterion);
				    Region region1 = (Region)criteria.uniqueResult();
			    */
				Projection p = Projections.max("regionId");
				criteria.setProjection(p);
				int max = (Integer)criteria.uniqueResult();
				System.out.println("The maximum ID is : "+max);
			    transaction.commit();
			    
			    sessionObj.close();
					
				out.println("<html>");
				out.println("<head><h1>Region Record</h1></head>");
				out.println("<body bgcolor='yellow'>");
				//out.println("<h1>Find Unique Record</h1><h2>	"+region1.getRegionId()+" : "+region1.getRegionName()+"</h2>");
				out.println("<center>");
				out.println("<table><tr><th>Region Id</th><th>Region Name</th></tr>");
				for (Region r: regionList) {
					out.println("<tr><td>"+r.getRegionId()+"</td><td>"+r.getRegionName()+"</td></tr>");
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