package GUI;


import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

import Model.User;

public class AdminTabbedScreenGUI extends JFrame implements MouseListener{
	private JTabbedPane tabbedPane;
	private JLabel welcome, welcomeUser, signOut;;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private ArrayList<User> users;
	private String usersID, usersFirstName;
	private Font font, fontRegular;
	private Color color = new Color(227,99,26);

	public AdminTabbedScreenGUI(String user, ArrayList<User> users) {
		super("Home");
		fontRegular = new Font("Veranda", font.PLAIN, 16);
		font = new Font("Veranda", font.ITALIC, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,600);
		setLocationRelativeTo(null);
		StartScreenGUI.setLoggedIn(true);
		this.usersID = user;
		this.users = users;
		ImageIcon icon = new ImageIcon("lib/TitanFallLogo.png");
		welcome = new JLabel(icon);
		welcome.setBounds(150, 50, 700, 196);
		add(welcome);
		
		welcomeUser = new JLabel("Welcome, " + getUsersFirstName());
		welcomeUser.setBounds(740, 30, 140, 23);
		welcomeUser.setFont(fontRegular);
		add(welcomeUser);
		
		signOut = new JLabel("Sign Out");
		signOut.setFocusable(true);
		signOut.addMouseListener(this);
		signOut.setBounds(920, 30, 127, 23);
		signOut.setFont(new Font("Veranda", font.PLAIN, 16));
		this.add(signOut);

		

		//if the users log in was successful then they are brought to this page and LoggedIn is set to true
		this.setTitle("Titanfall Towers-Admin Home Screen");
		this.setResizable(false);
		this.setBackground(Color.gray);



		// Create the tab pages
		panel1 = new AdminManageBookingGUI();
		panel2 = new AdminManageRoomsGUI();
		panel3 = new AdminAddSpecialsGUI();
		panel4 = new AdminPrintReportsGUI(usersFirstName);
		panel5 = new AdminHelpGUI();
		panel6 = new AdminManageAccountGUI();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Manage Bookings", panel1);
		tabbedPane.addTab("Manage Rooms", panel2);
		tabbedPane.addTab("Add Specials", panel3);
		tabbedPane.addTab("Print Reports", panel4);
		tabbedPane.addTab("Help", panel5);
		tabbedPane.addTab("Manage Account", panel6);
		this.add(tabbedPane);
	}
	public String getUsersFirstName() {
		for (int i = 0; i < users.size(); i++) {

			if (usersID.equals(users.get(i).getUserID())) {
				usersFirstName = users.get(i).getfName();
			}
		}

		return usersFirstName;
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		StartScreenGUI s = new StartScreenGUI();
		setVisible(false);
		s.setVisible(true);
		s.setLoggedIn(false);

	}


	public void mouseEntered(MouseEvent e) {

		signOut.setForeground(color);
	}

	public void mouseExited(MouseEvent e) {

		signOut.setForeground(color.BLACK);
	}

	public void mousePressed(MouseEvent e) {
		signOut.setForeground(Color.BLUE);

	}

	public void mouseReleased(MouseEvent arg0) {
		signOut.setForeground(Color.BLUE);

	}

}
