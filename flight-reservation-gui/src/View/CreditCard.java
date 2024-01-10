package View;

public class CreditCard implements PaymentStrategy {

	@Override
	public void verify(int cardNumber) {
		String cardString = Integer.toString(cardNumber);
		int digitSum = 0;
		for (int i=0; i<cardString.length(); i++) {
			digitSum += Character.getNumericValue(cardString.charAt(i));
		}
		if ((digitSum % 10) == 0) {
			System.out.println("Real Credit Card Entered");
		} else {
			System.out.println("Fake Credit Card Entered");
		}
		
	}

}
