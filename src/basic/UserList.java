package basic;


import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.io.*;
import java.util.*;

public class UserList{
	
	User u = new User();
	ArrayList<User> UListIT = new ArrayList<User>();
	ArrayList<User> UListECE = new ArrayList<User>();
	ArrayList<String> VList = new ArrayList<String>();
	
	
	private String UListBranch;
	private String UListRoll;
	
	UserList()
	{
		MakeList();
	}

	public void setCount(Branch Obj, int pos, int uindex, String branch)
	{
		if(branch.equalsIgnoreCase("IT"))
		{
			for(int i=uindex+1; i<UListIT.size(); i++)
				UListIT.get(i).Obj.setCount(pos);
		}
		else
		{
			for(int i=uindex+1; i<UListECE.size(); i++)
				UListECE.get(i).Obj.setCount(pos);
		}
	}
	public void WriteListToFile(String Branch) throws IOException
	{
		int tag;
		if(Branch.equalsIgnoreCase("IT"))
			tag=1;
	
		else
			tag=2;
	
		switch(tag)
		{
			case 1 :
				FileOutputStream f1;
				ObjectOutputStream output = null;
				try
				{

					f1 = new FileOutputStream("IT.txt");
					output = new ObjectOutputStream(f1);

					output.writeObject(UListIT);
		 
				}
		    catch(IOException ex)
		    {
		       //System.out.println("FILE WRITE ERROR : ");
		       //ex.printStackTrace();

		    }
		    finally
		    {
		    	output.flush();
		    }
			break;
				
		case 2 :
			FileOutputStream f2;
            ObjectOutputStream output2 = null ;
           try
           {
               f2= new FileOutputStream("ECE.txt");
               output2 = new ObjectOutputStream(f2);
            
               output2.writeObject(UListECE);
           }
           catch(IOException ex1)
           {
               //System.out.println("FILE WRITE ERROR : ");
              // ex1.printStackTrace();
           }
           finally
           {
               output2.flush();
           }
           break;
	  }
	}
	
	public void MakeList() //Obtains the user data from the file and saves it in the list
	{
			FileInputStream file;
        	ObjectInputStream input = null;
        
        try {
        	file=new FileInputStream("ECE.txt");
        	
        	File f=new File("ECE.txt");
        	if(f.length()!=0)
			{
        	input = new ObjectInputStream(file);
			
			UListECE=(ArrayList<User>) input.readObject();
			file.close();
			}
        	else UListECE=new ArrayList<User>();
			
			
			
			
			 f=new File("IT.txt");
			 if(f.length()!=0)
			{file = new FileInputStream("IT.txt");
			input = new ObjectInputStream(file);
			
			UListIT=(ArrayList<User>) input.readObject();
			
			input.close();
			file.close();
			}
			else UListIT=new ArrayList<User>();
			
			
			file = new FileInputStream("validation.txt");
			input = new ObjectInputStream(file);
			
			VList=(ArrayList<String>) input.readObject();        //changed here
			
			input.close();
			file.close();
			
			
		}
        catch (FileNotFoundException e)
        {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, e.getMessage());
		}
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, e.getMessage()+" IO");
			//e.printStackTrace();
		} 
        catch (ClassNotFoundException e)
        {
			// TODO Auto-generated catch block
		//	JOptionPane.showMessageDialog(null, e.getMessage()+"CNF");
		}
	}
	
	public void WriteUserToList(User ur)
	{
		int pos=UListIT.size();
		if(ur.getbranch().equalsIgnoreCase("IT"))
		{
			if(UListIT.isEmpty())
			{
				UListIT.add(ur);
				UListIT.get(0).setStatus(0);
			}
			else
			{
				for(int i=0; i<UListIT.size(); i++)
				{
					if(UListIT.get(i).getcgpa()<=ur.getcgpa())
					{
						pos=i;
						System.out.println(this.UListIT.get(i).getname());
						break;
					}
				}
			UListIT.add(pos,ur);
			
			if(pos==0)
			{
				UListIT.get(0).setStatus(0);
				UListIT.get(1).setStatus(-1);
			}
			}
		}
		
		else 
		{
			if(UListECE.isEmpty())
			{
				UListECE.add(ur);
				UListECE.get(0).setStatus(0);
			}
			else
			{
				for(int i=0; i<UListECE.size(); i++)
				{
					if(UListECE.get(i).getcgpa()<=ur.getcgpa())
					{
						pos=i;
						break;
					}
				}
				UListECE.add(pos,ur);
				if(pos==0)
				{
					UListECE.get(0).setStatus(0);
					UListECE.get(1).setStatus(-1);
				}
					
			}
		}	
	}
	
	void addToValidation(String roll, int flag) throws IOException
	{
		int i=0;
		
		if(flag==0) {
			while ( i < this.VList.size()) {
				
				String array[]= new String[2];
				array=this.VList.get(i).split(" ");
				if(array[0].equals(roll)&&array[1].equals(roll)) {
				this.VList.remove(i);
				}// end of if
				i++;
			}// end of while
		} 
		else VList.add(roll+" "+roll);
		
		FileOutputStream file;
		ObjectOutputStream output = null;
		try
		{

			file = new FileOutputStream("validation.txt");
			output = new ObjectOutputStream(file);

			output.writeObject(VList);
 
		}
    catch(IOException ex)
    {
       //System.out.println("FILE WRITE ERROR : ");
       //ex.printStackTrace();

    }
    finally
    {
    	output.flush();
    }
	
	}//end of addToValidation
	
	
}