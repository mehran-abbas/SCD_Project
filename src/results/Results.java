package results;

import net.proteanit.sql.*;
import teacher.TeachersMenu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import admin.AdminMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Results extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	public Results(String UserName,String QuizID)
	{
		setResizable(false);
		setTitle("Result");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 533, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblResult = new JLabel("Results :");
		lblResult.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblResult.setBounds(25, 11, 72, 31);
		contentPane.add(lblResult);
		
		JButton btnGb = new JButton("Go Back");
		if(UserName.equals("Administrator"))
		{
		btnGb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AdminMenu amnMnu = new AdminMenu();
				amnMnu.setVisible(true);
			}
			
		});
		}
		else
		{
			btnGb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					TeachersMenu tchMnu = new TeachersMenu();
					tchMnu.setVisible(true);
				}
				
			});
			
		}
		btnGb.setBounds(407, 321, 89, 23);
		contentPane.add(btnGb);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 53, 446, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				
				
				));
			
		scrollPane.setColumnHeaderView(table);
		
		table_1 = new JTable();
		
table_1.setModel(new DefaultTableModel(
				
				
				));
			
scrollPane.setViewportView(table_1);
		
	
		
		showResults(QuizID);
	}
	
	public void showResults(String QuizID)
	{
	String query = "SELECT * FROM Result_"+QuizID;
		String databaseURL = "jdbc:ucanaccess://QuizManagementSystem.accdb";
		

		try (Connection connection = DriverManager.getConnection(databaseURL)) {
			
			Statement prpStm = connection.createStatement();
			ResultSet rs = prpStm.executeQuery(query);
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
			
			System.out.println("ResultsFetched");

		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}
