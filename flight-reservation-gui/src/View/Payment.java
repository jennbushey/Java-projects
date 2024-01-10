package View;

import javax.swing.JTextField;

public class Payment {
	protected JTextField cardNumberField;
    protected JTextField cardNameField;
    protected JTextField cvvField;
    protected JTextField emailField;
    
    protected PaymentStrategy paymentStyle;
    
    public void setPaymentStrategy(PaymentStrategy p) {
    	paymentStyle = p;
    }
    
    public void performPayment() {
    	paymentStyle.verify(Integer.parseInt(cardNumberField.getText()));
    }

}
