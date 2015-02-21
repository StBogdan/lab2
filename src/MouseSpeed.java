import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MouseSpeed extends JFrame implements MouseMotionListener{
	
	public static void main (String argsp[]){
		MouseSpeed mySpeed = new MouseSpeed();
		mySpeed.init();
	}
	
	int prevX=-1;
	int prevY=-1;
	double distance = 0;
	int events = 0;
	JTextField speed;
	
	
	
	public void init(){
		JFrame window = new JFrame("Velocity is a requirement");
		
		//Setup the window components
		Container frame = window.getContentPane();
		frame.setLayout(new FlowLayout( ));
		
		speed = new JTextField("Not measured",30);
		speed.setEditable(false);
		frame.add(speed);
		
		
		//Setup the window
		window.addMouseMotionListener(this);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,500);
	}

	public void mouseDragged(MouseEvent arg0) {
		events+=1;
		
		//Determine the distance if a previous measurement exists
		//The hypothenuse of a triangle (basically)
		if (!(prevX==-1 && prevY==-1)) distance+= Math.sqrt( (prevX-arg0.getX())*(prevX-arg0.getX()) + (prevY - arg0.getY())*(prevY - arg0.getY()) );
		prevX = arg0.getX();
		prevY = arg0.getY();
		
		//Only display after 10 events have been registered
		if (distance!=0 && events>10) speed.setText((int)distance/events+" distance/events");
	}
	public void mouseMoved(MouseEvent arg0) {
		//Reset the count
		events=0;
		distance =0;
		speed.setText("Hold down any mouse button to start measuring");
	}
}
