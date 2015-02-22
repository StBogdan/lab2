import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

@SuppressWarnings("serial")
public class SlidingPuzzle extends JFrame {
	//Number of rows and columns the picture will be split into
	int rows;
	int colums;
	SlideImage[][] images ;
	
	//Starts the puzzle
	public static void main (String argsp[]){
		SlidingPuzzle mySpeed = new SlidingPuzzle(3,3);
		mySpeed.init();
	}
	
	
	//Initialise the array
	public SlidingPuzzle(int rows, int colums){
		images= new SlideImage[rows][colums];
		this.rows = rows;
		this.colums = colums;
	}
	
	//Starts the Frame
	JFrame window = new JFrame("Sliding Puzzle");
	final Container frame = window.getContentPane();
	
	public void init(){
		//Setup the window components
		frame.setLayout(new BorderLayout());
		
		//Get the images in
		for(int i=0;i< rows;i++)
				for(int j=0; j< colums;j++)
					{
				    images[i][j]= new SlideImage(new ImageIcon("image-" + i + "-" + j +".jpeg"),i,j);
					}
		
		//Put the images at random
		randomise();
		//Displays the images 
		update();
		
		//Listener for mouse clicks
		frame.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				//Gets the index (x,y) of the selected SlideImage
				//It gets the index because (I think) of overriding the methods from JLabel
				int curX = frame.getComponentAt(e.getX(), e.getY()).getComponentAt(e.getX(), e.getY()).getX();
				int curY = frame.getComponentAt(e.getX(), e.getY()).getComponentAt(e.getX(), e.getY()).getY();
				System.out.println("Image clicked" +  curX + " + " +  curY ); 
				
				//Updates the image array
				images =  move(images, curX , curY);
				update();
				if(isCorrect()) frame.add(new JLabel("You have completed the puzzle"),BorderLayout.SOUTH);
			}

			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			});
		
		//Window setup
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(1500,1500);
		window.pack();
	}
	
	public void randomise(){
		for(int i=1; i< 10; i++){
			Random RNG = new Random();
			//Get a random image part
			int x= RNG.nextInt(rows);
			int y=  RNG.nextInt(colums);
			//And another
			int destX=RNG.nextInt(rows);
			int destY=RNG.nextInt(colums);
			//And switch them
			Icon auxIcon = images[x][y].getIcon();
			images[x][y].setIcon(images[destX][destY].getIcon());
			images[destX][destY].setIcon(auxIcon);
		}
	}
	public void update(){
		
		//Creates a new GridLayout container and puts it in the JFrame
		Container showing = new Container();
		showing.setLayout(new GridLayout(rows,colums));
		
		//Adds all images
		for(int i=0 ;i < this.rows; i++)
				for(int j=0 ; j< this.colums ; j++)
					showing.add(images[i][j]);
		frame.removeAll();
		frame.add(showing,BorderLayout.CENTER);
		frame.revalidate();
	}
	
	public SlideImage[][] move(SlideImage[][] images, int x,int y){
		int destX , destY;
		destX=x; destY=y;
		if( y< this.colums-1  && images[x][y+1].isEmpty()) { 
				destY=y+1;
				System.out.println("Right move");
			}
			else if( y>0  && images[x][y-1].isEmpty()) { 
					SlideImage aux = images[x][y-1];
					destY=y-1;
					System.out.println("Left move");
					}
				else if(x>0 && images[x-1][y].isEmpty()) { 
					destX=x-1;
					System.out.println("Up move");
					}
					else if(x< this.rows-1 && images[x+1][y].isEmpty()) { 
						destX= x+1;
						System.out.println("Down move");
						}
		
		//Exchange the icons
		//Just the icons (else the indexes do bad stuff)
		Icon auxIcon = images[x][y].getIcon();
		images[x][y].setIcon(images[destX][destY].getIcon());
		images[destX][destY].setIcon(auxIcon);
		
		return images;
	}
	
	public boolean isCorrect(){
		//Check if the Icon name matches the files
		//Presumes the files are named after in a order which would make a correct picture
		for(int i=0;i< this.rows;i++) for(int j=0;j< this.colums ;j++) if (! images[i][j].getIcon().toString().equals("image-" + i + "-" + j +".jpeg")) return false;
		return true;
	}
}