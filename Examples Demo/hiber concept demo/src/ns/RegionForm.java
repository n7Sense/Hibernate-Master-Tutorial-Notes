package ns;

import model.Region;
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

public class RegionForm extends JFrame implements ActionListener, WindowListener {
    static SessionFactory sf;
    static Session  session;
    static Transaction transaction;

    JTextField jtf1, jtf2;
    JButton b1, b2;
    JLabel l1, l2;
    public RegionForm(){
        setLayout(new FlowLayout());
        b1 = new JButton("Register");
        b2 = new JButton("Reset");
        b1.addActionListener(this);
        b2.addActionListener(this);
        addWindowListener(this);
        jtf1 = new JTextField(20);
        jtf2 = new JTextField(20);
        l1 = new JLabel("Region Id");
        l2 = new JLabel("Region Name");

        add(l1);add(jtf1);
        add(l2);add(jtf2);
        add(b1);add(b2);

    }

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();
        RegionForm rf = new RegionForm();
        rf.setName("Region Form");
        rf.setSize(350, 200);
        rf.setVisible(true);
        rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Register")) {
            int regionId = Integer.parseInt(jtf1.getText());
            String regionName = jtf2.getText();
            Region region = new Region();
            region.setRegionId(regionId);
            region.setRegionName(regionName);
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save(region);
            transaction.commit();
        }
        if(e.getActionCommand().equals("Reset")){
            jtf1.setText("");
            jtf2.setText("");
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
