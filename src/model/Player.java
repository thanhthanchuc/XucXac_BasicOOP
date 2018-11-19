package model;

import java.util.Random;

public class Player {
	//Tên người chơi
	private String name;
	
	//Điểm số của bất kì người chơi nào khi được khởi tạo cũng = 0
	private int point = 0;
	
//	public void setPoints(int point) {
//		this.point = point;
//	}
	
	private boolean isVictory = this.point == 21 ? true : false;

	public boolean isVictory() {
		return isVictory;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String Name() {
		return this.name;
	}

	public int Point() {
		return point;
	}

	public void setPoint(int point) {
		this.point += point;
		if (this.point > 21) {
//			this.point = this.point - 21;//		chỗ này point bằng 0 mà
			this.point = 0;
		}
	}
	
	//Lấy xúc sắc
	public int getDice() {
		Random rd = new Random();
		return 1 + rd.nextInt(4);
	}
	
	
	public int getPointDice() {
		Random rd = new Random();

		return 1 + rd.nextInt(100);
	}
	
	//Lấy điểm xúc sắc
	public int throwDice(int dice) {
		int pointDice = getPointDice();
		switch (dice) {
		case 1:
			if (pointDice >= 1 && pointDice < 20)
				return 1;
			else
				return (pointDice - 20) / 16 + 1;
		case 2:
			if (pointDice >= 16 && pointDice < 36)
				return 2;
			else
				return (pointDice - 20) / 16 + 1;
		case 3:
			if (pointDice >= 32 && pointDice < 52)
				return 3;
			else
				return (pointDice - 20) / 16 + 1;
		case 4:
			if (pointDice >= 46 && pointDice < 56)
				return 4;
			else
				return (pointDice - 20) / 16 + 1;
		default:
			if (pointDice == 100)
				return 6;
			else
				return pointDice / 16 + 1;
		}
	}

}
