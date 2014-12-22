package basic;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;


public class AdminFrame {
	
	//GUI Components
	private JFrame frame, viewFrame;
	private JPanel panel1,panel2,panel3,panel4,panel5,panel6;
	private JTextField nameTxt,rollNoTxt,branchTxt;
	private JTextField cgpaTxt;
	private JButton addButton,cancelButton, clearButton, viewButton;
	private JLabel nameLabel,cgpaLabel,rollNoLabel,branchLabel, header;
	private Font font1;
	private Font font2;
	private Font font3;
	private Font font4;
	//Backend components
	
	User u = new User();
	UserList ul=new UserList();

	
	public AdminFrame()
	{
		frame=new JFrame();
		frame.setSize(500, 430);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		font1 = new Font("Shrif",Font.BOLD,14);
		font2 = new Font("Bradley Hand ITC",Font.BOLD,14);
		font3 = new Font("Brittanic bold",Font.ITALIC,16);
		font4=new Font("Algerian",Font.BOLD,16);
		
		Window windowOpen =new Window();
		frame.addWindowListener(windowOpen);
		
		panel3=new JPanel(new GridLayout(4, 2, 0, 10));  //row, column, hgap, vgap
		panel2=new JPanel();
		panel1=new JPanel();
		panel4=new JPanel(new FlowLayout(FlowLayout.CENTER,30,40));
		
		panel3.setSize(400, 200);
		
		header = new JLabel("WELCOME ADMIN!");
		panel1.add(header);
		header.setFont(font4);
		
		nameTxt= new JTextField(15);
		cgpaTxt= new JTextField(15);
		rollNoTxt= new JTextField(15);
		branchTxt= new JTextField(15);
		
		addButton=new JButton("ADD");
		cancelButton=new JButton("CANCEL");
		clearButton = new JButton("CLEAR");
		viewButton = new JButton("VIEW STUDENTS");
		
		nameLabel = new JLabel("NAME");
		cgpaLabel = new JLabel("CGPA");
		rollNoLabel = new JLabel("ROLL NO");
		branchLabel = new JLabel("BRANCH");
		
		nameTxt.setFont(font2);
		cgpaTxt.setFont(font2);
		rollNoTxt.setFont(font2);
		branchTxt.setFont(font2);
		
		addButton.setFont(font1);
		cancelButton.setFont(font1);
		clearButton.setFont(font1);
		viewButton.setFont(font1);
		
		nameLabel.setFont(font3);
		cgpaLabel.setFont(font3);
		rollNoLabel.setFont(font3);
		branchLabel.setFont(font3);
		
		addL addList=new addL();
		cancelL cancelList=new cancelL();
		clearL clearList = new clearL();
		viewL viewList = new viewL();
		
		addButton.addActionListener(addList);
		cancelButton.addActionListener(cancelList);
		clearButton.addActionListener(clearList);
		viewButton.addActionListener(viewList);
		
		viewButton.setEnabled(false);
		
		panel3.add(nameLabel);
		panel3.add(nameTxt);
		
		panel3.add(branchLabel);
		panel3.add(branchTxt);
		
		panel3.add(rollNoLabel);
		panel3.add(rollNoTxt);
	
		panel3.add(cgpaLabel);
		panel3.add(cgpaTxt);
		
		panel2.add(addButton);
		panel2.add(cancelButton);
		panel2.add(clearButton);
		panel2.add(viewButton);
		
		
		panel4.add(panel3);
		
		frame.add(panel1);
		frame.add(panel4);
		frame.add(panel2);
		
		frame.setVisible(true);
		
		
	}
	
	class Window implements WindowListener {

		@Override
		public void windowActivated(WindowEvent arg0)
		{
			// ignored
			
		}

		@Override
		public void windowClosed(WindowEvent arg0)
		{
			// ignored
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) 
		{
			// ignored
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) 
		{
			// ignored
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) 
		{
			// ignored
			
		}

		@Override
		public void windowIconified(WindowEvent arg0)
		{
			// ignored
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) 
		{
			
			check();
			
		}
		
	}
	
	private void check()
	{
		FileInputStream fstream;
		try
		{
			fstream = new FileInputStream("validation.txt");
			DataInputStream input = new DataInputStream(fstream);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input));
			
			if(buffer.readLine()!=null) 
				viewButton.setEnabled(true);
		
		}
		catch (FileNotFoundException e) 
		{
			
		}
		catch (IOException e) 
		{
			
		}
		
	}
	
	class addL implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			int reply = JOptionPane.showConfirmDialog(null, "Add Student Details ?", "Confirmation",JOptionPane.YES_NO_OPTION); 
        
			if(reply == JOptionPane.YES_OPTION)
			{
            	u.setname(nameTxt.getText());
            	Exception ex = null; boolean flag = true;
            	try 
            	{
            		ul.addToValidation(rollNoTxt.getText(),1);
            	}
            	catch (IOException e1) 
            	{
				
            	}
            
            
            float cgpa = Float.parseFloat(cgpaTxt.getText());
            while(flag)
            {
            	try
            	{
            		if( cgpa<0.00 || cgpa>10.00) throw ex;
            		flag = false;
            		
            	}// end of try
            	catch(Exception e)
            	{
            		cgpa = Float.parseFloat(JOptionPane.showInputDialog("Invalid Input. Please enter a CGPA between 0.00 and 10.00"));
            		flag=true;
            	}// end of catch  
            }// end of while
            
            u.setname(nameTxt.getText());
            
            
            u.setcgpa(cgpa); //As it returns an object cast it.
            u.setrollNo(rollNoTxt.getText().toUpperCase());
            u.setbranch(branchTxt.getText().toUpperCase());
            u.Obj.setCount();
            //int pos=0;
            ul.MakeList();
            ul.WriteUserToList(u);
            
           try 
           {
				
				if(u.getbranch().equalsIgnoreCase("IT"))
				ul.WriteListToFile("IT");
				else
				ul.WriteListToFile("ECE");
				
				JOptionPane.showMessageDialog(null,"Student Added");
				check();
			}
           catch (IOException e)
           {
				
			}
            
			
	
		}
	}
}

	
	class cancelL implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			JOptionPane.showMessageDialog(null,"Cancelled");
			
			MainFrame mf = new MainFrame();
			
			frame.setVisible(false); //is this the right way!?
			frame.dispose();
		}
		
	}
	
	
	class clearL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			nameTxt.setText("");
			cgpaTxt.setText("");
			rollNoTxt.setText("");
			branchTxt.setText("");
			
		}
	}
	
	class viewL implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			frame.setVisible(false);
			//Branch b = new Branch();
			//b = ul.UListIT.get(0).getSubjects();
			//System.out.println(b.slot1.get(0));
			//System.out.println(b.count1.get(0));
			StudentView sv=new StudentView();
		
		}
	}


}