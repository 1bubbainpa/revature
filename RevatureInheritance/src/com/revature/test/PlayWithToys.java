package com.revature.test;
import com.revature.model.ActionFigure;
import com.revature.model.Doll;

public class PlayWithToys 
{
	public static void main(String args[])
	{
		Doll doll = new Doll("Ted", "red");
		System.out.println("Eye Color: " + doll.getEyeColor());
		System.out.println("Name: " + doll.getName());
		
		doll.play();
		doll.makeTalk();
		System.out.println("\n");
		
		ActionFigure figure = new ActionFigure("Barry Allan", "blue", "Speed");
		System.out.println("Our action figure " + figure.getName() + " has " +
				figure.getEyeColor() + " eyes and the " + figure.getSkill() + " skill.");
		figure.makeTalk();
		figure.play();
		figure.useSkill();
	}
}
