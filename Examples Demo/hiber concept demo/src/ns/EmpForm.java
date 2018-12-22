package ns;

import model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

public class EmpForm extends JFrame implements ActionListener, WindowListener {
    static SessionFactory sf;
    static Session  session;
    static Transaction transaction;

    JTextField jtf1, jtf2,jtf3, jtf4, jtf5, jtf6, jtf7, jtf8, jtf9, jtf10, jtf11;
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;

    public EmpForm(){
        setLayout(new FlowLayout());
        b1 = new JButton("Save");
        b2 = new JButton("Reset");
        b1.addActionListener(this);
        b2.addActionListener(this);
        addWindowListener(this);

        jtf1 = new JTextField(20);
        jtf2 = new JTextField(20);
        jtf3 = new JTextField(20);
        jtf4 = new JTextField(20);
        jtf5 = new JTextField(20);
        jtf6 = new JTextField(""+new Date(), 20);
        jtf7 = new JTextField(20);
        jtf8 = new JTextField(20);
        jtf9 = new JTextField(20);
        jtf10 = new JTextField(20);
        jtf11 = new JTextField(20);

        l1 = new JLabel("Employee Id");
        l2 = new JLabel("First Name");
        l3 = new JLabel("Last Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Phone Number");
        l6 = new JLabel("Hire Date");
        l7 = new JLabel("Job ID");
        l8 = new JLabel("Salary");
        l9 = new JLabel("Commission");
        l10 = new JLabel("Manager ID");
        l11 = new JLabel("Department ID");

        add(l1);add(jtf1);
        add(l2);add(jtf2);
        add(l3);add(jtf3);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(l2);add(jtf2);
        add(b1);add(b2);

    }

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();




        EmpForm ef= new EmpForm();
        ef.setName("Employee Form");
        ef.setSize(350, 500);
        ef.setVisible(true);
        ef.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")) {
            int employeeId = Integer.parseInt(jtf1.getText());
            String firstName = jtf2.getText();
            String lastName = jtf3.getText();
            String email = jtf4.getText();
            String phoneNumber = jtf5.getText();
            Date hireDate = new Date(jtf6.getText());
            String jobId = jtf7.getText();
            double salary = Double.parseDouble(jtf8.getText());
            float commission = Float.parseFloat(jtf9.getText());
            int managerId = Integer.parseInt(jtf10.getText());
            int locationId = Integer.parseInt(jtf11.getText());

            Employee employee = new Employee(employeeId, firstName, lastName, email, phoneNumber, hireDate, jobId, salary, commission, managerId, locationId);
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
        if(e.getActionCommand().equals("Reset")){
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");;
            jtf4.setText("");;
            jtf5.setText("");;
            jtf6.setText("");
            jtf7.setText("");;
            jtf8.setText("");;
            jtf9.setText("");;
            jtf10.setText("");;
            jtf11.setText("");;
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("Window opened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Window Closing");
        System.out.println("Closing Session and SessionFactory");
        session.close();
        sf.close();
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("Window Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("WindowDeiconfied");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Window Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("Window Deactivated");
    }
}
