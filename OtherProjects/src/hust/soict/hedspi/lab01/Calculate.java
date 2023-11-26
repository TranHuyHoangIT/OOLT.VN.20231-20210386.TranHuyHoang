package hust.soict.hedspi.lab01;
import javax.swing.JOptionPane;
public class Calculate {
	public static void main(String[] args) {
		String strNum1, strNum2;
		
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ","Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ","Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		double num2 = Double.parseDouble(strNum2);
		
		double sum = num1 + num2;
		double diff = num1 - num2;
		double product = num1*num2;

		String strNotification = "Sum: " + sum + "\nDiffirence: " + diff + "\nProduct: " + product;

        	if (num2 != 0) {
           		double quotient = num1 / num2;
            		strNotification += "\nQuotient: " + quotient;
        	} else {
            		strNotification += "\nQuotient: Math error!";
        	}
		
		JOptionPane.showMessageDialog(null, strNotification,
				 "Show result", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
	}
}