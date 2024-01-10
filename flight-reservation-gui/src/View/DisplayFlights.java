package View;


import javax.swing.*;
import javax.swing.table.*;

import Controller.Controller;
import Entities.FetchFlights;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayFlights implements Page {

    public String chosenFlight;
    public JTable table;
    private Controller controller = Controller.getInstance();
    public List<String> Flights;
    public String airportCode;
    private JTextField arrivalAirportTextField;
    private JTextField departureAirportTextField;
    JFrame frame;

    public void displayFlights(List<String> information) {
        // Fetch flights from the database
        List<String> flights = information;

        // Create and populate the table
        Object[][] data = new Object[flights.size()][6];

        for (int i = 0; i < flights.size(); i++) {
            String[] flightInfo = flights.get(i).split(", ");
            data[i] = flightInfo;
        }

        // Add an extra column for the 'Select' button
        Object[] columnNames = {"FlightID", "Departure Airport", "Arrival Airport", "Departure Time", "Arrival Time", "Double-Click to Select"};

        // Create a DefaultTableModel
        DefaultTableModel defaultTable = new DefaultTableModel(data, columnNames) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnIndex == 5 ? JButton.class : Object.class;
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };

        // Create a JTable with the model
        table = new JTable(defaultTable);
        

        // Create a button column with a custom renderer and editor
        TableColumn buttonColumn = table.getColumnModel().getColumn(5);
        buttonColumn.setCellRenderer(new ButtonRenderer());
        buttonColumn.setCellEditor(new ButtonEditor(new JTextField()));

        // Modify Size of the attributes to accommodate all information
        table.getColumnModel().getColumn(0).setPreferredWidth(150);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(150);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);

        // Display the table in a scrollPane 
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel topPanel = new JPanel(new FlowLayout());

        // Label for the text field
        JLabel arrivalAirportLabel = new JLabel("Arrival Airport Code:");
        JLabel departureAirportLabel = new JLabel("Departure Airport Code:");

        // Text field for user input
        arrivalAirportTextField = new JTextField(5);
        departureAirportTextField = new JTextField(5);
        JButton backButton = new JButton("Back");
        backButton.setBounds(85, 120, 150, 25);

        // Search button
        JButton arrivalSearchButton = new JButton("Search Arrival Airport");
        arrivalSearchButton.addActionListener(new SearchArrivalListener());
        JButton departureSearchButton = new JButton("Search Departure Airport");
        departureSearchButton.addActionListener(new SearchDepartureListener());


        // Add components to the top panel
        topPanel.add(arrivalAirportLabel);
        topPanel.add(arrivalAirportTextField);
        topPanel.add(arrivalSearchButton);
        topPanel.add(departureAirportLabel);
        topPanel.add(departureAirportTextField);
        topPanel.add(departureSearchButton);
        
        
        frame = new JFrame("Flight Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(BorderLayout.NORTH, topPanel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.add(BorderLayout.SOUTH, backButton);
        frame.setSize(1000, 200);
        frame.setVisible(true);

        // Access the chosenFlight variable when the button is clicked
        System.out.println("Chosen Flight ID: " + chosenFlight);
        System.out.println("User Type: " + controller.userType);
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("MainMenu");
            }
        });
        
    }

    // Custom button renderer
    public static class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    // Custom button editor
    public class ButtonEditor extends DefaultCellEditor {
        private String label;
        private boolean isPushed;
        JButton button;

        public ButtonEditor(JTextField textField) {
            super(textField);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Perform your desired action when the button is clicked
                chosenFlight = table.getValueAt(table.getSelectedRow(), 0).toString();
                controller.flightChosen = chosenFlight;
                //Add cost
                controller.flightCost = 300;
                frame.dispose();                
                
                if (controller.flightChosen == null) {
                	controller.setState("BrowseFlights");        	
                }
                else {
                	if (controller.userType == 1) {
                		
                    	controller.setState("SelectSeat");        	
                    }
                    else {
                    	controller.setState("SelectSeat");
                    }
                }
                
            }
            isPushed = false;
            return label;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        @Override
        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    private class SearchArrivalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the text from the JTextField
            String airportCode = arrivalAirportTextField.getText();
            frame.dispose();
            Flights = (controller.fetchFlights).fetchArrivalsFromDatabase(airportCode);
            displayFlights(Flights);
        }
    }
    
    private class SearchDepartureListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the text from the JTextField
            String airportCode = departureAirportTextField.getText();
            frame.dispose();
            Flights = (controller.fetchFlights).fetchDeparturesFromDatabase(airportCode);
            displayFlights(Flights);
        }
    }

	@Override
	public void run() {
		Flights = (controller.fetchFlights).fetchFlightsFromDatabase();
		displayFlights(Flights);
		
	}

}
