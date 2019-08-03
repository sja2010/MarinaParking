package psu.edu.IST311.TeamProject;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CBMDataAccess {
	
	static final String DB_URL = "jdbc:ucanaccess://C:/Users/Yadav Sapkota/MarinaDB.accdb";
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement insertCustomer = null;
	PreparedStatement searchCustomerByEmail = null;
	PreparedStatement updateCustomerInfo = null;
	PreparedStatement trackBoatByCustomerID = null;
	PreparedStatement trackSlipByBoatID = null;
	PreparedStatement searchBoatByPlate = null;
	PreparedStatement insertBoat = null;
	PreparedStatement insertSlip = null;
	PreparedStatement searchSlipBySlipNum = null;
	PreparedStatement updateBoatInfo = null;
	PreparedStatement updateSlipStatus = null;
	PreparedStatement checkSlipStatus = null;
	PreparedStatement updateSlipInfo = null;
	PreparedStatement updateSlip = null;

public CBMDataAccess(){
	try
	{
		connection = DriverManager.getConnection(DB_URL);
		statement = connection.createStatement();
		
	}
	catch(SQLException exp){
		
		JOptionPane.showMessageDialog(null, exp.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);	
	}
	
}

// Search Customer - Tika Sapkota
public ResultSet searchCustomer(String emailAddress){
	try
	{
		searchCustomerByEmail = connection.prepareStatement("SELECT CustomerID, FirstName, MiddleInitial, LastName, Street, City, State, ZipCode, PhoneNumber, EmailAddress  FROM Customer WHERE EmailAddress = ?");
		searchCustomerByEmail.setString(1, emailAddress);
	
		resultSet = searchCustomerByEmail.executeQuery();
		
		return resultSet;
		
	}
	catch(SQLException sqlex){
		
		JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Database search failed", JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}

// End Search Customer 

//Add Customer - Tika Sapkota
public int addCustomer(String fName, String MI, String lName, String streetAdd, String city, String state, String zipCode, String phone, String email) {

	int result = 0;

	try {

		insertCustomer = connection.prepareStatement(
				"INSERT INTO Customer (FirstName, MiddleInitial, LastName, Street, City, State, ZipCode, PhoneNumber, EmailAddress) VALUES (?,?,?,?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		insertCustomer.setString(1, fName);
		insertCustomer.setString(2, MI);
		insertCustomer.setString(3, lName);
		insertCustomer.setString(4, streetAdd);
		insertCustomer.setString(5, city);
		insertCustomer.setString(6, state);
		insertCustomer.setString(7, zipCode);
		insertCustomer.setString(8, phone);
		insertCustomer.setString(9, email);

		result = insertCustomer.executeUpdate();
		
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database insert failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return result;
}

//End Add Customer

//Update customer info - Tika Sapkota
public ResultSet updateCustomer(int customerID, String fName, String MI, String lName, String streetAdd, String city, String state, String zipCode, String phone) {

int result = 0;
	try {
		
		updateCustomerInfo = connection.prepareStatement("UPDATE Customer SET FirstName = '"+fName+"', MiddleInitial ='"+MI +"', LastName ='"+lName +"', Street = '"+streetAdd+"', City='"+city+"', State = '"+state+"', ZipCode = '"+zipCode+"', PhoneNumber = '"+phone+"' WHERE CustomerID = '"+customerID+"'");
		result = updateCustomerInfo.executeUpdate();
		
		if(result == 1)
		{
			
			JOptionPane.showMessageDialog(null, "Record Update Complete", lName, JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(result ==0)
		{
			
			JOptionPane.showMessageDialog(null, "Record Update Failed", lName, JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database update failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}

//End Update customer info


//Track Boat - Tika Sapkota

public ResultSet trackBoat(int customerID){
	try
	{
		trackBoatByCustomerID = connection.prepareStatement("SELECT CustomerID, BoatID, PlateNum, BoatType, "
				+ "BoatMake, BoatModel, MakeYear FROM Customer INNER JOIN Boat ON Customer.CustomerID = Boat.CustomerID "
				+ "WHERE Boat.CustomerID = '"+customerID+"'"); 
	
		resultSet = trackBoatByCustomerID.executeQuery();
	
		return resultSet;
		
	}
	catch(SQLException sqlex){
		
		JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Database search failed", JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}
//End Track Boat

//Track slip - Tika Sapkota
public ResultSet trackSlip(int boatID){
	try
	{

		trackSlipByBoatID = connection.prepareStatement("SELECT Boat.CustomerID, Boat.BoatID, Boat.PlateNum,"
				+ "ParkingSlip.LeaseType, ParkingSlip.DateFrom, ParkingSlip.DateTo, ParkingSlip.SlipNum FROM Boat INNER JOIN ParkingSlip ON Boat.BoatID = ParkingSlip.BoatID "
				+ "WHERE Boat.BoatID = '"+boatID+"'"); 
		
		resultSet = trackSlipByBoatID.executeQuery();
		return resultSet;
		
	}
	catch(SQLException sqlex){
		
		JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Database search failed", JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}

//End Track Slip

// Search Boat - Tika Sapkota

public ResultSet searchBoat(String plateNum)
{
	try
	{
		searchBoatByPlate = connection.prepareStatement("SELECT BoatID, CustomerID, PlateNum, BoatType, BoatMake, BoatModel, MakeYear FROM  Customer JOIN Boat ON Customer.CustomerID = Boat.CustomerID WHERE PlateNum = ?");
		searchBoatByPlate.setString(1, plateNum);
	
		resultSet = searchBoatByPlate.executeQuery();
		
		return resultSet;
		
	}
	catch(SQLException sqlex){
		
		JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Database search failed", JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;

}

//End Search Boat - Tika Sapkota

//Add Boat - Tika Sapkota

public int addBoat(int custID, String plateNum, String bType, String bMake, String bModel, String bYear) {

	int result = 0;

	try {

		insertBoat = connection.prepareStatement("INSERT INTO Boat (CustomerID, PlateNum, BoatType, BoatMake, BoatModel, MakeYear) VALUES (?,?,?,?,?,?)",
		Statement.RETURN_GENERATED_KEYS);
		insertBoat.setInt(1, custID);
		insertBoat.setString(2, plateNum);
		insertBoat.setString(3, bType);
		insertBoat.setString(4, bMake);
		insertBoat.setString(5, bModel);
		insertBoat.setString(6, bYear);
		
		result = insertBoat.executeUpdate();


	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database insert failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return result;
}

//End Add Boat

//Assign Slip --Tika Sapkota
public int assignSlip(int boatID, String slipNum, String plateNum, String leaseType,  String startDate, String endDate) {
	int result = 0;

	try {
			
		insertSlip = connection.prepareStatement(
				"INSERT INTO ParkingSlip (BoatID, SlipNum, PlateNum, LeaseType, DateFrom, DateTo) VALUES (?,?,?,?,?,?)",
				Statement.RETURN_GENERATED_KEYS);
		insertSlip.setInt(1, boatID);
		insertSlip.setString(2, slipNum);
		insertSlip.setString(3, plateNum);	
		insertSlip.setString(4, leaseType);
		insertSlip.setString(5, startDate);
		insertSlip.setString(6, endDate);
		result = insertSlip.executeUpdate();	
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database insert failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return result;
}

public ResultSet updateSlipInfo (int slipID, String slipNum, String leaseType,  String startDate, String endDate) { 
int result = 0;
	try {
		
		updateSlipInfo = connection.prepareStatement("UPDATE ParkingSlip SET  SlipNum ='"+slipNum +"', LeaseType = '"+leaseType+"', DateFrom='"+startDate+"', DateTo = '"+endDate+"' WHERE SlipID = '"+slipID+"'");
		result = updateSlipInfo.executeUpdate();
		
		if(result == 1)
		{
			
			JOptionPane.showMessageDialog(null, "Record Update Complete", slipNum, JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(result ==0)
		{
			
			JOptionPane.showMessageDialog(null, "Record Update Failed", slipNum, JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database update failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}

//End Assign Slip

//Search Slip by slipnum - Tika Sapkota
public ResultSet searchSlip(String slipNum)
{
	try
	{
		searchSlipBySlipNum = connection.prepareStatement("SELECT Boat.CustomerID, Boat.BoatID, Boat.PlateNum, ParkingSlip.SlipID, ParkingSlip.LeaseType, ParkingSlip.DateFrom, ParkingSlip.DateTo, ParkingSlip.SlipNum FROM  Boat JOIN ParkingSlip ON Boat.BoatID = ParkingSlip.BoatID WHERE ParkingSlip.SlipNum ='"+slipNum+"'");
		//searchSlipBySlipNum.setString(1, slipNum);
		resultSet = searchSlipBySlipNum.executeQuery();
		
		return resultSet;
		
	}
	catch(SQLException sqlex){
		
		JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Database search failed", JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;

}

//End Search Slip by slipnum

// Update Boat - Sagar Acharya
public ResultSet updateBoat (int boatID, String plateNum, String bType, String bMake, String bModel, String bYear) { 

int result = 0;
	try {
		
		updateBoatInfo = connection.prepareStatement("UPDATE Boat SET  PlateNum ='"+plateNum +"', BoatType = '"+bType+"', BoatMake='"+bMake+"', BoatModel = '"+bModel+"', MakeYear = '"+bYear+"' WHERE BoatID = '"+boatID+"'");
		result = updateBoatInfo.executeUpdate();
		
		if(result == 1)
		{
			
			JOptionPane.showMessageDialog(null, "Record Update Complete", plateNum, JOptionPane.INFORMATION_MESSAGE);
		}
		
		else if(result ==0)
		{
			
			JOptionPane.showMessageDialog(null, "Record Update Failed", plateNum, JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database update failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}
//End Update Boat


public ResultSet updateSlipStatus (String slipNum, String plateNum) { 

int result = 0;
	try {
		
		updateSlipStatus = connection.prepareStatement("UPDATE SlipStatus SET  SlipStatus = 'Leased', PlateNum = '"+plateNum+"' WHERE SlipNum = '"+slipNum+"'");
		result = updateSlipStatus.executeUpdate();
	
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database update failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}


public ResultSet ChangeSlipStatus (String slipNum, String plateNum) { 

int result = 0;
	try {
		
		updateSlip = connection.prepareStatement("UPDATE SlipStatus SET  SlipStatus = 'Available', PlateNum = NULL WHERE SlipNum = '"+slipNum+"'");
		result = updateSlip.executeUpdate();
		
		
	} catch (SQLException sqlex) {
		JOptionPane.showMessageDialog(null, sqlex.getMessage(), "Database update failed",
				JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}


public ResultSet viewSlips() {
	try {
		checkSlipStatus = connection.prepareStatement("SELECT * FROM SlipStatus");
		resultSet = checkSlipStatus.executeQuery();
		return resultSet;
		
	}	
catch(SQLException sqlex){
		
		JOptionPane.showMessageDialog(null,sqlex.getMessage(), "Search failed", JOptionPane.ERROR_MESSAGE);
	}
	return resultSet;
}

public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {
    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}

	
}