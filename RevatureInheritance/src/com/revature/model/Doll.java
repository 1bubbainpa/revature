package com.revature.model;

public class Doll extends Toy 
{
	String eyeColor;
	
	//No args constructor
	public Doll()
	{
		this.eyeColor = "blue";
		this.name = "Monk";
	}
	
	//args constructor
	public Doll(String name, String eyeColor) 
	{
		super(name);
		this.eyeColor = eyeColor;
	}
	
	public String getEyeColor() 
	{
		return eyeColor;
	}

	public void setEyeColor(String eyeColor) 
	{
		this.eyeColor = eyeColor;
	}
	
	public void makeTalk()
	{
		System.out.println("Hello World! I AM-A doll");
	}
}
