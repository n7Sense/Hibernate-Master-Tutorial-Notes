
package controller;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.PrintWriter;
import model.Department;

public class DepartmentServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	SessionFactory sf;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
        
     
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
	    int departmentId = Integer.parseInt(req.getParameter("departmentId"));
	    String departmentName = req.getParameter("departmentName");	     
	    int managerId = Integer.parseInt(req.getParameter("managerId"));
	    int locationId = Integer.parseInt(req.getParameter("locationId"));
	
	    Department dept = new Department(departmentId, departmentName, managerId, locationId);

	    Session  session = sf.openSession();
	    Transaction transaction = session.beginTransaction();
	    String sql = "INSERT INTO departments(department_id, department_name, manager_id, location_Id)  SELECT de.department_id, de.department_name, de.manager_id, de.location_Id FROM dep de";
	    String sql2 = "UPDATE departments SET department_name = 'RajKumar' WHERE department_id = 1";
	    Query q= session.createQuery(sql2);
	    int i = q.executeUpdate();
	    System.out.println("No. Of rows Dumped from oradb.Employees : "+i);
	    //session.save(dept);
	    transaction.commit();
	    session.close();
			
		pw.println("<html>");
		pw.println("<head><h1>NSense</h1></head>");
		pw.println("<body bgcolor='yellow'>");
		pw.println("<center><h1>Welcome ... </h1><h1>"+departmentName+"</h1></center>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		sf.close();
	}
	
}
