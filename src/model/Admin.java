package model;

import java.util.List;

public class Admin {
	public Player forcusPlayer(List<Player> players, int stt) {
		return players.get(stt - 1);
	}

	public void caculPoint(Player player, int point) {
		player.setPoint(point);
	}

	public void endGame(List<Player> players) {
		int sum = players.size();
		for (int i = 0; i < sum; i++) {
			Player player = players.get(i);
			if (player.Point() == 21)
				System.out.println("Congrulation player number " + player.Name() + ", you are victory!");
			if (player instanceof Computer) {
				Computer com = (Computer) player;
				com.faceDisplayWhenFalse(com.isVictory());
			}
		}
	}
}
