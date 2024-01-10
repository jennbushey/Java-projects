package View;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplaySystemAdminFlight {
    
	public void displaySystemAdminFlight(List<String> information) {
        
    	// Fetch flights from the database
        List<String> systemAdminFlight = information;

        //Create and populate the table
        Object[][] data = new Object[systemAdminFlight.size()][10];

        for (int i = 0; i < systemAdminFlight.size(); i++) {
            String[] registeredInfo = systemAdminFlight.get(i).split(", ");
            data[i] = registeredInfo;
        }

        // Column names
        Object[] columnNames = {"FlightID", "Departure Airport", "Arrival Airport", "Departure Time", "Arrival Time", 
								"AircraftID", "Crew 1 ID", "Crew 2 ID", "Crew 3 ID"};

        // Create a DefaultTableModel
        DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(defaultTable);
        
        // Modify Size of the attributes to accommodate all information
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(250);
        table.getColumnModel().getColumn(4).setPreferredWidth(250);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(150);
        table.getColumnModel().getColumn(7).setPreferredWidth(150);
        table.getColumnModel().getColumn(8).setPreferredWidth(150);



        // Display the table in a scrollPane so we can scroll just in case
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1500, 200));
	    JOptionPane.showMessageDialog(null, scrollPane, "All Registered Users", JOptionPane.INFORMATION_MESSAGE);
    }
}
