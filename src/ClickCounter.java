import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
class ClickCounter extends JFrame implements ActionListener{
	Integer count=0 ;
	JTextField clicks;
	JButton increment;
	JButton reset;
	
	public static void main(String args[]){
		ClickCounter myClickCounter = new ClickCounter();
		myClickCounter.init();
	}
	
	public void init(){
		JFrame window1 = new JFrame("Font Chooser");
		
		increment = new JButton ("Increment");
		reset = new JButton ("Reset");
		clicks = new JTextField(10);
		
		Container panel = window1.getContentPane();
		panel.setLayout(new FlowLayout());
		panel.add(increment);
		panel.add(reset);
		panel.add(clicks);
		
		increment.addActionListener(this);
		reset.addActionListener(this);
		
		//Setup the window
		window1.setVisible(true);
		window1.pack();
		window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
		
	public void actionPerformed(ActionEvent e)
		{
		//If increment is pressed , increase the number of clicks
		if (e.getSource().equals(increment)) count+=1;
		else count=0;
		clicks.setText(count.toString());}
}
