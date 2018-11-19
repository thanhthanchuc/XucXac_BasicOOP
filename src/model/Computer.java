package model;

public class Computer extends Player {
	public void faceDisplayWhenFalse(boolean vic) {
		if(!vic)
			System.out.println("You are knock out by M24!");
	}
}
