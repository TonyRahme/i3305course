package i3305course;
import javax.swing.*;
import java.awt.*;


public class drawPanel extends JPanel
{
	private int fWidth = this.getWidth();
	private int fHeight = this.getHeight();
	private int radius;
	private boolean filled = false;

	public drawPanel()
	{	
	}
	@Override
	public void paintComponent(Graphics g)
	{		
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillRect(0,0,fWidth, fHeight);
		g.setColor(Color.red);
		if(filled)
			g.fillRect((fWidth-radius)/2,(fHeight-radius)/2, radius, radius);
		else
			g.drawRect((fWidth-radius)/2,(fHeight-radius)/2, radius, radius);

	}
	public void setFill(boolean fill)
	{
		filled = fill;
	}
	public void setRadius(int newR, int fW, int fH)
	{
		this.radius = newR;
		this.fWidth = fW;
		this.fHeight = fH;
	}	
}
