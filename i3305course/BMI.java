package i3305course;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BMI extends JFrame{
	JLabel genderLbl = new JLabel("Select Gender:");
	JLabel weightLbl = new JLabel("Enter Weight:");
	JLabel heightLbl = new JLabel("Enter Height:");
	JLabel bmiLbl = new JLabel("Your BMI is:");
	
	JTextField genderTxt = new JTextField(10);
	JTextField weightTxt = new JTextField(5);
	JTextField heightTxt = new JTextField(5);
	JTextField bmiTxt = new JTextField(15);
	
	JButton resultBtn = new JButton("Results");
	JButton resetBtn = new JButton("Reset");
	JButton exitBtn = new JButton("Exit");
	
	String[] genderList = {"Male","Female","Other"};
	JComboBox genderCB = new JComboBox(genderList);
	
	double weightInput, heightInput, bmiOutput;
	
	JPanel weightP = new JPanel();
	JPanel heightP = new JPanel();
	JPanel bmiP = new JPanel();
	JPanel actionP = new JPanel();
	JPanel genderP1 = new JPanel();
	JPanel genderP2 = new JPanel();
	public BMI(String title)
	{
		super(title);
		genderP1.add(genderLbl);genderP1.add(genderCB);
		genderP2.add(genderTxt);
		weightP.add(weightLbl);weightP.add(weightTxt);
		heightP.add(heightLbl);heightP.add(heightTxt);
		bmiP.add(bmiLbl);bmiP.add(bmiTxt);
		actionP.add(resultBtn);actionP.add(resetBtn);actionP.add(exitBtn);
		
		bmiTxt.setEditable(false);
		genderTxt.setEditable(false);
		
		genderCB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(genderCB.getSelectedIndex()==0)genderTxt.setText("Hello, Sir!");
				if(genderCB.getSelectedIndex()==1)genderTxt.setText("Hello, Ma'am!");
				if(genderCB.getSelectedIndex()==2)genderTxt.setText("Hello, Creature!");
			}
		});
		
		resultBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt)
			{
				weightInput = Double.parseDouble(weightTxt.getText());
				heightInput = Double.parseDouble(heightTxt.getText());
				bmiOutput =Math.round(weightInput/(heightInput*heightInput)*100d)/100d;
				bmiTxt.setText(String.valueOf(bmiOutput));
			}
		});
		
		resetBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				weightTxt.setText("");heightTxt.setText("");bmiTxt.setText("");
			}
		});
		
		exitBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP,BoxLayout.Y_AXIS));
		mainP.add(genderP1);mainP.add(genderP2);mainP.add(weightP);mainP.add(heightP);mainP.add(bmiP);mainP.add(actionP);
		this.setLayout(new BorderLayout());
		add(mainP, BorderLayout.NORTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setSize(300,500);
	}
}
