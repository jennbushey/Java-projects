package View;

import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DisplayCrews {

    public void displayCrews(List<String> information) {
        
    	// Fetch flights from the database
        List<String> crews = information;

        //Create and populate the table
        Object[][] data = new Object[crews.size()][5];

        for (int i = 0; i < crews.size(); i++) {
            String[] flightInfo = crews.get(i).split(", ");
            data[i] = flightInfo;
        }

        // Column names
        Object[] columnNames = {"CrewID", "First Name", "Last Name"};

        // Create a DefaultTableModel
        DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(defaultTable);
        
        // Modify Size of the attributes to accommodate all information
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);


        // Display the table in a scrollPane so we can scroll just in case
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 200));
	    JOptionPane.showMessageDialog(null, scrollPane, "All Crews", JOptionPane.INFORMATION_MESSAGE);
    }
}
