package i3305course;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class paintDraw extends JFrame implements ActionListener{
	JRadioButton[] b = new JRadioButton[3];
	String [] s = {"Small", "Medium", "Large"};
	JCheckBox c = new JCheckBox("Filled");
	drawPanel p2 = new drawPanel();
	JTextField d;
	
	public paintDraw(String title)
	{
		super(title);
		setSize(300,300);
		ButtonGroup g = new ButtonGroup();
		for (int i = 0; i<3; i++)
		{
			b[i] = new JRadioButton(s[i]);
			b[i].addActionListener(this);
			g.add(b[i]);
			p2.add(b[i]);
		}
		b[0].setSelected(true);
		c.addActionListener(this);
		p2.add(c);
		JPanel mainP = new JPanel();
		mainP.setLayout(new BorderLayout());
		mainP.add(p2, BorderLayout.CENTER);
		add(mainP);
		addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent e)
			{
				if(b[0].isSelected())
					p2.setRadius(50, getWidth(), getHeight());
				else if(b[1].isSelected())
					p2.setRadius(100, getWidth(), getHeight());
				else p2.setRadius(150, getWidth(), getHeight());
				p2.repaint();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (c.isSelected())
			p2.setFill(true);
		else p2.setFill(false);
		if(b[0].isSelected())
			p2.setRadius(50, this.getWidth(), this.getHeight());
		else if(b[1].isSelected())
			p2.setRadius(100, this.getWidth(), this.getHeight());
		else p2.setRadius(150, this.getWidth(), this.getHeight());
		p2.repaint();
	}
}
