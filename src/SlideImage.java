import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class SlideImage extends JLabel{
	int row;
	int column;
	
	public SlideImage(ImageIcon icon,int row, int column){
		super(icon);
		this.row = row;
		this.column = column;
	}
	
	public boolean isEmpty(){
		return this.getIcon().getIconWidth() == -1 ;
	}
	
	public int getX() { return row;}
	public int getY() { return column;}
	
	
}
