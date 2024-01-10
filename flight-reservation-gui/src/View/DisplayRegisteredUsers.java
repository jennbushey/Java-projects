package View;

import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DisplayRegisteredUsers {
	
    public void displayRegisteredUsers(List<String> information) {
        
    	// Fetch flights from the database
        List<String> registeredUsers = information;

        //Create and populate the table
        Object[][] data = new Object[registeredUsers.size()][6];

        for (int i = 0; i < registeredUsers.size(); i++) {
            String[] registeredInfo = registeredUsers.get(i).split(", ");
            data[i] = registeredInfo;
        }

        // Column names
        Object[] columnNames = {"RegiseredID", "First Name", "Last Name", "Email", "Companion Voucher"};

        // Create a DefaultTableModel
        DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(defaultTable);
        
        // Modify Size of the attributes to accommodate all information
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);



        // Display the table in a scrollPane so we can scroll just in case
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 200));
	    JOptionPane.showMessageDialog(null, scrollPane, "All Registered Users", JOptionPane.INFORMATION_MESSAGE);
    }

}
