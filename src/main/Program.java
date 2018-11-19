package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Admin;
import model.Computer;
import model.Player;

public class Program {

	private static Scanner sc;
	private static Scanner sc2;
	private static Admin admin;
	private static Scanner sc3;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.out.println("------------------Suc Sac Start!-----------------");
		Run();
	}

	public static int caculPlayer() throws InterruptedException {
		sc = new Scanner(System.in);
		int sum;
		while (true) {
			System.out.println("How many people play this turn? (Form 1 to 4)");
			sum = sc.nextInt();
			if (sum >= 1 && sum <= 4) {
				return sum;
			}
			System.out.println("Your input incorrect. Try againt!");
		}
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static ArrayList<Player> listPlayers() throws InterruptedException {
		int caculPlayer = caculPlayer();
		ArrayList<Player> players = new ArrayList<Player>();
		String name;
		sc2 = new Scanner(System.in);
		for (int i = 0; i < caculPlayer; i++) {
			System.out.println("Input name of player number " + (i + 1));
			Player player = new Player();
			name = sc2.next();
			player.setName(name);
			players.add(player);
		}
		for (int i = 0; i < 4 - caculPlayer; i++) {
			Computer com = new Computer();

			com.setName("Computer " + (i + 1));
			players.add(com);
		}

		return players;
	}

	public static void Run() throws InterruptedException, IOException {
		admin = new Admin();
		ArrayList<Player> list = listPlayers();
		Boolean conGame = true;
		int count = list.size();
		sc3 = new Scanner(System.in);
		while (conGame) {
			System.out.println("List Player with point: ");

			for (Player player : list) {
				System.out.println(player.Name() + "  ---  " + player.Point() + " point.");
				if (player.Point() == 21)
					conGame = false;
			}

			System.out.println("Admin chose a player for play game : (Chose form 1 to 4)");
			int index = sc3.nextInt();
			Player player = admin.forcusPlayer(list, index);

			System.out.println("Player " + player.Name() + " chose dice by random. Press enter to chose");

			int dice = player.getDice();
			System.in.read();

			System.out.println("Player " + player.Name() + " chcose dice number " + dice);

			System.out.println("Playing........ ");
			Thread.sleep(400);
			System.in.read();

			int throwPoint = player.throwDice(dice);

			System.out.println("Player " + player.Name() + " got " + throwPoint + " point!");
			admin.caculPoint(player, throwPoint);
			System.out.println("Press enter to continues...");
			System.in.read();
		
//			player.setPoints(21);
			if (player.Point() == 21)
				conGame = false;
		}

		admin.endGame(list);
	}
}
