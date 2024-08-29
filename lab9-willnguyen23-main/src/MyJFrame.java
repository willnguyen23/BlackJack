import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MyJFrame {
	public static void main(String[] args) {
		
		//Create new JFrame
		JFrame frame = new JFrame("Sample Frame");
		
		//Create label
		JLabel label = new JLabel("My first Frame!!");
		
		//Create button
		JButton button = new JButton("Click me");
		
		//Add the label to the frame
		frame.add(label);	
		frame.add(button);
		
		//Set frame properties
		
		//Set the size of the frame
		frame.setSize(400, 400);
		
		//Close operation
		frame.getDefaultCloseOperation();
		
		//Make the frame visible
		frame.setVisible(true);
	}
}
