/*import javax.swing.*;

import java.awt.*;


class Frame1 extends JFrame{
	
	public static void main(String args[]){
		Frame1 plsWork = new Frame1();
		plsWork.init();
	}
	
	public void init(){
		JFrame window2 = new JFrame("Font Chooser");
		
		
		Container panel2 = window2.getContentPane();
		panel2.setLayout(new FlowLayout());
		
		//gridContainer hold the buttons
		Container gridContainer = new Container();
		gridContainer.setLayout(new GridLayout(1,2));
		Container grid1 = new Container();
		Container grid2 = new Container();
		
		//Grid1
		JCheckBox beBold = new JCheckBox("Bold");
		JCheckBox beItalic = new JCheckBox("Italic");
		grid1.setLayout(new BoxLayout(grid1,BoxLayout.PAGE_AXIS));
		grid1.add(beBold);
		grid1.add(beItalic);
		gridContainer.add(grid1);
		
		//Grid2
		/*JRadioButton font1 = new JRadioButton("Time");
		JRadioButton font2 = new JRadioButton("Helvetica");
		JRadioButton font3 = new JRadioButton("Courier");*/
		/*JComboBox fontBox = new JComboBox();
		fontBox.setModel(new DefaultComboBoxModel());
		fontBox.setEnabled(true);*/
		
		/*ButtonGroup fonts = new ButtonGroup();
		fonts.add(font1);
		fonts.add(font2);
		fonts.add(font3);*/
		
		/*fontBox.addItem("Time");
		fontBox.addItem("Helvetica");
		fontBox.addItem("Courier");
		fontBox.addItem("Times New Roman");
		
		
		grid2.setLayout(new BoxLayout(grid2,BoxLayout.PAGE_AXIS));
		grid2.add(fontBox);
		gridContainer.add(grid2);
		
		panel2.add(gridContainer);
		
		//Rest of elements
		//Added to the flowLayout
		JTextField input = new JTextField(30);
		JButton ok = new JButton("OK");
		
		panel2.add(input);
		panel2.add(ok);
		
		//Setup the window
		window2.setVisible(true);
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window2.pack();
		
	}

}*/