package ns;

import model.Jobs;
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

public class JobForm extends JFrame implements ActionListener, WindowListener {
    static SessionFactory sf;
    static Session  session;
    static Transaction transaction;

    JTextField jtf1, jtf2, jtf3, jtf4;
    JButton b1, b2;
    JLabel l1, l2, l3, l4;

    public JobForm(){


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
        l1 = new JLabel("Job Id");
        l2 = new JLabel("Job Title");
        l1 = new JLabel("Min Salary");
        l2 = new JLabel("Max Salary");

        add(l1);add(jtf1);
        add(l2);add(jtf2);
        add(l3);add(jtf3);
        add(l4);add(jtf4);
        add(b1);add(b2);

    }

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();

        JobForm jf = new JobForm();
        jf.setName("Region Form");
        jf.setSize(350, 200);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")) {
            String jobId = jtf1.getText();
            String jobTitle = jtf2.getText();
            int minSalary = Integer.parseInt(jtf3.getText());
            int maxSalary = Integer.parseInt(jtf4.getText());

            Jobs jobs = new Jobs(jobId, jobTitle, minSalary, maxSalary);
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save(jobs);
            transaction.commit();
        }
        if(e.getActionCommand().equals("Reset")){
            jtf1.setText("");
            jtf2.setText("");
            jtf3.setText("");
            jtf4.setText("");
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
