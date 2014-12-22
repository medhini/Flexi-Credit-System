package basic;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentView  {
	
	private JFrame frame;
	private JTable table=new JTable();
	private JLabel label;
	private JPanel panel1,panel2;
	private JButton btnDel,btnBack;
	UserList ul=new UserList();
	public Font font1;
	public Font font2;
	public Font font3;
	public Font font4;
	
	public StudentView()
	{
		frame =new JFrame();
		frame.setSize(600, 400);
		frame.setLayout(new GridLayout(3,1));
		
		font1 = new Font("Shrif",Font.BOLD,14);
		font2 = new Font("Bradley Hand ITC",Font.BOLD,14);
		font3 = new Font("Brittanic bold",Font.ITALIC,16);
		font4=new Font("Algerian",Font.BOLD,22);
		
		panel2=new JPanel(new FlowLayout(FlowLayout.CENTER,30,20));
		panel1=new JPanel(new FlowLayout(FlowLayout.CENTER,10,20));
		btnDel=new JButton("DELETE ENTRY");
		btnBack=new JButton("GO BACK");
		label=new JLabel("STUDENT LIST");
		
		btnDel.setFont(font2);
		btnBack.setFont(font2);
		label.setFont(font4);
		setTable();
		
		Font f=new Font("Times New Roman",Font.BOLD,24);
		//label.setFont(f);
		
		panel2.add(btnDel);
		panel2.add(btnBack);
		panel1.add(label);

		deleteBttnHandler delList= new deleteBttnHandler();
        backBttnHandler backList=new backBttnHandler();
                
        btnDel.addActionListener(delList);
        btnBack.addActionListener(backList);
		
		frame.add(panel1);
	
		frame.add(new JScrollPane(table));
		frame.add(panel2);
	    frame.setVisible(true);
		
	}
	
	private void setTable()
	{
		
        
		String coln[]={"NAME","ROLL NO","CGPA","BRANCH"};
		String data[][]=new String[0][1];
	    DefaultTableModel dtm=new DefaultTableModel(data,coln);
	    
	
	    for(int i=0;i<ul.UListIT.size();i++)
	    {
	    	User u=ul.UListIT.get(i);
	    	dtm.addRow(new Object[]{u.getname(),u.getrollNo(),u.getcgpa(),u.getbranch()});
	    	//System.out.println(u.getname());
	    }
	    
	    for(int j=0;j<ul.UListECE.size();j++)
	    {
	    	User u=ul.UListECE.get(j);
	    	dtm.addRow(new Object[]{u.getname(),u.getrollNo(),u.getcgpa(),u.getbranch()});
	    	//System.out.println(u.getname());
	    }
	    
		
		table=new JTable(dtm);	
		
	}
	
	class deleteBttnHandler implements ActionListener 
	{
		 
        @Override
        public void actionPerformed(ActionEvent arg0)
        {
             
        	int index = table.getSelectedRow();
        	
        	if ( index == -1 ) 
        	{
        			JOptionPane.showMessageDialog(null, "Please Select the Student Entry to be Deleted !", "Error", JOptionPane.ERROR_MESSAGE);
        	
        	} 
        	else
        	{
        	
        		int i=0,j=0;
        		String branch = (String) table.getValueAt(index, 3);
        		String roll   = (String) table.getValueAt(index, 1);
        	
        		try 
        		{
        			ul.addToValidation(roll, 0);
        		}
        		catch (IOException e1) 
        		{
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        	
        		((DefaultTableModel)table.getModel()).removeRow(index);
        	
        		if(branch.equalsIgnoreCase("IT")) 
        		{
    			
        			while ( i < ul.UListIT.size())
        			{
    				
        				User u=ul.UListIT.get(i);
        				if ( (u.getrollNo()).equals(roll)) 
        				{
        					ul.UListIT.remove(u);break;
        				}// end of if
        				i++;
        			}// end of while
    			
        		}
    			 else
    			 {
    				
    				 while ( j < ul.UListECE.size())
    				 {
    					 
    					 User u=ul.UListECE.get(j);
    	    			if ( (u.getrollNo()).equals(roll)) {
    	    			ul.UListECE.remove(u);break;
    	    			}// end of if
    	    			j++;
    	    		}// end of while
    				 
    				 
    			 }// end of else
    	    			
    	    	try 
    	    	{
					ul.WriteListToFile(branch);
				}
    	    	catch (IOException e)
    	    	{
					e.printStackTrace();
				}
    		
        	}// end of else
        }
    }// end of delete
	
	
	class backBttnHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) 
		{

			 AdminFrame afrm = new AdminFrame();
             
            frame.setVisible(false); 
            frame.dispose();
			
		}
		
	}

}