package basic;

import java.io.*;
import java.util.*;

class User implements Serializable{
	private String rollNo;
	private String name;
	private float cgpa;
	private String branch;
	Branch Obj; 
	private int status;
	
	User()
	{
		status=-1;
	}
	
	User(String rollNo)
	{
		this.rollNo=rollNo;
		
	}

	void setname(String name)
	{
		this.name=name;
	}
	
	String getname()
	{
		return this.name;
	}
	
	void setrollNo(String rollNo)
	{
		this.rollNo=rollNo;
	}
	
	String getrollNo()
	{
		return this.rollNo;
	}
	
	void setcgpa(float cgpa)
	{
		this.cgpa=cgpa;
	}
	
	float getcgpa()
	{
		return this.cgpa;
	}
	
	void setbranch(String branch)
	{
		this.branch=branch;
		
		if(branch.equalsIgnoreCase("IT"))
			Obj = new IT();
		else
			Obj = new ECE();

	}
	
	String getbranch()
	{
		return this.branch;
	}
	
	Branch getSubjects()
	{
		return Obj;
	}
	
	int getStatus()
	{
		return status;
	}
	
	void setStatus(int s)
	{
		status = s;
	}
	
}
