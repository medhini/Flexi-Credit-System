package basic;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import basic.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class UserFrame {
	
	JFrame frame;
	JPanel panel1,panelf2,panel2,panel3,panel31,panel32,panel33,panel21,panel22,panel23,panels;
	JLabel Tlabel,S1label,S2label,S3label,Siglabel,Hlabel,Templabel,H2label;
	JRadioButton[] S;
	JButton OKBtn,logoutBtn;
	JTable table;
	String roll;
	ButtonGroup S1BG,S2BG,S3BG;
	String subject;
	UserList ul=new UserList();
	User u,unext;
	int pos;
	Branch Obj = new Branch();
	
	//things that need to be done 1.inactive label alignment needs to be set,2.fonts have to be set appropriately,3.add button handlers
	
	
	public UserFrame(String Roll)
	{
		
		roll=Roll;
		Roll=Roll.toUpperCase();
		frame=new JFrame("FLEXI CREDIT TIMETABLE CHOOSER");
		frame.setSize(1000, 720);
		
		Font font1 = new Font("Shrif",Font.BOLD,14);
		Font font2 = new Font("Bradley Hand ITC",Font.BOLD,14);
		Font font3 = new Font("Brittanic bold",Font.ITALIC,16);
		Font font4=new Font("Algerian",Font.BOLD,16);
	
		 panel1=new JPanel(new GridLayout(1,1));
		 panel2=new JPanel(new GridLayout(6,1));
		 panel3=new JPanel(new GridLayout(3,1));
		 panel22=new JPanel(new GridLayout(4,1));
		 panel21=new JPanel(new GridLayout(4,1));
		 panel23=new JPanel(new GridLayout(4,1));
		 panel31=new JPanel(new GridLayout(1,1));
		 panel32=new JPanel(new FlowLayout(FlowLayout.CENTER,30,30));
		 panel33=new JPanel(new GridLayout(1,1));
		 panelf2=new JPanel(new FlowLayout(FlowLayout.CENTER,30,30));
		// panels=new JPanel(new FlowLayout(FlowLayout.CENTER,,5));    //ch4
		 
		 OKBtn=new JButton("Confirm TimeTable");
		 logoutBtn=new JButton("Logout");
		OKBtn.setFont(font3);
		logoutBtn.setFont(font3);
		
		 okBttnHandler okBtnL=new okBttnHandler();
         loutBttnHandler loutBtnL=new loutBttnHandler();
                 
         OKBtn.addActionListener(okBtnL);
         logoutBtn.addActionListener(loutBtnL);
         
        
         unext=null;
         
         if(Roll.substring(2,4).compareTo("IT")==0)
         {
        	 pos=-1;
        	 for(int i=0; i<ul.UListIT.size(); i++)
        	 {
        		 if(Roll.equalsIgnoreCase(ul.UListIT.get(i).getrollNo()))
        			 pos = i;
        			 
        	 }
        	 u=ul.UListIT.get(pos);
        	 if(pos< ul.UListIT.size() -1)
        		 unext=ul.UListIT.get(pos+1);
        	 Obj = u.getSubjects();
         }
         else
         {
        	 pos=-1;
        	 for(int i=0; i<ul.UListECE.size(); i++)
        	 {
        		 if(Roll.equalsIgnoreCase(ul.UListECE.get(i).getrollNo()))
        			 pos = i;
        			 
        	 }
        	 u=ul.UListECE.get(pos);
        	 System.out.println(u.getname());
        	 if(pos< ul.UListECE.size() - 1)
        		 unext=ul.UListECE.get(pos+1);
        	 Obj = u.getSubjects();
         }
         
		 RB1Handler h1=new RB1Handler();
		 RB2Handler h2=new RB2Handler();
		 RB3Handler h3=new RB3Handler();
		 RB4Handler h4=new RB4Handler();
		 RB5Handler h5=new RB5Handler();
		 RB6Handler h6=new RB6Handler();
		 RB7Handler h7=new RB7Handler();
		 RB8Handler h8=new RB8Handler();
		 RB9Handler h9=new RB9Handler();
		 
		 S = new JRadioButton[9];
		 for(int i=0; i<9; i++)
		 {
			 subject = (String)Obj.slot.get(i);
			 S[i] = new JRadioButton(subject);
		 }
		 S[0].addItemListener(h1);
		 S[1].addItemListener(h2);
		 S[2].addItemListener(h3);
		 S[3].addItemListener(h4);
		 S[4].addItemListener(h5);
		 S[5].addItemListener(h6);
		 S[6].addItemListener(h7);
		 S[7].addItemListener(h8);
		 S[8].addItemListener(h9);

		 S[1].setFont(font2);
		 S[2].setFont(font2);
		 S[3].setFont(font2);
		 S[4].setFont(font2);
		 S[5].setFont(font2);
		 S[6].setFont(font2);
		 S[7].setFont(font2);
		 S[8].setFont(font2);
		 S[0].setFont(font2);

		 S1BG=new ButtonGroup();
		 S2BG=new ButtonGroup();
		 S3BG=new ButtonGroup();
		 
		 for(int i=0; i<3; i++)
		 {
			 S1BG.add(S[i]);
			 S2BG.add(S[i+3]);
			 S3BG.add(S[i+6]);
		 }
		 		 
		 Siglabel=new JLabel();
		 Siglabel.setHorizontalTextPosition(SwingConstants.CENTER);
		 Siglabel.setOpaque(true);
		 Siglabel.setSize(200, 100); //ch1
		 Siglabel.setFont(font1);
		 checkStatus();
		
		 Siglabel.setHorizontalAlignment(JLabel.CENTER);   //ch3
		 Siglabel.setVerticalAlignment(JLabel.CENTER);
		 Templabel=new JLabel("      ");
		// panels.add(Siglabel); ch5
		 
		 
		 Hlabel=new JLabel("CHOOSE ATLEAST ONE FROM EACH SLOT ");
		 Hlabel.setHorizontalTextPosition(SwingConstants.LEADING);
		
		 S1label=new JLabel("SLOT 1 :");
		 S1label.setHorizontalTextPosition(SwingConstants.LEADING);
		 S1label.setFont(font4);
		 
		 S2label=new JLabel("SLOT 2 :");
		 S2label.setHorizontalTextPosition(SwingConstants.LEADING);
		 S2label.setFont(font4);
		 S3label=new JLabel("SLOT 3 :");
		 S3label.setHorizontalTextPosition(SwingConstants.LEADING);
		 S3label.setFont(font4);
		 
		 H2label=new JLabel("TIMETABLE");
		 //some one setfont for label
		 H2label.setHorizontalTextPosition(SwingConstants.CENTER);
		 H2label.setHorizontalAlignment(JLabel.CENTER);    //ch2
		 H2label.setVerticalAlignment(JLabel.CENTER);
		 
		 
		 
		 
		table=new JTable();
		
		setTable();
		
		Font f=new Font("Algerian",Font.BOLD,24);
		
		
		Tlabel=new JLabel("WELCOME "+u.getname().toUpperCase());
		Tlabel.setHorizontalTextPosition(SwingConstants.CENTER);
		Tlabel.setFont(f);
		
		
		frame.setLayout(new BorderLayout());
		
		
		panel1.add(Tlabel);
		frame.add(panel1, BorderLayout.NORTH);
		
		
		
		Border border=BorderFactory.createLineBorder(Color.BLACK , 1);
		//panel2.setBorder(border);
		
		
		panel21.add(S1label);
		for(int i=0; i<3; i++)
			panel21.add(S[i]);
		
		panel22.add(S2label);
		for(int i=3; i<6; i++)
			panel22.add(S[i]);
		
		panel23.add(S3label);
		for(int i=6; i<9; i++)
			panel23.add(S[i]);
		
		panel2.add(Hlabel);
		panel2.add(panel21);
		panel2.add(panel22);
		panel2.add(panel23);
		panel2.add(Templabel);
		panel2.add(Siglabel);    //ch6
		
		panelf2.add(panel2);
		
		frame.add(panelf2, BorderLayout.WEST);
		//panel3.setBorder(border);
		panel31.add(new JScrollPane(table));
		panel32.add(OKBtn);
		panel32.add(logoutBtn);
		panel33.add(H2label);
		
		panel3.add(panel33);
		panel3.add(panel31);
		panel3.add(panel32);
		
		frame.add(panel3, BorderLayout.CENTER);
		
		setFrame();
		
		frame.setVisible(true);
	}
	
	void checkStatus()
	{
		 if(u.getStatus()==-1){
			 Siglabel.setText("<html>PLEASE WAIT FOR ACTIVATION<br>OR LOGIN LATER</html>");
		     Siglabel.setBackground(Color.RED);
		 }
		 else{
			 
			 Siglabel.setText("<html><BR><CENTER>ACTIVE</CENTER></HTML>");
			 Siglabel.setBackground(Color.GREEN);
			 } 
	}

	
	void setTable()
	{
		String coln[]={"<html><center>I</center><br><center>9:00-10:00</center></html>","<html><center>II</center><br><center>10:00-11:00</center></html>","<html><center>III</center><br><center>11:00-12:00</center></html>","<html><center>IV</center><br><center>2:00-3:00</center></html>","<html><center>V</center><br><center>3:00-4:00</center></html>","<html><center>VI</center><br><center>4:00-5:00</center></html>"};
		String data[][]=new String[5][8];
	    DefaultTableModel dtm=new DefaultTableModel(data,coln);
	    
	    TableColumnModel tcm=table.getColumnModel();
	    for(int i=0;i<tcm.getColumnCount();i++)
	    {
	    	TableColumn c=tcm.getColumn(i);
	    	c.setWidth(100);
	    	tcm.addColumn(c);
	    }
	    String permanent1=(String)Obj.CSub1;
	     String permanent2=(String)Obj.CSub2;
	     
	    table.setRowHeight(50);
	    
	    table.setColumnModel(tcm);
	    table.setModel(dtm);
	    table.setCellSelectionEnabled(false);
	    table.setEnabled(false);
	    
	    
	    table.setValueAt(permanent2, 2, 1);
	    table.setValueAt(permanent2, 2, 2);
	    table.setValueAt(permanent1, 3, 4);
	    table.setValueAt(permanent1, 3, 5);
	   
	    
	    
	}
	
	class okBttnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to Confirm this timetable?", "Confirmation",JOptionPane.YES_NO_OPTION); 
        	if(reply == JOptionPane.YES_OPTION) {
        		
			try {
				setUsersStatus();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			printToLog();
			JButton b=(JButton) e.getSource();
        	b.setText("Confirmed");
        	b.setEnabled(false);
        	}
        	
        	
			
			
			
		}
		
	}
	
	private void setUsersStatus() throws IOException
	{
		u.setStatus(1);
		if(unext!=null)
		{
			unext.setStatus(0);
			if(u.getbranch().equalsIgnoreCase("IT"))
				ul.UListIT.set(pos+1, unext);
			if(u.getbranch().equalsIgnoreCase("ECE"))
				ul.UListECE.set(pos+1, unext);
		}
		if(u.getbranch().equalsIgnoreCase("IT"))
		{
			ul.UListIT.set(pos, u);
			ul.WriteListToFile("IT");
		}
		else
		{
			ul.UListECE.set(pos, u);
			ul.WriteListToFile("ECE");
		}
	}
	
	private void printToLog()
	{
		Object[] ob=new Object[]{roll,table};
		ArrayList al;
		
		FileOutputStream f1;
		 ObjectInputStream input = null;
		
		try {
			   int flag=0;
			   for(int i=0; i<9; i++)
			   {
				   if(S[i].isSelected()==true)
				   {
					   flag++;
				   }
			   }
			
			   if(flag==3)
			   {
				   for(int i=0; i<9; i++)
				   {
					   if(S[i].isSelected()==true)
					   {
						   ul.setCount(Obj, i, pos, u.getbranch());
					   }
				   }
				   if(u.getbranch().equalsIgnoreCase("IT"))
					{
						ul.WriteListToFile("IT");
					}
					else
					{
						ul.WriteListToFile("ECE");
					}
				   
			   }
			   if(flag<3)
				{
					JOptionPane.showMessageDialog(null, "One subject from each slot is a must");
				
					OKBtn.setText("Confirm TimeTable");
		        	OKBtn.setEnabled(false);
					
				}
			   else
			   {
			   
			   File f=new File("log.txt");
			   System.out.println(f.length());
			   if(f.length()!=0)
			   {
				   FileInputStream file = new FileInputStream(f);
				
            
            	 input = new ObjectInputStream(file);
				
				al=(ArrayList)input.readObject();

				file.close();
			}
			else
			{
				al=new ArrayList();
			}
			
			al.add(ob);

			f1 = new FileOutputStream("log.txt");
			ObjectOutputStream output = new ObjectOutputStream(f1);
			output.writeObject(al);
           
			
			
			f1.close();
			   }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	class loutBttnHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			 MainFrame mfrm = new MainFrame();
             
            		frame.setVisible(false);
            		frame.dispose();
			
		}
        }	
	
	
	class RB1Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    rb.setToolTipText("3 Credits");
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    table.setValueAt(text, 0, 0);
		    table.setValueAt(text, 1, 1);
		    table.setValueAt(text, 0, 3);
		    table.setValueAt(text, 4, 3);
		    
		}
		
	}
	
	class RB2Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("4 Credits");
		    table.setValueAt(text, 0, 2);
		    table.setValueAt(text, 1, 1);
		    table.setValueAt(text, 2, 4);
		    table.setValueAt(text, 0, 3);
		    
		}
		
	}
	class RB3Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("3 Credits");
		    table.setValueAt(text, 0, 0);
		    table.setValueAt(text, 2, 4);
		    table.setValueAt(text, 3, 1);
		    table.setValueAt(text, 4, 3);
		    
		}
		
	}
	class RB4Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("4 Credits");
		    table.setValueAt(text, 1, 0);
		    table.setValueAt(text, 2, 3);
		    table.setValueAt(text, 3, 2);
		    table.setValueAt(text, 4, 2);
		    
		}
		
	}
	
	class RB5Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("2 Credits");
		    table.setValueAt(text, 0, 1);
		    table.setValueAt(text, 1, 4);
		    table.setValueAt(text, 2, 3);
		    table.setValueAt(text, 4, 2);
		    
		}
		
	}
	class RB6Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("4 Credits");
		    table.setValueAt(text, 0, 1);
		    table.setValueAt(text, 1, 0);
		    table.setValueAt(text, 2, 3);
		    table.setValueAt(text, 1, 4);
		    
		}
		
	}
	
	class RB7Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("2 Credits");
		    table.setValueAt(text, 1, 5);
		    table.setValueAt(text, 4, 5);
		    table.setValueAt(text, 2, 0);
		    table.setValueAt(text, 3, 3);
		    
		}
		
	}
	
	class RB8Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("4 Credits");
		    table.setValueAt(text, 0, 3);
		    table.setValueAt(text, 1, 5);
		    table.setValueAt(text, 3, 3);
		    table.setValueAt(text, 4, 4);
		    
		}
		
	}
	
	class RB9Handler implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
		    JRadioButton rb=(JRadioButton)e.getSource();	
		    
		    String text;
		    if(rb.isSelected()==true)
		    	text=rb.getText();
		    else text="";
		    rb.setToolTipText("3 Credits");
		    table.setValueAt(text, 0, 3);
		    table.setValueAt(text, 2, 0);
		    table.setValueAt(text, 3, 3);
		    table.setValueAt(text, 4, 5);
		    
		}
		
	}
	
	
		
private void setFrame()
	{
		if(Siglabel.getBackground()==Color.RED)
		{
			for(int i=0; i<9; i++)
				S[i].setEnabled(false);
			
			OKBtn.setEnabled(false);
		}
		else
		{
		for(int i=0; i<9; i++)
		{
			if((Integer)u.Obj.count.get(i)>3)
			{
				S[i].setEnabled(false);
				//System.out.println((Integer)Obj.count.get(i));
				S[i].setToolTipText("Class Full");
			}
		}
		}
	}
	
}
