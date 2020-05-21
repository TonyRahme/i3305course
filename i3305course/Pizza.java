package i3305course;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class Pizza extends JFrame implements ItemListener{

	JCheckBox[] b = new JCheckBox[5];
	JLabel pizza;
	JTextField order;
	JPanel topP, orderP, mainP;
	int cycleList = 0;
	String[] s = new String[5];
	public Pizza(String title){
		super(title);
		
		b[0] = new JCheckBox("Pepperoni");
		b[1] = new JCheckBox("Cheese");
		b[2] = new JCheckBox("Pepper");
		b[3] = new JCheckBox("Pineapple");
		b[4] = new JCheckBox("Onion");
		pizza = new JLabel("Your Pizza");
		order = new JTextField(25);
		order.setEnabled(false);
	
		
		topP = new JPanel();
		orderP = new JPanel();
		
		topP.setLayout(new BoxLayout(topP, BoxLayout.Y_AXIS));
		
		for(int i = 0; i<5; i++){
			topP.add(b[i]);
			b[i].addItemListener(this);
		}
		orderP.setLayout(new FlowLayout(FlowLayout.CENTER));
		orderP.add(pizza);orderP.add(order);
		this.setLayout(new BorderLayout());
		mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		mainP.add(topP);mainP.add(orderP);
		add(mainP);
		add(mainP, BorderLayout.NORTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setSize(500,300);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void itemStateChanged(ItemEvent e){
		String orderList = ""; //String that has the added items
		JCheckBox src = (JCheckBox) e.getItemSelectable(); //current button selected
		boolean iDeselect = false;
		if(e.getStateChange() == ItemEvent.SELECTED)	
					s[cycleList++] = src.getText();
					
		else if (e.getStateChange() == ItemEvent.DESELECTED)
			for(int i = 0; i <= cycleList-1; i++)
			{
				for(int j = 0; j <= 4; j++)
				{
					if(b[j] == src && b[j].getText() == s[i])
					{
						iDeselect = true;
						for(int k = i; k < cycleList; k++)
						{
							if(k == cycleList-1)
								s[k] = null;
							else
							{
								s[k] = s[k+1];
								s[k+1] = null;
							}
						}
						break;
					}
				}
				if(iDeselect)
					break;
			}
		if(iDeselect)
			cycleList--;
		
		for(int i = 0; i <= cycleList-1; i++)
		{
			orderList += s[i];
			if(s[cycleList-1] != null)
				orderList += ", ";
		}
		order.setText(orderList);
		
	}
}
