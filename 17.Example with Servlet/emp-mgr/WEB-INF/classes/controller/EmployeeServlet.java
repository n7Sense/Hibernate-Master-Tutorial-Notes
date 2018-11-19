package controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.PrintWriter;
import model.Employee;

public class EmployeeServlet extends HttpServlet{

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
		int employeeId = Integer.parseInt(req.getParameter("empid"));
	    String firstName = req.getParameter("fname");
	    String lastName = req.getParameter("lname");
	    String email = req.getParameter("email");
	    String phoneNumber = req.getParameter("phone");
	    Date hireDate = new Date();
	    String jobId = req.getParameter("jobId");
	    double salary = Double.parseDouble(req.getParameter("salary"));
	    float commission = Float.parseFloat( req.getParameter("commission"));
	    int managerId = Integer.parseInt(req.getParameter("managerId"));
	    int departmentId = Integer.parseInt(req.getParameter("departmentId"));
	
	    Employee emp = new Employee(firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commission, managerId, departmentId);
	    Session  session = sf.openSession();
	    Transaction transaction = session.beginTransaction();
	    session.save(emp);
	    transaction.commit();
	    session.close();

		pw.println("<html>");
		pw.println("<head><h1>NSense</h1></head>");
		pw.println("<body bgcolor='yellow'>");
		pw.println("<center><h1>Welcome ... </h1><h1>"+firstName+" "+lastName+"</h1></center>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();

	}

	@Override
	public void destroy() {
		sf.close();
	}
	
}
