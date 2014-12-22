package basic;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.awt.Color;

import javax.swing.*;

public class FinalFrame {
	
	private JFrame frame;
	private JPanel panel1,panel2,panel3;
	private JLabel pic,title;
	private JButton logout;
	private JTable table;
	
	public FinalFrame(String Roll)
	{
		Font font1=new Font("Algerian",Font.ITALIC,14);
		
		frame=new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setSize(1000, 400);
	    
		
		panel1=new JPanel(new GridLayout(3,1));
		panel2=new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
		panel3=new JPanel(new FlowLayout() );
		logout=new JButton("Logout");
		logoutHandler logoutButtonList=new logoutHandler();
		logout.addActionListener(logoutButtonList);
		logout.setBackground(Color.WHITE);
		
		title=new JLabel("error");
		title.setFont(font1);
		setFrame(Roll);
		
		panel1.add(title);
		panel1.add(new JScrollPane(table));
		panel2.add(logout);
		panel1.add(panel2);
		panel3.add(panel1);
		
		frame.add(new JScrollPane(table),BorderLayout.CENTER);
		frame.add(title,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.setVisible(true);
		frame.setResizable(false);
		
				
	}
	
	private void setFrame(String Roll)
	{
		Font font2 = new Font("Bradley Hand ITC",Font.BOLD,24);
		FileInputStream file;
        ObjectInputStream input = null;
        
        
        	try {
				file=new FileInputStream("log.txt");
				
				input = new ObjectInputStream(file);
				
				ArrayList al=(ArrayList)input.readObject();
				Object[] ob;
				
				for(int i=0;i<al.size();i++)
				{
					ob=(Object[]) al.get(i);
					if(Roll.equals(""+ob[0]))
					{
						
						title.setText("TIMETABLE OF "+Roll);
						title.setFont(font2);
						table=(JTable) ob[1];
						break;
					}
					
				}
				
				file.close();
			} 
        	catch (FileNotFoundException e) 
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	catch (IOException e) 
        	{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}
        	catch (ClassNotFoundException e)
        	{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
			
	}

	class logoutHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			
			 MainFrame mfrm = new MainFrame();
             
            frame.setVisible(false);
            frame.dispose();
			
		}
     }	
	
}
