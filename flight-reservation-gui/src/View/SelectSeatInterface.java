package View;

import javax.swing.*;

import Controller.Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectSeatInterface implements Page {
	
	private Controller controller = Controller.getInstance();
    private String selectedSeat;
    public JFrame frame = new JFrame("Seat Selection");
    public List<String> seatsTaken;
     
    public void run() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 800);
        frame.setLocationRelativeTo(null);   
        seatsTaken = (controller.fetchFlights).fetchFlightSeatsFromDatabase(Integer.parseInt(controller.flightChosen));

        JPanel firstClassPanel = new JPanel(new GridLayout(0, 6));

        int row = 1; 
            for (int col = 1; col <= 6; col++) {
            	String seat = String.format("%d%c", row, (char) ('A' + col - 1));
                JButton button = new JButton(seat);
                if (seatsTaken.contains(seat)) {
                	button.setBackground(Color.RED);
                	button.addActionListener(new takenSeatButtonListener());
                }else {
                	button.addActionListener(new SeatButtonListener());
                }
                firstClassPanel.add(button);
            }
        
        JPanel businessPanel = new JPanel(new GridLayout(0, 6));
        row = 2;
            for (int col = 1; col <= 6; col++) {
            	String seat = String.format("%d%c", row, (char) ('A' + col - 1));
                JButton button = new JButton(seat);
                if (seatsTaken.contains(seat)) {
                	button.setBackground(Color.RED);
                	button.addActionListener(new takenSeatButtonListener());
                }else {
                	button.addActionListener(new SeatButtonListener());
                }
                businessPanel.add(button);
            }
        
        JPanel economyPanel = new JPanel(new GridLayout(0, 6));
        for (row = 3; row <= 6; row++) {
            for (int col = 1; col <= 6; col++) {
            	String seat = String.format("%d%c", row, (char) ('A' + col - 1));
                JButton button = new JButton(seat);
                if (seatsTaken.contains(seat)) {
                	button.setBackground(Color.RED);
                	button.addActionListener(new takenSeatButtonListener());
                }else {
                	button.addActionListener(new SeatButtonListener());
                }
                economyPanel.add(button);
            }
        }
        
        // Text panel for "Front" label
        JPanel frontTextPanel = new JPanel();
        JLabel frontLabel = new JLabel("Front");
        frontTextPanel.add(frontLabel);

        // Text panel for "Back" label
        JPanel backTextPanel = new JPanel();
        JLabel backLabel = new JLabel("Back");
        backTextPanel.add(backLabel);
        
        // Text panel for "First Class" label
        JPanel firstClass = new JPanel();
        JLabel firstClassLabel = new JLabel("First Class");
        firstClass.add(firstClassLabel);

        // Text panel for "Business" label
        JPanel businessClass = new JPanel();
        JLabel businessLabel = new JLabel("Business Class");
        businessClass.add(businessLabel);
        
        // Text panel for "Business" label
        JPanel ecoClass = new JPanel();
        JLabel ecoLabel = new JLabel("Economy");
        ecoClass.add(ecoLabel);
        
        JButton backButton = new JButton("Back");
        backButton.setBounds(85, 120, 150, 25);
        
        JPanel mainPanel = new JPanel(new GridLayout(0, 1));
        
        mainPanel.add(frontTextPanel);
        mainPanel.add(firstClass);
        mainPanel.add(firstClassPanel);
        mainPanel.add(businessClass);
        mainPanel.add(businessPanel);
        mainPanel.add(ecoClass);
        mainPanel.add(economyPanel);
        mainPanel.add(backTextPanel);

        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.add(BorderLayout.SOUTH, backButton);
        frame.setSize(500, 600);
        frame.setVisible(true);
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("BrowseFlights");
            }
        });
    }

    private class SeatButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            selectedSeat = button.getText();
            System.out.println("Selected Seat: " + selectedSeat);
            controller.seatChosen = selectedSeat;
            if (selectedSeat.indexOf('1') >= 0) {
            	controller.seatCost = 200;
            }
            else if (selectedSeat.indexOf('2') >= 0) {
            	controller.seatCost = 100;
            }
            else {
            	controller.seatCost = 50;        	
            }

            if (controller.seatChosen == null) {
            	controller.setState("SelectSeat");        	
            }
            else {
            	frame.dispose();
            	controller.setState("SelectInsurance");
            }
        }
    }
    
    private class takenSeatButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
    }
}

