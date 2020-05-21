package i3305course;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class WebpageList
{
	public void createPage(JFrame frame)
	{
		Webpage newPage = new Webpage();
		newPage.setFrame(frame);
		insert(newPage);
	}
	class Webpage
	{
		public JFrame f;
		public Webpage nextPage;
		public Webpage prevPage;
		private JButton prevB;
		private JButton nextB;
		private JButton firstB;
		private JButton lastB;
		private JPanel nav;
		public Webpage()
		{
			this.nextPage = null;
			this.prevPage = null;
			this.prevB = new JButton("Previous");
			this.nextB = new JButton("Next");
			this.firstB = new JButton("First Page");
			this.lastB = new JButton("Last Page");
			this.nav = new JPanel();
		}
		public void setFrame(JFrame frame)
		{
			this.f = frame;
			this.f.setSize(400,500);
			this.f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}
	private Webpage first;
	private Webpage last;
	private Webpage current;
	public WebpageList()
	{
		first = null;
		last = null;
		current = null;
	}
	private boolean isEmpty()
	{
		return first == null;
	}
	private void insert(Webpage newPage)
	{
		if(isEmpty())
		{
			first = newPage;
			last = first;
		}
		else if(first == last)
		{
			last = newPage;
			first.nextPage = last;
			last.prevPage = first;
		}
		else
		{
			newPage.prevPage = last;
			last.nextPage = newPage;
			last = newPage;
		}
	}
	public void initiateWeb()
	{
		createNav(first);
		first.f.setVisible(true);
		current = first;
	}
	private void createNav(Webpage first)
	{
		current = first;
		while (current != null)
		{	
			this.current.firstB.addActionListener(new ActionListener()
					{
				public void actionPerformed(ActionEvent e)
				{
					current.f.setVisible(false);
					current = first;
					current.f.setVisible(true);
				}
					});
			this.current.lastB.addActionListener(new ActionListener()
			{
		public void actionPerformed(ActionEvent e)
		{
			current.f.setVisible(false);
			current = last;
			current.f.setVisible(true);
		}
			});
			this.current.prevB.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					current.f.setVisible(false);
					current = current.prevPage;
					current.f.setVisible(true);
				}
			});
			this.current.nextB.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					current.f.setVisible(false);
					current = current.nextPage;
					current.f.setVisible(true);
				}
			});
			this.current.nav.add(current.firstB, BorderLayout.WEST);
			if(this.current.prevPage != null)
				this.current.nav.add(current.prevB);
			if(this.current.nextPage != null)
				this.current.nav.add(current.nextB);
			this.current.nav.add(current.lastB, BorderLayout.EAST);
			this.current.f.add(current.nav, BorderLayout.SOUTH);
			this.current = this.current.nextPage;
		}
	}
}