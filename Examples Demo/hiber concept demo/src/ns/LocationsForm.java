package ns;

import model.Location;
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

public class LocationsForm extends JFrame implements ActionListener, WindowListener {
    static SessionFactory sf;
    static Session  session;
    static Transaction transaction;

    JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6;

    public LocationsForm(){
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
        jtf6 = new JTextField(20);
        l1 = new JLabel("Location Id");
        l2 = new JLabel("Street Address");
        l3 = new JLabel("Postal Code");
        l4 = new JLabel("City");
        l5 = new JLabel("State Province");
        l6 = new JLabel("Country Id");

        add(l1);add(jtf1);
        add(l2);add(jtf2);
        add(l3);add(jtf3);
        add(l4);add(jtf4);
        add(l5);add(jtf5);
        add(l6);add(jtf6);
        add(b1);add(b2);

    }

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        sf = cfg.buildSessionFactory();

        LocationsForm lf = new LocationsForm();
        lf.setName("Locations Form");
        lf.setSize(350, 300);
        lf.setVisible(true);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Save")) {
            int locationId = Integer.parseInt(jtf1.getText());
            String streetAddress=jtf2.getText();
            String postalCode=jtf3.getText();
            String city=jtf4.getText();;
            String stateProvince=jtf5.getText();;
            String countryId=jtf6.getText();;
            Location location = new Location(locationId, streetAddress, postalCode, city, stateProvince, countryId);
            session = sf.openSession();
            transaction = session.beginTransaction();
            session.save(location);
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
