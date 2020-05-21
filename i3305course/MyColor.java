package i3305course;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyColor extends JFrame{
	int cycle = 0;
	JButton colorB;
	JPanel colorP = new JPanel();
	public MyColor(String title)
	{
		super(title);
		colorB = new JButton("Rainbow!");
		colorP.setLayout(new FlowLayout(FlowLayout.CENTER));
		add(colorP);colorP.add(colorB);
		this.setLayout(new BorderLayout());
		colorB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				switch(cycle)
				{
				case 1:
					colorP.setBackground(Color.GREEN);
					break;
				case 2:
					colorP.setBackground(Color.BLUE);
					break;
				case 3:
					colorP.setBackground(Color.GRAY);
					break;
				default:
					cycle = 0;
					colorP.setBackground(Color.RED);
				}
				cycle++;
			}
		});
		
		this.add(colorP, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(200,200);
	}
}
