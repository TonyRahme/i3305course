package i3305course;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame
{
	JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7, panel8, panel9;
	JPanel genderPanel, heightPanel, weightPanel, bgClr;
	ButtonGroup gG = new ButtonGroup();
	ButtonGroup hG = new ButtonGroup();
	JRadioButton maleG, femaleG, otherG, smallH, mediumH, largeH;
	JLabel weightLbl, genderLbl, heightLbl, nameLbl1, nameLbl2;
	JTextField weightInput, nameTxt1, nameTxt2;
	JButton red, green;
	MyFrame(String title)
	{
		
		super(title);
		
		panel1 = new JPanel();panel2 = new JPanel();panel3 = new JPanel();panel4 = new JPanel();panel5 = new JPanel();panel6 = new JPanel();panel7 = new JPanel();
		genderPanel = new JPanel();heightPanel = new JPanel();weightPanel = new JPanel(); bgClr = new JPanel(); panel8 = new JPanel();panel9 = new JPanel();
		//Color Panel
		nameLbl1 = new JLabel("Enter Name:");nameLbl2 = new JLabel("Is this your name?");		
		nameTxt1 = new JTextField(10);nameTxt2 = new JTextField(10);
		
		nameTxt1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				String name = nameTxt1.getText();
				nameTxt2.setText(name);
			}
		});
		
		
		red = new JButton("Red");
		green = new JButton("Green");
		bgClr.setLayout(new FlowLayout(FlowLayout.CENTER));
		bgClr.add(red);bgClr.add(green);
		bgClr.add(nameLbl1);bgClr.add(nameTxt1);bgClr.add(nameLbl2);bgClr.add(nameTxt2);
		
		
		red.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				bgClr.setBackground(Color.RED);
			}
		});
		green.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				bgClr.setBackground(Color.GREEN);
			}
		});
		
		//Gender Panel
		genderLbl = new JLabel("Gender");
		maleG = new JRadioButton("Male", true);
		femaleG = new JRadioButton("Female", false);
		otherG = new JRadioButton("Other", false);
		gG.add(femaleG);gG.add(maleG);gG.add(otherG);
		panel1.add(genderLbl);
		panel2.add(maleG);
		panel3.add(femaleG);
		panel4.add(otherG);
		genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.Y_AXIS));
		genderPanel.add(panel1);
		genderPanel.add(panel2);
		genderPanel.add(panel3);
		genderPanel.add(panel4);
		//Height Panel
		heightLbl = new JLabel("Height");
		smallH = new JRadioButton("160 or Below", true);
		mediumH = new JRadioButton("160 - 170", false);
		largeH = new JRadioButton("170 or Above", false);
		hG.add(smallH);hG.add(mediumH);hG.add(largeH);
		panel5.add(heightLbl);
		panel6.add(smallH);
		panel7.add(mediumH);
		panel8.add(largeH);
		heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.Y_AXIS));
		heightPanel.add(panel5);heightPanel.add(panel6);heightPanel.add(panel7);heightPanel.add(panel8);
		
		//Weight Panel
		weightLbl = new JLabel("Ideal Weight:");
		weightInput = new JTextField(5);
		JButton veryNice = new JButton("Very Nice!");
		veryNice.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent event)
				{
					System.exit(0);
				}
				
			});
	
		weightPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		weightPanel.add(weightLbl);weightPanel.add(weightInput);weightPanel.add(veryNice);
		
		//MyFrame mainPanel Layout
		JPanel mainP = new JPanel();
		mainP.setLayout(new BorderLayout());
		mainP.add(bgClr, BorderLayout.NORTH);mainP.add(genderPanel, BorderLayout.WEST);
		mainP.add(heightPanel, BorderLayout.EAST);mainP.add(weightPanel, BorderLayout.SOUTH);
		this.setLayout(new BorderLayout());
		add(mainP, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(400,400);
	}
}