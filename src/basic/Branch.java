package basic;

import java.io.*;
import java.util.*;

class Branch implements Serializable{
	
	protected Vector slot = new Vector(1, 9);
	protected Vector count = new Vector(9, 0);

    String CSub1;
	String CSub2; //Compulsary subjects
	Branch(){		
	}
	Branch(int create){
		
		CSub1 = "DSA";
		slot.addElement(new String("MATH"));
		slot.addElement(new String("DDCO"));
		
		
		
	}
	public void setCount()
	{
		for(int j=0; j<9; j++)
		{
			count.add(j,0);
		}
	}
	public void setCount(int pos)
	{
		int temp = (Integer)this.count.get(pos);
		temp=temp+1;
		this.count.set(pos, temp);
	}
}

class IT extends Branch {
	
	IT(){
		super(1);
		slot.addElement(new String("CloudComp"));
		slot.addElement(new String("POP"));
		slot.addElement(new String("Unix"));
		slot.addElement(new String("ParaComp"));
		slot.addElement(new String("DBMS"));
		slot.addElement(new String("Networks"));
		slot.addElement(new String("OS")); //Operating System
		slot.setSize(14);
		
		CSub2 = "TheoryOfComp";
		
	}

}

class ECE extends Branch {
	
	ECE()
	{
			super(1);
			slot.addElement(new String("Power Electronics"));
			slot.addElement(new String("Analog Electronics"));
			slot.addElement(new String("Digital Electronics"));
			slot.addElement(new String("EM Waves"));
			slot.addElement(new String("DSA"));
			slot.addElement(new String("CO"));
			slot.addElement(new String("Networking")); //Operating System
			CSub2 = "Linear Systems";
	}
	
}
