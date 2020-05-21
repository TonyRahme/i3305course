package i3305course;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Calculator extends JFrame implements ActionListener {
	JScrollBar hBar, vBar;
	JTextField firstNbTxt, secondNbTxt, resultTxt;
	float result, firstNb, secondNb;
	JTextArea historyF;
	JScrollPane pane;
	JButton plusB, minusB, timesB, dividedB;
	String history = "";
	int nbOfOp = 0;
	JPanel numberP, buttonP, resultP, historyP;
	public Calculator(String title){
		super(title);
		JPanel mainP = new JPanel();
		mainP.setLayout(new BoxLayout(mainP, BoxLayout.Y_AXIS));
		firstNbTxt = new JTextField(4);
		secondNbTxt = new JTextField(4);
		
		numberP = new JPanel();
		numberP.add(firstNbTxt);numberP.add(secondNbTxt);
		
		buttonP = new JPanel();
		buttonP.setLayout(new GridLayout(2,2));
		plusB = new JButton("+");
		minusB = new JButton("-");
		timesB = new JButton("x");
		dividedB = new JButton("/");
		buttonP.add(plusB);buttonP.add(minusB);buttonP.add(timesB);buttonP.add(dividedB);
		
		resultP = new JPanel();
		resultTxt = new JTextField(4);
		resultTxt.setEnabled(false);
		resultP.add(resultTxt);
		
		hBar = new JScrollBar(JScrollBar.HORIZONTAL, 30,20,0,300);
		vBar = new JScrollBar(JScrollBar.VERTICAL, 30,40,0,300);
		hBar.setUnitIncrement(5);
		historyF = new JTextArea(10,20);
		historyF.setEnabled(false);
		pane = new JScrollPane(historyF);
		pane.setVerticalScrollBar(vBar);
		pane.setHorizontalScrollBar(hBar);
		historyP = new JPanel();
		historyP.add(pane);
		
		mainP.add(numberP);mainP.add(buttonP);mainP.add(resultP);mainP.add(historyP);
		add(mainP);
		this.setLayout(new BorderLayout());
		add(mainP, BorderLayout.NORTH);
		plusB.addActionListener(this);
		minusB.addActionListener(this);
		timesB.addActionListener(this);
		dividedB.addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setBounds(500, 200, 300, 550);
	}
	@Override
	public void actionPerformed(ActionEvent e){
		firstNb = Float.parseFloat(firstNbTxt.getText());
		secondNb = Float.parseFloat(secondNbTxt.getText());
		if (firstNbTxt != null && secondNbTxt != null)
		{
			JButton src = (JButton) e.getSource();
			if(src == plusB)
			{
				result = firstNb + secondNb;
				resultTxt.setText(String.valueOf(result));
				history = ("Operation "+String.valueOf(++nbOfOp)+": "+firstNbTxt.getText()+" + "+secondNbTxt.getText()+" = "+resultTxt.getText()+"\n");	
			}
			else if(src == minusB)
			{
				result = firstNb - secondNb;
				resultTxt.setText(String.valueOf(result));
				history = "Operation"+String.valueOf(++nbOfOp)+": "+firstNbTxt.getText()+" - "+secondNbTxt.getText()+" = "+resultTxt.getText()+"\n";			
			}
			else if(src == timesB)
			{
				result = firstNb * secondNb;
				resultTxt.setText(String.valueOf(result));
				history = "Operation"+String.valueOf(++nbOfOp)+": "+firstNbTxt.getText()+" x "+secondNbTxt.getText() + " = "+resultTxt.getText()+"\n";
			}
			else
			{
				result = firstNb / secondNb;
				resultTxt.setText(String.valueOf(result));
				history = "Operation"+String.valueOf(++nbOfOp)+": "+firstNbTxt.getText()+" / "+secondNbTxt.getText()+" = "+resultTxt.getText()+"\n";
			}
			historyF.append(history);
		}
	}


	

}
