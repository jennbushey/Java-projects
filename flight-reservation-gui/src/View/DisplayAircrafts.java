package View;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DisplayAircrafts {

    public void displayAircrafts(List<String> information) {
        
    	// Fetch flights from the database
        List<String> aircrafts = information;

        //Create and populate the table
        Object[][] data = new Object[aircrafts.size()][5];

        for (int i = 0; i < aircrafts.size(); i++) {
            String[] flightInfo = aircrafts.get(i).split(", ");
            data[i] = flightInfo;
        }

        // Column names
        Object[] columnNames = {"AircraftID", "Aircraft Model"};

        // Create a DefaultTableModel
        DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(defaultTable);
        
        // Modify Size of the attributes to accommodate all information
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);

        // Display the table in a scrollPane so we can scroll just in case
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 200));
	    JOptionPane.showMessageDialog(null, scrollPane, "All Flights", JOptionPane.INFORMATION_MESSAGE);
    }
}
