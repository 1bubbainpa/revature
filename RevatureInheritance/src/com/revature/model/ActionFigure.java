package com.revature.model;

public class ActionFigure extends Doll 
{
	private String skill;

	public ActionFigure()
	{
		this.name = "Orimage";
		this.eyeColor = "teal";
		this.skill = "Foresight";
	}
	
	public ActionFigure(String name, String eyeColor, String skill)
	{
		this.name = name;
		this.eyeColor = eyeColor;
		this.skill = skill;
	}
	
	public String getSkill() 
	{
		return skill;
	}

	public void setSkill(String skill)
	{
		this.skill = skill;
	}
	
	public void useSkill()
	{
		System.out.println("Activating my Super Special Ability: " + skill + "!");
	}
}
