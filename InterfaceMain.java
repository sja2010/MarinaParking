package psu.edu.IST311.TeamProject;


import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class InterfaceMain extends JFrame
{
	JTabbedPane tabbedPane = new JTabbedPane();
	private JPanel 	panelA = new JPanel(),
					panelB = new JPanel(),
					panelC = new JPanel();
	
	private ActionListener listener;
	private CBMDataAccess db = new CBMDataAccess();
	
	
	private ResultSet resultSet = null;
	
	/*** CUSTOMER TAB**************************************TIKA SAPKOTA****************/
	
	private final JLabel lblSearchCustomer = new JLabel("Enter customer's email address");
	private JTextField tfSearchCustomer;
	private final JLabel lblFirstName = new JLabel("First Name");
	private final JTextField tfFirstName = new JTextField();
	private final JLabel lblMI = new JLabel("Middle Initial");
	private final JTextField tfMI = new JTextField();
	private final JLabel lblLastName = new JLabel("Last Name");
	private final JTextField tfLastName = new JTextField();
	private final JLabel lblStreetAddress = new JLabel("Street Address");
	private final JTextField tfStreetAddress = new JTextField();
	private final JLabel lblCity = new JLabel("City");
	private final JTextField tfCity = new JTextField();
	private final JLabel lblState = new JLabel("State");
	private final JTextField tfState = new JTextField();
	private final JLabel lblZipcode = new JLabel("Zipcode");
	private final JTextField tfZipCode = new JTextField();
	private final JLabel lblPhoneNumber = new JLabel("Phone Number");
	private final JTextField tfPhoneNumber = new JTextField();
	private final JLabel lblEmailAddress = new JLabel("E-mail");
	public  JTextField tfEmailAddress= new JTextField();
	private final JButton btnAddNewCustomer = new JButton("ADD");
	private final JButton btnUpdateCustomer = new JButton("Udate Customer Info");
	private final JButton btnManageBoats = new JButton("View/Manage Boat(s)");	
	private final JButton btnSearchCustomer = new JButton("SEARCH");
	private final JButton btnClearFields = new JButton("CLEAR");
	private final JComboBox leaseTypeCmbBox;
	private final JButton btnSearchSlip = new JButton("SEARCH");
	
	/*** BOAT TAB***************************************SAGAR ACHARYA**********************/
	private JTextField TFSearchBoatID;	
	private final JLabel lblBoatType = new JLabel("Boat Type");
	private final JTextField TFBoatType = new JTextField();
	private final JLabel lblBoatMake = new JLabel("Boat Make");
	private final JTextField TFBoatMake = new JTextField();
	private final JLabel lblBoatModel = new JLabel("Boat Model");
	private final JTextField TFBoatModel = new JTextField();
	private final JLabel lblYear = new JLabel("Year");
	private final JTextField TFYear = new JTextField();
	private final JLabel lblOwnerIDBoat = new JLabel("Customer ID");
	private final JTextField TFOwnerIDBoat = new JTextField();
	private final JButton btnRegisterBoat = new JButton("Register");
	private final JButton btnUpdateBoat = new JButton("UPDATE");
	private final JButton btnManageSlips = new JButton("MANAGE SLIP(S)");
	private final JButton btnSearchBoat = new JButton("SEARCH");
	private final JButton btnClearBoatFields = new JButton("Clear");
	
	/*** SLIP TAB***************************************ANIL NEUPANE********************/
	private JTextField TFSearchSlipNumber;
	private final JTextField TFBoatID = new JTextField();
	private final JLabel lblBoatID = new JLabel("Boat ID");
	private final JTextField TFFrom = new JTextField();
	private final JLabel lblFrom = new JLabel("Date From");
	private final JTextField TFTo = new JTextField();
	private final JLabel lblTo = new JLabel("Date To");
	private final JTextField TFSlipNumber = new JTextField();
	private final JLabel lblSlipNumber = new JLabel("Slip Number");
	private final JButton btnAssignSlip = new JButton("Assign Slip");
	private final JButton btnUpdateSlip = new JButton("Update/Change Slip");
	private final JButton btnDoneSlip = new JButton("Exit");
	private final JButton btnViewSlips = new JButton("Check Slip Status");
	private JTextField tfCustomerID;
	private final JLabel lblDisplayBoatID = new JLabel("Boat ID");
	private final JTextField tfBoatID = new JTextField();
	private final JLabel lblLeaseType = new JLabel("Slip Lease Type");
	private final JLabel lblLicensePlate = new JLabel("License Plate Num");
	private final JLabel lblBoatPlate = new JLabel("Boat Plate Num");
	private final JTextField tfPlateNum = new JTextField();
	private JTextField tfDisplayLicensePlate;
	private JTextField TFOwnerIDSlip;
	private JTable jtblSlip;
	private final JButton btnClearSlipInfo = new JButton("Clear");
	private JTextField tfSlipID;

	public InterfaceMain()
	{
		this.setSize(1000,1000);
		tfPlateNum.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfPlateNum.setBounds(372, 267, 155, 25);
		tfPlateNum.setColumns(10);
		
		/*************CUSTOMER TAB CODE ***************TIKA***********/
		tfEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfEmailAddress.setBounds(359, 543, 170, 25);
		tfEmailAddress.setColumns(10);
		tfPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfPhoneNumber.setBounds(359, 507, 170, 25);
		tfPhoneNumber.setColumns(10);
		tfZipCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfZipCode.setBounds(359, 471, 132, 25);
		tfZipCode.setColumns(10);
		tfState.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfState.setBounds(359, 435, 132, 25);
		tfState.setColumns(10);
		tfCity.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfCity.setBounds(359, 399, 132, 25);
		tfCity.setColumns(10);
		tfStreetAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfStreetAddress.setBounds(359, 363, 235, 25);
		tfStreetAddress.setColumns(10);
		tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfLastName.setBounds(359, 327, 155, 25);
		tfLastName.setColumns(10);
		tfMI.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfMI.setBounds(359, 291, 72, 25);
		tfMI.setColumns(10);
		tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfFirstName.setBounds(359, 255, 155, 25);
		tfFirstName.setColumns(10);
		tfCustomerID = new JTextField();
		JLabel lblCustomerID = new JLabel("Customer ID");
		setTitle("CBM Boat and Parking Slip");
		panelA.setLayout(null);
		tabbedPane.addTab("Customer",  null, panelA, "Customer Information");
		panelA.setBackground(new Color(135, 206, 235)); //41,128,185))
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(125, 11, 735, 49);
		panelA.add(panel);
		
		JLabel lblCustomerTitle = new JLabel("Chesapeake Bay Marina");
		lblCustomerTitle.setForeground(new Color(255, 255, 255));
		lblCustomerTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblCustomerTitle);
		lblSearchCustomer.setFont(new Font("Arial", Font.BOLD, 16));
		lblSearchCustomer.setForeground(Color.BLACK);
		lblSearchCustomer.setBounds(155, 99, 253, 36);
		
		panelA.add(lblSearchCustomer);
		
		tfSearchCustomer = new JTextField();
		tfSearchCustomer.setForeground(Color.BLUE);
		tfSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tfSearchCustomer.setBounds(403, 100, 210, 36);
		panelA.add(tfSearchCustomer);
		tfSearchCustomer.setColumns(10);
		
		btnSearchCustomer.setFont(new Font("Arial", Font.BOLD, 16));
		btnSearchCustomer.setBounds(623, 99, 103, 36);
		panelA.add(btnSearchCustomer);
		
		lblCustomerID.setFont(new Font("Arial", Font.BOLD, 16));
		lblCustomerID.setBounds(231, 219, 110, 14);
		panelA.add(lblCustomerID);
		
		tfCustomerID.setEditable(false);
		tfCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfCustomerID.setBounds(359, 215, 72, 25);
		panelA.add(tfCustomerID);
		tfCustomerID.setColumns(10);
		
		lblFirstName.setFont(new Font("Arial", Font.BOLD, 16));
		lblFirstName.setBounds(231, 255, 82, 25);
		
		panelA.add(lblFirstName);
		
		panelA.add(tfFirstName);
		lblMI.setFont(new Font("Arial", Font.BOLD, 16));
		lblMI.setBounds(231, 291, 103, 25);
		
		panelA.add(lblMI);
		
		panelA.add(tfMI);
		lblLastName.setFont(new Font("Arial", Font.BOLD, 16));
		lblLastName.setBounds(231, 327, 110, 25);
		
		panelA.add(lblLastName);
		
		panelA.add(tfLastName);
		lblStreetAddress.setFont(new Font("Arial", Font.BOLD, 16));
		lblStreetAddress.setBounds(231, 363, 122, 25);
		
		panelA.add(lblStreetAddress);
		
		panelA.add(tfStreetAddress);
		lblCity.setFont(new Font("Arial", Font.BOLD, 16));
		lblCity.setBounds(231, 399, 46, 25);
		
		panelA.add(lblCity);
		
		panelA.add(tfCity);
		lblState.setFont(new Font("Arial", Font.BOLD, 16));
		lblState.setBounds(231, 435, 46, 25);
		
		panelA.add(lblState);
		
		panelA.add(tfState);
		lblZipcode.setFont(new Font("Arial", Font.BOLD, 16));
		lblZipcode.setBounds(231, 471, 72, 25);
		
		panelA.add(lblZipcode);
		
		panelA.add(tfZipCode);
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 16));
		lblPhoneNumber.setBounds(231, 507, 122, 25);
		
		panelA.add(lblPhoneNumber);
		
		panelA.add(tfPhoneNumber);
		lblEmailAddress.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmailAddress.setBounds(231, 543, 103, 25);
		
		panelA.add(lblEmailAddress);
		
		panelA.add(tfEmailAddress);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(253, 620, 1, 2);
		panelA.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(125, 159, 735, 13);
		panelA.add(separator_1);
		btnAddNewCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAddNewCustomer.setBounds(355, 579, 72, 36);
		
		panelA.add(btnAddNewCustomer);
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdateCustomer.setBounds(224, 650, 212, 36);
		
		panelA.add(btnUpdateCustomer);

		btnManageBoats.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnManageBoats.setBounds(447, 650, 221, 36);
		
		panelA.add(btnManageBoats);
		
		
		btnClearFields.setFont(new Font("Tahoma", Font.BOLD, 14));

		btnClearFields.setBounds(440, 579, 89, 36);
		panelA.add(btnClearFields);
		
		JButton btnLogout = new JButton("Logout");
		
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	
				Login login =new Login();
				login.setVisible(true);
				login.setSize(1000,1000);
				login.setLocationRelativeTo(null);
				dispose();
	
			}
		});
		
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(740, 178, 82, 25);
		panelA.add(btnLogout);
		

		
		/*************END CUSTOMER TAB CODE **************************/

		
		/*************BOAT TAB CODE ************SAGAR**************/
		
		tabbedPane.setTabPlacement(SwingConstants.TOP);
		getContentPane().add(tabbedPane);
		

		panelB.setLayout(null);
		panelB.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Boat ", null, panelB, "Boat Management");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 128));
		panel_1.setBounds(125, 11, 735, 49);
		panelB.add(panel_1);
		
		JLabel lblBoatTitle = new JLabel("Chesapeake Bay Marina");
		lblBoatTitle.setForeground(new Color(255, 255, 255));
		lblBoatTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_1.add(lblBoatTitle);
		
		JLabel lblEnterBoatID = new JLabel("Enter Customer's Boat License Plate Number");
		lblEnterBoatID.setForeground(Color.BLACK);
		lblEnterBoatID.setFont(new Font("Arial", Font.BOLD, 16));
		lblEnterBoatID.setBounds(126, 101, 351, 36);
		panelB.add(lblEnterBoatID);
		
		TFSearchBoatID = new JTextField();
		TFSearchBoatID.setForeground(Color.BLUE);
		TFSearchBoatID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFSearchBoatID.setColumns(10);
		TFSearchBoatID.setBounds(487, 101, 210, 36);
		panelB.add(TFSearchBoatID);
		
		
		btnSearchBoat.setFont(new Font("Arial", Font.BOLD, 16));
		btnSearchBoat.setBounds(707, 100, 103, 36);
		panelB.add(btnSearchBoat);
		lblBoatType.setFont(new Font("Arial", Font.BOLD, 16));
		lblBoatType.setBounds(225, 297, 82, 25);
		
		panelB.add(lblBoatType);
		TFBoatType.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFBoatType.setColumns(10);
		TFBoatType.setBounds(372, 298, 155, 25);
		
		panelB.add(TFBoatType);
		lblBoatMake.setFont(new Font("Arial", Font.BOLD, 16));
		lblBoatMake.setBounds(225, 334, 82, 25);
		
		panelB.add(lblBoatMake);
		TFBoatMake.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFBoatMake.setColumns(10);
		TFBoatMake.setBounds(372, 334, 155, 25);
		
		panelB.add(TFBoatMake);
		lblBoatModel.setFont(new Font("Arial", Font.BOLD, 16));
		lblBoatModel.setBounds(225, 370, 110, 25);
		
		panelB.add(lblBoatModel);
		TFBoatModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFBoatModel.setColumns(10);
		TFBoatModel.setBounds(372, 370, 155, 25);
		
		panelB.add(TFBoatModel);
		lblYear.setFont(new Font("Arial", Font.BOLD, 16));
		lblYear.setBounds(225, 406, 97, 25);
		
		panelB.add(lblYear);
		TFYear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFYear.setColumns(10);
		TFYear.setBounds(372, 406, 155, 25);
		
		panelB.add(TFYear);
		lblOwnerIDBoat.setFont(new Font("Arial", Font.BOLD, 16));
		lblOwnerIDBoat.setBounds(225, 230, 97, 25);
		
		panelB.add(lblOwnerIDBoat);
		TFOwnerIDBoat.setEditable(false);
		TFOwnerIDBoat.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFOwnerIDBoat.setColumns(10);
		TFOwnerIDBoat.setBounds(372, 230, 155, 25);
		
		panelB.add(TFOwnerIDBoat);
		btnRegisterBoat.setFont(new Font("Arial", Font.BOLD, 16));
		btnRegisterBoat.setBounds(334, 459, 110, 36);
		
		panelB.add(btnRegisterBoat);
		btnUpdateBoat.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdateBoat.setBounds(243, 575, 110, 36);
		
		panelB.add(btnUpdateBoat);	
		
		btnManageSlips.setFont(new Font("Arial", Font.BOLD, 16));
		btnManageSlips.setBounds(372, 575, 174, 36);
		
		panelB.add(btnManageSlips);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(125, 159, 735, 13);
		panelB.add(separator_2);
		tfBoatID.setEditable(false);
		
		tfBoatID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfBoatID.setBounds(372, 194, 155, 25);
		tfBoatID.setColumns(10);
		
		lblDisplayBoatID.setFont(new Font("Arial", Font.BOLD, 16));
		lblDisplayBoatID.setBounds(225, 194, 110, 25);
		
		panelB.add(lblDisplayBoatID);
		
		panelB.add(tfBoatID);
		lblBoatPlate.setFont(new Font("Arial", Font.BOLD, 16));
		lblBoatPlate.setBounds(225, 266, 128, 25);
		
		panelB.add(lblBoatPlate);
		
		panelB.add(tfPlateNum);
		
		
		btnClearBoatFields.setFont(new Font("Arial", Font.BOLD, 16));
		btnClearBoatFields.setBounds(454, 459, 92, 36);
		panelB.add(btnClearBoatFields);
		
		/*************END BOAT TAB CODE **************************/
	
		
		/*************SLIP TAB CODE ****************ANIL*************/
		
		panelC.setBackground(new Color(135, 206, 235));
		tabbedPane.addTab("Slip", null, panelC, "Slip Assignment");
		panelC.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 128));
		panel_2.setBounds(125, 11, 735, 49);
		panelC.add(panel_2);
		
		JLabel lblSlipTitle = new JLabel("Chesapeake Bay Marina");
		lblSlipTitle.setForeground(new Color(255, 255, 255));
		lblSlipTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel_2.add(lblSlipTitle);
		
		JLabel lblEnterSlipNumber = new JLabel("Enter Slip Number");
		lblEnterSlipNumber.setForeground(Color.BLACK);
		lblEnterSlipNumber.setFont(new Font("Arial", Font.BOLD, 16));
		lblEnterSlipNumber.setBounds(145, 78, 203, 36);
		panelC.add(lblEnterSlipNumber);
		
		TFSearchSlipNumber = new JTextField();
		TFSearchSlipNumber.setForeground(Color.BLUE);
		TFSearchSlipNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TFSearchSlipNumber.setColumns(10);
		TFSearchSlipNumber.setBounds(138, 112, 210, 36);
		panelC.add(TFSearchSlipNumber);
		
		
		btnSearchSlip.setFont(new Font("Arial", Font.BOLD, 16));
		btnSearchSlip.setBounds(387, 111, 103, 36);
		panelC.add(btnSearchSlip);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(125, 159, 735, 13);
		panelC.add(separator_3);
		TFBoatID.setEditable(false);
		TFBoatID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFBoatID.setColumns(10);
		TFBoatID.setBounds(372, 238, 155, 25);
		
		panelC.add(TFBoatID);
		lblBoatID.setFont(new Font("Arial", Font.BOLD, 16));
		lblBoatID.setBounds(210, 240, 82, 25);
		
		panelC.add(lblBoatID);
		TFFrom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFFrom.setColumns(10);
		TFFrom.setBounds(372, 372, 118, 25);
		
		panelC.add(TFFrom);
		lblFrom.setFont(new Font("Arial", Font.BOLD, 16));
		lblFrom.setBounds(210, 371, 82, 25);
		
		panelC.add(lblFrom);
		TFTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFTo.setColumns(10);
		TFTo.setBounds(578, 372, 118, 25);
		
		panelC.add(TFTo);
		lblTo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTo.setBounds(506, 372, 62, 25);
		
		panelC.add(lblTo);
		TFSlipNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TFSlipNumber.setColumns(10);
		TFSlipNumber.setBounds(372, 408, 155, 25);
		
		panelC.add(TFSlipNumber);
		lblSlipNumber.setFont(new Font("Arial", Font.BOLD, 16));
		lblSlipNumber.setBounds(210, 407, 103, 25);
		
		panelC.add(lblSlipNumber);	
		
		btnAssignSlip.setFont(new Font("Arial", Font.BOLD, 16));
		btnAssignSlip.setBounds(372, 459, 155, 36);
		
		panelC.add(btnAssignSlip);
		btnUpdateSlip.setFont(new Font("Arial", Font.BOLD, 16));
		btnUpdateSlip.setBounds(210, 605, 191, 36);
		
		panelC.add(btnUpdateSlip);
		btnDoneSlip.setFont(new Font("Arial", Font.BOLD, 16));
		btnDoneSlip.setBounds(588, 605, 77, 36);
		
		panelC.add(btnDoneSlip);
		lblLeaseType.setFont(new Font("Arial", Font.BOLD, 16));
		lblLeaseType.setBounds(210, 324, 141, 25);
		
		panelC.add(lblLeaseType);
		String LeaseTypes[] = { "", "Hourly", "Daily", "Weekly", "Monthly", "Seasonal", "Other"};
		leaseTypeCmbBox = new JComboBox(LeaseTypes);
	
		leaseTypeCmbBox.setToolTipText("Select a Lease Type");
		leaseTypeCmbBox.setEditable(true);
		leaseTypeCmbBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		leaseTypeCmbBox.setBounds(372, 327, 155, 25);
		panelC.add(leaseTypeCmbBox);
		lblLicensePlate.setFont(new Font("Arial", Font.BOLD, 16));
		lblLicensePlate.setBounds(210, 280, 155, 25);
		
		panelC.add(lblLicensePlate);
		
		tfDisplayLicensePlate = new JTextField();
		tfDisplayLicensePlate.setEditable(false);
		tfDisplayLicensePlate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tfDisplayLicensePlate.setBounds(372, 280, 155, 25);
		panelC.add(tfDisplayLicensePlate);
		tfDisplayLicensePlate.setColumns(10);
		
		JLabel lblOwnerID = new JLabel("Customer ID");
		lblOwnerID.setFont(new Font("Arial", Font.BOLD, 16));
		lblOwnerID.setBounds(210, 206, 117, 14);
		panelC.add(lblOwnerID);
		
		TFOwnerIDSlip = new JTextField();
		TFOwnerIDSlip.setEditable(false);
		TFOwnerIDSlip.setBounds(372, 195, 155, 25);
		panelC.add(TFOwnerIDSlip);
		TFOwnerIDSlip.setColumns(10);
		
	
		btnClearSlipInfo.setFont(new Font("Arial", Font.BOLD, 16));
		btnClearSlipInfo.setBounds(459, 605, 89, 36);
		panelC.add(btnClearSlipInfo);
		
		
		btnViewSlips.setFont(new Font("Arial", Font.BOLD, 16));
		btnViewSlips.setBounds(649, 111, 196, 36);
		panelC.add(btnViewSlips);
		
		jtblSlip = new JTable();
		jtblSlip.setBounds(818, 206, 10, 1);
		panelC.add(jtblSlip);
		
		tfSlipID = new JTextField();
		tfSlipID.setEnabled(false);
		tfSlipID.setEditable(false);
		tfSlipID.setVisible(false);
		tfSlipID.setBounds(372, 167, 86, 20);
		panelC.add(tfSlipID);
		tfSlipID.setColumns(10);
		
		/*************END SLIP TAB CODE **************************/
		
		listener = new ChoiceListener();
		btnSearchCustomer.addActionListener(listener);
		btnAddNewCustomer.addActionListener(listener);
		btnUpdateCustomer.addActionListener(listener);
		btnClearFields.addActionListener(listener);
		btnManageBoats.addActionListener(listener);
		btnSearchBoat.addActionListener(listener);
		btnClearBoatFields.addActionListener(listener);
		btnRegisterBoat.addActionListener(listener);
		btnAssignSlip.addActionListener(listener);
		btnManageSlips.addActionListener(listener);
		btnSearchSlip.addActionListener(listener);
		btnUpdateBoat.addActionListener(listener);
		btnViewSlips.addActionListener(listener);
		btnClearSlipInfo.addActionListener(listener);
		btnDoneSlip.addActionListener(listener);
		btnUpdateSlip.addActionListener(listener);
	}
	
	class ChoiceListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			//CUSTOMER SEARCH 
			int databaseCustomerID = 0;
			if(event.getSource() == btnSearchCustomer)
			{
				
				String inputEmail = tfSearchCustomer.getText();
				resultSet = db.searchCustomer(inputEmail);			
				
			try{
				
				if(resultSet.next()){
				String databaseEmail = resultSet.getString("EmailAddress");					
					
				if(databaseEmail.equals(inputEmail))
				
				{
					JOptionPane.showMessageDialog(null, "The record found in the database. Click OK to continue", "Great !", JOptionPane.INFORMATION_MESSAGE);
					
					databaseCustomerID = resultSet.getInt("CustomerID");
					tfCustomerID.setText(String.valueOf(databaseCustomerID));
					tfFirstName.setText(resultSet.getString(2));
					tfMI.setText(resultSet.getString(3));
					tfLastName.setText(resultSet.getString(4));
					tfStreetAddress.setText(resultSet.getString(5));
					tfCity.setText(resultSet.getString(6));
					tfState.setText(resultSet.getString(7));
					tfZipCode.setText(resultSet.getString(8));
					tfPhoneNumber.setText(resultSet.getString(9));
					tfEmailAddress.setText(resultSet.getString(10));	
					}
				}
				
				if (resultSet.getRow()==0)
				{						
					JOptionPane.showConfirmDialog(null,  inputEmail +"'s" +" record does not exist. " + "Do you wish to add this customer?");
					tfFirstName.requestFocus();			
				}
				
			}
			catch(SQLException sqlex){
				
				JOptionPane.showMessageDialog(null,sqlex.getMessage(), "No results from search", JOptionPane.ERROR_MESSAGE);
			}	
		
		}	
			
			//ADD CUSTOMER - TIKA SAPKOTA
			if(event.getSource()==btnAddNewCustomer)
			{
				
				db.addCustomer(tfFirstName.getText(), tfMI.getText(), tfLastName.getText(), tfStreetAddress.getText(), tfCity.getText(), 
						tfState.getText(), tfZipCode.getText(), tfPhoneNumber.getText(), tfEmailAddress.getText());
				JOptionPane.showMessageDialog(null, "Customer Added Successfully ! ");
	
			}
			//END ADD CUSTOMER
			
		
			//UPDATE CUSTOMER -  TIKA SAPKOTA
			if(event.getSource()==btnUpdateCustomer)
			{
				try {
				databaseCustomerID = resultSet.getInt("CustomerID");
				tfCustomerID.setText(String.valueOf(databaseCustomerID));
				db.updateCustomer(databaseCustomerID, tfFirstName.getText(), tfMI.getText(), tfLastName.getText(), tfStreetAddress.getText(), tfCity.getText(), 
						tfState.getText(), tfZipCode.getText(), tfPhoneNumber.getText());
				
				tfEmailAddress.setEditable(false);
			
				}
				
				catch(SQLException sqlex){
					
					JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Something went wrong", JOptionPane.ERROR_MESSAGE);
				}	
				
			}
			//END UPDATE CUSTOMER
			
			//CLEAR CUSTOMER INFO -  TIKA SAPKOTA
			
			if(event.getSource()==btnClearFields) {
				
				clearControlsCustomer();
				
			}
			//END CLEAR CUSTOMER INFO
			
			
			//VIEW/MANAGE BOAt -  TIKA SAPKOTA
			
			if(event.getSource()==btnManageBoats)
			{													
					String customerID = tfCustomerID.getText();
					int custID = 0;
					try
					{
					    if(!customerID.equals(""))
					    	custID = Integer.parseInt(customerID);
					    
					}
					catch(NumberFormatException ex){ 
						ex.printStackTrace();   
					}
					
					resultSet = db.trackBoat(custID);
	
					try{
						if(resultSet.next())
						{
							databaseCustomerID = resultSet.getInt("CustomerID");
		
							if(custID == databaseCustomerID) 
							{
								JOptionPane.showMessageDialog(null, "Customer's boat info found. Click OK to continue", "", JOptionPane.INFORMATION_MESSAGE);
							
								databaseCustomerID = resultSet.getInt("CustomerID");
								TFOwnerIDBoat.setText(String.valueOf(databaseCustomerID));
								int boatID = resultSet.getInt("BoatID");	
								tfBoatID.setText(String.valueOf(boatID));
								tfPlateNum.setText(resultSet.getString("PlateNum"));
								TFBoatType.setText(resultSet.getString("BoatType"));
								TFBoatMake.setText(resultSet.getString("BoatMake"));
								TFBoatModel.setText(resultSet.getString("BoatModel"));
								TFYear.setText(resultSet.getString("MakeYear"));
							}
							tabbedPane.setSelectedIndex(1);
						}
						
						if(resultSet.getRow()==0 && !customerID.equals("") )
							{					
								JOptionPane.showMessageDialog(null, "Customer's boat info not available. Click OK to continue and register the boat.", "", JOptionPane.INFORMATION_MESSAGE);
								TFOwnerIDBoat.setText(String.valueOf(tfCustomerID.getText()));
								tfPlateNum.requestFocus();
								tabbedPane.setSelectedIndex(1);
							}
						 else if(customerID.equals("") )
					    	JOptionPane.showMessageDialog(null, "Please search to view and confirm the customer info before proceeding", "", JOptionPane.INFORMATION_MESSAGE);
						
						}				

					catch(SQLException sqlex){
						
						JOptionPane.showMessageDialog(null,sqlex.getMessage(), "An error Occured ! ", JOptionPane.ERROR_MESSAGE);
					}	
			}
			
			//END VIEW MANAGE BOAT

			//SEARCH BOAT BY PLATE# -  TIKA SAPKOTA
			if(event.getSource()==btnSearchBoat)
			{
				int boatID= 0;
				String inputPlateNum = TFSearchBoatID.getText();
				resultSet = db.searchBoat(inputPlateNum);
				try{
					
					if(resultSet.next()){
					String databasePlateNum = resultSet.getString("PlateNum");					
						
					if(databasePlateNum.equals(inputPlateNum))
					
						{
						JOptionPane.showMessageDialog(null, "The boat record found in the database.", "Great! ", JOptionPane.INFORMATION_MESSAGE);
								
						tfBoatID.setText(String.valueOf(resultSet.getInt("BoatID")));
						TFOwnerIDBoat.setText(String.valueOf(resultSet.getInt("CustomerID")));		
						tfPlateNum.setText(resultSet.getString("PlateNUm"));
						TFBoatType.setText(resultSet.getString("BoatType"));
						TFBoatMake.setText(resultSet.getString("BoatMake"));
						TFBoatModel.setText(resultSet.getString("BoatModel"));
						TFYear.setText(resultSet.getString("MakeYear"));	
						}
					}
					if (resultSet.getRow()==0)
					{							
						JOptionPane.showConfirmDialog(null,  inputPlateNum +"'s" +" record does not exist. " + "Do you wish to search another boat?");
						TFSearchBoatID.requestFocus();				
					}
				}
				
				catch(SQLException sqlex){
						JOptionPane.showMessageDialog(null,sqlex.getMessage(), "No results from search", JOptionPane.ERROR_MESSAGE);
					}	
			}
			//END SEARCH BOAT BY PLATE#
			
			//Add Boat -  TIKA SAPKOTA
			if(event.getSource() == btnRegisterBoat)
			{
				
				int ownerID = 0;
				try{
					ownerID = Integer.parseInt(TFOwnerIDBoat.getText());
				}
				catch(NumberFormatException ex)
				{ 
					ex.printStackTrace();
				}
			if(ownerID > 0)
			{
				 db.addBoat(ownerID, tfPlateNum.getText(), TFBoatType.getText(), TFBoatMake.getText(), TFBoatModel.getText(), TFYear.getText());
				 JOptionPane.showMessageDialog(null, "Boat Added Successfully ! Click on 'Manage Slip' button to assign/issue a parking slip. ");
				 }		
			else
				JOptionPane.showMessageDialog(null, "Boat owner information unavailable. You must have a boat owner before you can register it. "); 
					
			}
			
			//End Add Boat
			
			// Manage Slip -  TIKA SAPKOTA
			if(event.getSource()==btnManageSlips)
			{		
				String boatID = tfBoatID.getText();
				int boatIDNum = 0;
				int databaseBoatID = 0;
				try
				{
				    if(!boatID.equals(""))
				    	boatIDNum = Integer.parseInt(boatID);	    
				}
				catch(NumberFormatException ex){ 
					ex.printStackTrace();   
				}	
				resultSet = db.trackSlip(boatIDNum);
				
				try{	
						if(resultSet.next())
						{
							databaseBoatID = resultSet.getInt("BoatID");
							if(boatIDNum == databaseBoatID) 
							{
								JOptionPane.showMessageDialog(null, "An existing parking slip found ! Click Ok to view current slip info, to change or update the slip.", "", JOptionPane.INFORMATION_MESSAGE);
							
								databaseBoatID = resultSet.getInt("BoatID");
								TFBoatID.setText(String.valueOf(databaseBoatID));
								int customerID = resultSet.getInt("CustomerID");	
								TFOwnerIDSlip.setText(String.valueOf(customerID));
								tfDisplayLicensePlate.setText(resultSet.getString("PlateNum"));
								String leaseType = resultSet.getString("LeaseType");
								leaseTypeCmbBox.removeAllItems();
								leaseTypeCmbBox.addItem(leaseType);
								//Date dateFrom = resultSet.getDate("DateFrom"); //Note: Do not delete this line  !
								TFFrom.setText(resultSet.getString("DateFrom"));
								//Date dateTo = resultSet.getDate("DateTo"); //Note: Do not delete this line  !
								TFTo.setText(resultSet.getString("DateTo"));
								TFSlipNumber.setText(resultSet.getString("SlipNum"));
							}
							tabbedPane.setSelectedIndex(2);
						}	
					
							if(resultSet.getRow()==0 && !boatID.equals(""))
							{					
								JOptionPane.showMessageDialog(null, "Existing parking slip not found !  Click OK to continue and issue a slip to this boat.", "", JOptionPane.INFORMATION_MESSAGE);
								TFBoatID.setText(String.valueOf(tfBoatID.getText()));
								TFOwnerIDSlip.setText(TFOwnerIDBoat.getText());
								tfDisplayLicensePlate.setText(tfPlateNum.getText());
								leaseTypeCmbBox.requestFocus();
								tabbedPane.setSelectedIndex(2);
							}
	
							else if(boatID.equals("") )
						    	JOptionPane.showMessageDialog(null, "Please search using the boat's License Plate number to view and confirm the boat info before proceeding", "", JOptionPane.INFORMATION_MESSAGE);
					}
					
					catch(SQLException sqlex){
						
						JOptionPane.showMessageDialog(null,sqlex.getMessage(), "An error Occured ! ", JOptionPane.ERROR_MESSAGE);
					}	
	
			}
			
			// End Manage Slip
			
			//ASSIGN SLIP -  TIKA SAPKOTA
				
			if(event.getSource() == btnAssignSlip){
				
				int boatID = Integer.parseInt(TFBoatID.getText());
			
				if(boatID !=0)
					{	
						db.assignSlip(boatID, TFSlipNumber.getText(), tfDisplayLicensePlate.getText(), leaseTypeCmbBox.getSelectedItem().toString(), TFFrom.getText(), TFTo.getText());
						db.updateSlipStatus(TFSlipNumber.getText(),tfDisplayLicensePlate.getText());
						JOptionPane.showMessageDialog(null, "Parking slip assigned successfully !");
						
					}		
					else
						JOptionPane.showMessageDialog(null, "Boat information is missing. You must complete boat registration before assigning a parking slip to it."); 
			}
			
			//END ASSIGN SLIP
			
			

			if(event.getSource()==btnUpdateSlip)
			{
					int slipID = Integer.parseInt(tfSlipID.getText());
					db.updateSlipInfo(slipID, TFSlipNumber.getText(), leaseTypeCmbBox.getSelectedItem().toString(), TFFrom.getText(), TFTo.getText());
					db.ChangeSlipStatus(TFSlipNumber.getText(),tfDisplayLicensePlate.getText());
					db.updateSlipStatus(TFSlipNumber.getText(),tfDisplayLicensePlate.getText());

					//tfPlateNum.setEditable(false);			
			}

			//SEARCH SLIP BY SLIPNUM# -  TIKA SAPKOTA
			if(event.getSource()==btnSearchSlip)
			{
				String inputSlipNum = TFSearchSlipNumber.getText();
				resultSet = db.searchSlip(inputSlipNum);
				try{
					
					if(resultSet.next()){
					String databaseSlipNum = resultSet.getString("SlipNum");					
						
					if(databaseSlipNum.equals(inputSlipNum))
					
						{
							JOptionPane.showMessageDialog(null, "The parking slip found !", "Great !", JOptionPane.INFORMATION_MESSAGE);
							tfSlipID.setText(String.valueOf(resultSet.getInt("SlipID")));
							TFOwnerIDSlip.setText(String.valueOf(resultSet.getInt("CustomerID")));
							TFBoatID.setText(String.valueOf(resultSet.getInt("BoatID")));				
							tfDisplayLicensePlate.setText(resultSet.getString("PlateNum"));
							String leaseType = resultSet.getString("LeaseType");
							leaseTypeCmbBox.removeAllItems();
							leaseTypeCmbBox.addItem(leaseType);
							TFFrom.setText(resultSet.getString("DateFrom"));
							TFTo.setText(resultSet.getString("DateTo"));
							TFSlipNumber.setText(resultSet.getString("SlipNum"));	
						}
					}
					if (resultSet.getRow()==0)
					{							
						JOptionPane.showMessageDialog(null, "The record does not exist for slip number " +inputSlipNum + ".", "", JOptionPane.INFORMATION_MESSAGE);
						TFSearchSlipNumber.requestFocus();				
					}
				}
				
					catch(SQLException sqlex){
						
						JOptionPane.showMessageDialog(null,sqlex.getMessage(), "No results from search", JOptionPane.ERROR_MESSAGE);
					}	
			}
			
			//END SEARCH SLIP BY SLIPNUM#	
			
			if(event.getSource()==btnClearBoatFields) {
				clearControlsBoat();
			}
			

			//CLEAR SLIP
			if(event.getSource()==btnClearSlipInfo) {
				
				clearControlsSlip();	
			}
			
			//EXIT PROGRAM
			if(event.getSource()==btnDoneSlip) {
				
				clearControlsCustomer();
				clearControlsBoat();
				clearControlsSlip();
				tabbedPane.setSelectedIndex(0);
			}
			
			// Update Boat info - Sagar Acharya 
			if(event.getSource()==btnUpdateBoat)
			{
					int boatID = Integer.parseInt(tfBoatID.getText());
					db.updateBoat(boatID, tfPlateNum.getText(), TFBoatType.getText(), TFBoatMake.getText(), TFBoatModel.getText(), TFYear.getText());					
					//tfPlateNum.setEditable(false);			
			}
			
			//View Slips
			if(event.getSource()==btnViewSlips)
			{
				ResultSet rs= null;
				rs = db.viewSlips();
				try {
					jtblSlip = new JTable(db.buildTableModel(rs));
		
				} catch (SQLException e) {
	
					e.printStackTrace();
				}

			    // Closes the Connection

			    JOptionPane.showMessageDialog(null, new JScrollPane(jtblSlip), "CBM Parking Slip Status", JOptionPane.INFORMATION_MESSAGE);
			}
			
			// End update Boat info 
	}
		//clear fields -  TIKA SAPKOTA
		String empty = "";
		public void clearControlsCustomer()
		{
			
			tfSearchCustomer.setText(empty);
			tfCustomerID.setText(empty);
			tfFirstName.setText(empty);
			tfMI.setText(empty);
			tfLastName.setText(empty);
			tfStreetAddress.setText(empty);			
			tfCity.setText(empty);
			tfState.setText(empty);
			tfZipCode.setText(empty);
			tfPhoneNumber.setText(empty);
			tfEmailAddress.setText(empty);
		}
			
		public void clearControlsBoat()
		{			
			TFSearchBoatID.setText(empty);
			tfBoatID.setText(empty);
			TFOwnerIDBoat.setText(empty);		
			tfPlateNum.setText(empty);
			TFBoatType.setText(empty);
			TFBoatMake.setText(empty);
			TFBoatModel.setText(empty);
			TFYear.setText(empty);
		}
		
		public void clearControlsSlip()
		{			
			//TFSearchSlipNumber.setText(empty);
			TFOwnerIDSlip.setText(empty);
			TFBoatID.setText(empty);		
			tfDisplayLicensePlate.setText(empty);
			leaseTypeCmbBox.setSelectedItem(empty);
			TFBoatMake.setText(empty);
			TFFrom.setText(empty);
			TFTo.setText(empty);
			TFSlipNumber.setText(empty);
		}
		//End clear fields
	}
}
