package View;
import java.awt.Dimension;
import java.util.List;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DisplayManifest {

    public void displayManifest(List<String> information) {
        
    	// Fetch flights from the database
        List<String> manifest = information;

        //Create and populate the table
        Object[][] data = new Object[manifest.size()][6];

        for (int i = 0; i < manifest.size(); i++) {
            String[] flightInfo = manifest.get(i).split(", ");
            data[i] = flightInfo;
        }

        // Column names
        Object[] columnNames = {"UserID", "First Name", "Last Name", "Seat"};

        // Create a DefaultTableModel
        DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames);

        // Create a JTable with the model
        JTable table = new JTable(defaultTable);
        
        // Modify Size of the attributes to accommodate all information
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(150);


        // Display the table in a scrollPane so we can scroll just in case
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(1000, 200));
	    JOptionPane.showMessageDialog(null, scrollPane, "All Passengers", JOptionPane.INFORMATION_MESSAGE);
    }
}
    
