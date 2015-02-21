import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
class FontChooser extends JFrame{
	
	public static void main(String args[]){
		FontChooser myFonts = new FontChooser();
		myFonts.init();
	}
	
	public void init(){
		JFrame window = new JFrame("Font Chooser");
		final JComboBox<String> fontBox = new JComboBox<String>();
		final JTextField input = new JTextField(30);
		JButton ok = new JButton("OK");
		
		Container panel2 = window.getContentPane();
		panel2.setLayout(new FlowLayout());
		
		//gridContainer hold the buttons
		Container gridContainer = new Container();
		gridContainer.setLayout(new GridLayout(1,2));
		Container grid1 = new Container();
		Container grid2 = new Container();
		
		//Grid1
		final JCheckBox beBold = new JCheckBox("Bold");
		final JCheckBox beItalic = new JCheckBox("Italic");
		grid1.setLayout(new BoxLayout(grid1,BoxLayout.PAGE_AXIS));
		grid1.add(beBold);
		grid1.add(beItalic);
		gridContainer.add(grid1);
		
		//Listener for style changes
		ItemListener styleDetect = new ItemListener(){
											public void itemStateChanged(ItemEvent e) {
												int fontState =0;
												if(beItalic.isSelected()) fontState += Font.ITALIC;
												if(beBold.isSelected()) fontState += Font.BOLD;
												input.setFont(input.getFont().deriveFont(fontState));
												} 
											};
		beBold.addItemListener(styleDetect);
		beItalic.addItemListener(styleDetect);
		
		//Grid2
		
		//Create a drop-down list for fonts
		fontBox.setModel(new DefaultComboBoxModel());
		fontBox.setEnabled(true);
			//Get all the fonts 
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontNames = e.getAvailableFontFamilyNames();
		
		final HashMap <String,Font> fontMap = new HashMap<String,Font>();
		for(String font : fontNames) 
			{fontBox.addItem(font);
			 for ( Font searchFont : e.getAllFonts()) if (searchFont.getFontName().equals(font)) fontMap.put(font, searchFont);}
		
		//Add a listener for user font choice
		fontBox.addItemListener(new ItemListener(){
											public void itemStateChanged(ItemEvent e) {
												if(e.getStateChange() == ItemEvent.SELECTED ){
													input.setFont(fontMap.get(fontBox.getSelectedItem()));
													input.setFont(input.getFont().deriveFont(16.0f));
												}
											}
		});
		grid2.setLayout(new FlowLayout());
		grid2.add(fontBox);
		gridContainer.add(grid2);
		
		panel2.add(gridContainer);
		
		//Rest of elements
		//Added to the flowLayout
		
		
		panel2.add(input);
		panel2.add(ok);
		
		//Setup the window
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		
	}

}