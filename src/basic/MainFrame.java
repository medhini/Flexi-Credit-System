package basic;



import javax.swing.*;
import javax.swing.border.Border;






import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;


public class MainFrame {
	
	JFrame frame;
	JPanel panel1,panel2;
	JLabel backLabel,nameLabel,passwdLabel;
    JTextField nametxt;
    JPasswordField passwdtxt;
	JButton loginButton,adminButton;
	static MainFrame mframe;

	private Font font1;
	private Font font2;
	private Font font3;
	private Font font4;
	
	MainFrame()
	{
		frame=new JFrame("FLEXI CREDIT TIMETABLE CHOOSER");
		frame.setSize(600, 210);
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
		
		font1 = new Font("Shrif",Font.BOLD,14);
		font2 = new Font("Bradley Hand ITC",Font.BOLD,14);
		font3 = new Font("Brittanic bold",Font.ITALIC,16);
		font4=new Font("Algerian",Font.BOLD,16);
		
	    panel1=new JPanel();
	    panel2=new JPanel((new FlowLayout(FlowLayout.CENTER,10,20)));
		backLabel=new JLabel();
		nameLabel=new JLabel("USER-NAME");
		passwdLabel=new JLabel("PASSWORD");
		Border b=BorderFactory.createLineBorder(Color.BLACK, 1);
		nametxt=new JTextField(15);
		passwdtxt=new JPasswordField(15);
		loginButton=new JButton("LOGIN");
		adminButton=new JButton("ADMIN");
		
		adminButton.setToolTipText("Enter Admin Password in the Password Field");
		
		loginHandler loginButtonList=new loginHandler();
		adminHandler adminButtonList=new adminHandler();
		
		adminButton.addActionListener(adminButtonList);
		loginButton.addActionListener(loginButtonList);
		
		loginButton.setBackground(Color.WHITE);
		adminButton.setBackground(Color.WHITE);
		
		
		panel1.setBorder(b);
		panel2.setBorder(b);
		panel2.add(loginButton);
		panel2.add(adminButton);
		
		
		Color c=new Color(Color.TRANSLUCENT);
		
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
	
		panel1.add(nameLabel);
		panel1.add(nametxt);
		panel1.add(passwdLabel);
		panel1.add(passwdtxt);

        frame.add(panel1);
		frame.add(panel2);
		
		frame.setVisible(true);
		frame.setResizable(false);

	}
	
	class loginHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String userName,password;
			
			userName=nametxt.getText();
			password=new String(passwdtxt.getPassword());
			int flag=0;
			
			try {
				FileInputStream File = new FileInputStream("log.txt");
				
				ObjectInputStream input = new ObjectInputStream(File);
				
				ArrayList al=(ArrayList)input.readObject();
				Object[] ob;
				
				for(int i=0;i<al.size();i++)
				{
					ob=(Object[]) al.get(i);
					if(userName.equals(""+ob[0]))
					{
						flag=1;				
						break;
					}
					
					
				}
				
				
				File.close();
			} catch (FileNotFoundException ex) {
				// TODO Auto-generated catch block
				//ex.printStackTrace();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				//JOptionPane.showMessageDialog(null, ex.getMessage());
				//ex.printStackTrace();
			} catch (ClassNotFoundException ex) {
				// TODO Auto-generated catch block
				//ex.printStackTrace();
			}
		
        	
        	try {
        	 	if(validation(userName,password)==true)
			{
				if(flag==0)
				{	UserFrame uframe=new UserFrame(userName);}
				else
				{	FinalFrame ff=new FinalFrame(userName);}
				
				frame.setVisible(false);
				frame.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "The username and password does not match please re-enter");
			}
		} catch (HeadlessException e1) {
			//JOptionPane.showMessageDialog(null,e1.getMessage());
			
		} catch (IOException e1) {
			//JOptionPane.showMessageDialog(null,e1.getMessage());
		}
			
		}
		
	}
	
	class adminHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String adminPasswd=new String(passwdtxt.getPassword());
			if(adminPasswd.equals("ADMIN"))
			{
				AdminFrame aFrame=new AdminFrame();
				frame.setVisible(false);
				frame.dispose();
				
				
			}
			
		}
		
	}
	
	boolean validation(String name,String passwd) throws IOException
	{
		ArrayList<String> temp = new ArrayList<String>();
		
		FileInputStream file;
		ObjectInputStream input = null;

		 try{

		 file = new FileInputStream("validation.txt");
		 input = new ObjectInputStream(file);
		 
		 temp=(ArrayList<String>) input.readObject();
			
			input.close();
			file.close();
		 }

		 catch(IOException ex){

		// System.out.println("File Read Error");

		 ex.printStackTrace();

		 } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}

		 finally{

		 input.close();

		 }

		 int i = 0;
		 while ( i < temp.size()) {
			
			String array[]= new String[2];
			array=temp.get(i).split(" ");
			if(array[0].equals(name)&&array[1].equals(passwd)) {
			return true; 
			}
			i++;
		}
		 
		 return false;
	}
	
	public static void main(String args[])
	{
		 mframe=new MainFrame();		
		
	}
	

}
