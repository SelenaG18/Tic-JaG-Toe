import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	Integer menu = 0, score = 0, luck = 0, bot = 0, input = 0, check = 0;
	String name = "", pass = "",name2 = "";
	char [] arrGame = new char [9];
	String [] player1 = new String [5];
	String [] player2 = new String [5];
	ArrayList<String> nameList = new ArrayList<>();
	ArrayList<String> passList = new ArrayList<>();
	ArrayList<Integer> scoreList = new ArrayList<>();
	Random rand = new Random();
	


	public Main() {
		
		do {
			System.out.println("=================");
			System.out.println("|  Tic-JaG-Toe  |");
			System.out.println("=================");
			System.out.println("| 1. Login      |");
			System.out.println("| 2. Register   |");
			System.out.println("| 3. Exit       |");
			System.out.println("=================");
			System.out.print("Choose [1-3] >> ");
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
			} scan.nextLine();
			switch (menu) {
			case 1:
				LoginMenu();
				System.out.println("");
				break;
			case 2:
				RegistMenu();
				System.out.println("");
				break;
			case 3:
				break;
			default:
				System.out.println("[!] Only numeric between 1 and 3");
				break;
			}
		} while (menu != 3);
		
		
	}

	private void RegistMenu() {
		
		while (true) {
			System.out.print("Input name to play [more than 3 and less than 15 characters] : ");
			name = scan.nextLine();
			if (name.length()>3 && name.length()<15) {
				break;
			}
		} nameList.add(name);
		scoreList.add(score);
		
		while (true) {
			System.out.print("Input password [alphanumeric & more than 5 characters] : ");
			pass = scan.nextLine();
			if(pass.length()>5) {
				break;
			}
		} passList.add(pass);
		
		System.out.println("[*] Successfully registered  an account");
		System.out.print("Press enter to continue...");
		scan.nextLine();
	}

	private void LoginMenu() {
		
		
		while (true){
				
			System.out.print("Input name [type '0' to go back]: ");
			name = scan.nextLine();
			
			if (name.equals("0"))
				break;
			
			System.out.print("Input password [type '0' to go back]: ");
			pass = scan.nextLine();
			
			if (pass.equals("0"))
				break;
				
			if (nameList.indexOf(name) != -1 && passList.indexOf(pass) != -1 && nameList.indexOf(name) == passList.indexOf(pass)) {
				System.out.println("");
				gameMenu();
				break;
			} else {
				System.out.println("\nYou're account is not valid, \nplease register if you don't have any account\n");
			} 
		} 
		
	}

	private void gameMenu() {


		do {
			System.out.println("=================");
			System.out.println("|  Tic-JaG-Toe  |");
			System.out.println("=================");
			System.out.println("| 1. Play       |");
			System.out.println("| 2. Scoreboard |");
			System.out.println("| 3. Back       |");
			System.out.println("=================");
			System.out.print("Choose [1-3] >> ");
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
			} scan.nextLine();
			switch (menu) {
			case 1:
				PlayMenu();
				break;
			case 2:
				ScoreBoardMenu();
				break;
			case 3:
				break;
			default:
				System.out.println("[!] Only numeric between 1 and 3");
				break;
			}
		} while (menu != 3);
		
		
	}

	private void PlayMenu() {
		
		arrGame [0] = '1';
		arrGame [1] = '2';
		arrGame [2] = '3';
		arrGame [3] = '4';
		arrGame [4] = '5';
		arrGame [5] = '6';
		arrGame [6] = '7';
		arrGame [7] = '8';
		arrGame [8] = '9';
		player1 [0] = "      ";
		player1 [1] = "      ";
		player1 [2] = "      ";
		player1 [3] = "      ";
		player1 [4] = "      ";
		player2 [0] = "      ";
		player2 [1] = "      ";
		player2 [2] = "      ";
		player2 [3] = "      ";
		player2 [4] = "      ";
		check = 0;
		
		do {
			System.out.println("=========================");
			System.out.println("|     Player Detail     |");
			System.out.println("=========================");
			System.out.println("| Name  : " + name + "\t|");
			System.out.println("| Score :" + score + "\t\t|");
			System.out.println("=========================");
			System.out.println("|   SELECT DIFFICULTY   |");
			System.out.println("=========================");
			System.out.println("| 1. Easy               |");
			System.out.println("| 2. Hard               |");
			System.out.println("| 3. PvP                |");
			System.out.println("| 4. Back               |");
			System.out.println("=========================");
			System.out.print("Choose [1-4] >> ");
			try {
				menu = scan.nextInt();
			} catch (Exception e) {
			} scan.nextLine();
			switch (menu) {
			case 1:
				EasyGame();
				break;
			case 2:
				HardGame();
				break;
			case 3:
				PvPGame();
				break;
			case 4:
				break;
			default:
				System.out.println("[!] Only numeric between 1 and 4");
				break;
			}
		} while (menu!=4);
		
	}

	private void PvPGame() {
		
		LoginMenu2();
		
		luck = rand.nextInt(100);
		
		
		if (luck >= 0 && luck<=50) { //computer first
			
			BoardGameName();
			
		} else { //player first

			BoardGameName2();
		
		}
		
		if (check == 5) {
			scoreList.set(scoreList.get(nameList.indexOf(name)), (score+10));
			scoreList.set(scoreList.get(nameList.indexOf(name2)), (score-10));
		} else if (check == 4) {
			scoreList.set(scoreList.get(nameList.indexOf(name)), (score-10));
			scoreList.set(scoreList.get(nameList.indexOf(name2)), (score+10));
		}
		
		
	}

	private void BoardGameName2() {
		int a = 0;
		
		while (true) {
			
			System.out.println(name2+" Turn :");
			CurrentBoardPvP();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'O';
					player2[a] = "O on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			
			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] "+name+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] "+name2+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			System.out.println(name+" Turn :");
			CurrentBoardPvP();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'X';
					player1[a] = "X on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			a++;
			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] "+name+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] "+name2+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}

		}
		
	}

	private void BoardGameName() {
		int a = 0;
		
		while (true) {
			
			System.out.println(name+" Turn :");
			CurrentBoardPvP();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'X';
					player1[a] = "X on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}

			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] "+name+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] "+name2+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			System.out.println(name2+" Turn :");
			CurrentBoardPvP();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'O';
					player2[a] = "O on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			a++;
			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] "+name+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] "+name2+" Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}

		}
		
	}

	private void CurrentBoardPvP() {
		
		System.out.println("|   |   |   | "+name+" Moves || "+name2+" Moves |");
		System.out.println("| "+arrGame[0]+" | "+arrGame[1]+" | "+arrGame[2]+" |"+player1[0]+"      ||"+player2[0]+"       |");
		System.out.println("|___|___|___|"+player1[1]+"      ||"+player2[1]+"       |");
		System.out.println("|   |   |   |"+player1[2]+"      ||"+player2[2]+"       |");
		System.out.println("| "+arrGame[3]+" | "+arrGame[4]+" | "+arrGame[5]+" |"+player1[3]+"      ||"+player2[3]+"       |");
		System.out.println("|___|___|___|"+player1[4]+"      ||"+player2[4]+"       |"); 
		System.out.println("|   |   |   |            ||             |");
		System.out.println("| "+arrGame[6]+" | "+arrGame[7]+" | "+arrGame[8]+" |            ||             |");
		System.out.println("|   |   |   |            ||             |");
		
	}

	private void LoginMenu2() {
		while (true){
			
			System.out.print("Input name [type '0' to go back]: ");
			name2 = scan.nextLine();
			
			if (name.equals("0"))
				break;
			
			System.out.print("Input password [type '0' to go back]: ");
			pass = scan.nextLine();
			
			if (pass.equals("0"))
				break;
				
			if (name2.equals(name)) {
				System.out.println("[!] You can't use the same account on the second player");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				System.out.println("");
			} else if (nameList.indexOf(name2) != -1 && passList.indexOf(pass) != -1 && nameList.indexOf(name2) == passList.indexOf(pass)) {
				System.out.println("");
				break;
			} else {
				System.out.println("\nYou're account is not valid, \nplease register if you don't have any account\n");
			} 
		} 
		
	}

	private void HardGame() {
		
		luck = rand.nextInt(100);
		
		
		if (luck >= 0 && luck<=50) { //computer first
			
			BoardGameComp1();
			
		} else { //player first

			BoardGamePlayer1();
		
		}
		
		if (check == 5) {
			scoreList.set(scoreList.get(nameList.indexOf(name)), (score+100));
		} else if (check == 4) {
			if (scoreList.get(nameList.indexOf(name))!= 0) {
				scoreList.set(scoreList.get(nameList.indexOf(name)), (score - 10));
			}
		}
		
	}

	private void BoardGamePlayer1() {
		int a = 0;
		
		while (true) {
			
			System.out.println("Your Turn :");
			CurrentBoard();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'X';
					player1[a] = "X on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			
			CheckCondition();
			if (check == 5) {
				CurrentBoard();
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				CurrentBoard();
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				CurrentBoard();
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			try {
				Thread.sleep(rand.nextInt(1500)+1000);
			} catch (InterruptedException e) {
			}
			if(arrGame[4] != 'X' && arrGame[4] != 'O') {
				arrGame [4] = 'O';
			} else if (arrGame[4] == 'X'){ //pertama
				if(arrGame[7] != 'X' && arrGame[7] != 'O') {
					arrGame [7] = 'O';
				} else if (arrGame[0] == 'X') {
					if(arrGame[8] != 'X' && arrGame[8] != 'O') {
						arrGame [8] = 'O';
					}
				} else if (arrGame[1] == 'X') {
					if(arrGame[7] != 'X' && arrGame[7] != 'O') {
						arrGame [7] = 'O';
					}
				} else if (arrGame[2] == 'X') {
					if(arrGame[0] != 'X' && arrGame[0] != 'O') {
						arrGame [0] = 'O';
					} else if(arrGame[8] != 'X' && arrGame[8] != 'O') {
						arrGame [8] = 'O';
					} else if(arrGame[3] != 'X' && arrGame[3] != 'O') {
						arrGame [3] = 'O';
					}
				} else if (arrGame[8] == 'X') {
					Integer [] temp = new Integer [4];
					temp[0]=2;
					temp[1]=4;
					temp[2]=6;
					temp[3]=8;
					int randomBanget = temp[rand.nextInt(4)];
					if(arrGame[randomBanget] != 'X' && arrGame[randomBanget] != 'O') {
						arrGame [randomBanget] = 'O';
					}
				} else if (arrGame[5] == 'X') {
					if(arrGame[7] != 'X' && arrGame[7] != 'O') {
						arrGame [7] = 'O';
					}
				} else {while (true) {
					bot = rand.nextInt(9) + 1;
					if (arrGame[bot] != 'X' && arrGame[bot] != 'O') {
						arrGame[bot] = 'O';
						player2[a] = "O on " + (bot + 1);
						break;
					} 
				}
				}	
				
			}
			
			CheckCondition();
			if (check == 5) {
				CurrentBoard();
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				CurrentBoard();
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				CurrentBoard();
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			
		}
		
	}

	private void BoardGameComp1() { //belum dibenerin
		
		int a = 0;
		
		while (true) {
			try {
				Thread.sleep(rand.nextInt(1500)+1000);
			} catch (InterruptedException e) {
			}
			while (true) {
				bot = rand.nextInt(9) + 1;
				if (arrGame[bot] != 'X' && arrGame[bot] != 'O') {
					arrGame[bot] = 'O';
					player2[a] = "O on " + (bot + 1);
					break;
				} 
			}
			CurrentBoard();
			System.out.println("Computer chooses "+(bot+1));
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			CheckCondition();
			if (check == 5) {
				CurrentBoard();
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				CurrentBoard();
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				CurrentBoard();
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			System.out.println();
			
			System.out.println("Your Turn :");
			CurrentBoard();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'X';
					player1[a] = "X on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			a++;
			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
		}
	}

	private void EasyGame() {
		luck = rand.nextInt(100);
		
		
		if (luck >= 0 && luck<=50) { //computer first
			
			BoardGameComp();
			
		} else { //player first

			BoardGamePlayer();
		
		}
		
		if (check == 5) {
			scoreList.set(scoreList.get(nameList.indexOf(name)), (score+10));
		}
		
		
	}

	private void BoardGamePlayer() {
		int a = 0;
		
		while (true) {
			
			System.out.println("Your Turn :");
			CurrentBoard();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'X';
					player1[a] = "X on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			
			CheckCondition();
			if (check == 5) {
				CurrentBoard();
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				CurrentBoard();
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				CurrentBoard();
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			try {
				Thread.sleep(rand.nextInt(1500)+1000);
			} catch (InterruptedException e) {
			}
			while (true) {
				bot = rand.nextInt(9) + 1;
				if (arrGame[bot] != 'X' && arrGame[bot] != 'O') {
					arrGame[bot] = 'O';
					player2[a] = "O on " + (bot + 1);
					break;
				} 
			}
			CurrentBoard();
			System.out.println("Computer chooses " + (bot + 1));
			System.out.println("Press enter to continue...");
			scan.nextLine();
			System.out.println();
			a++;
			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 8) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
		}
	}

	private void BoardGameComp() {
		
		int a = 0;
		
		while (true) {
			try {
				Thread.sleep(rand.nextInt(1500)+1000);
			} catch (InterruptedException e) {
			}
			while (true) {
				bot = rand.nextInt(9) + 1;
				if (arrGame[bot] != 'X' && arrGame[bot] != 'O') {
					arrGame[bot] = 'O';
					player2[a] = "O on " + (bot + 1);
					break;
				} 
			}
			CurrentBoard();
			System.out.println("Computer chooses "+(bot+1));
			System.out.println("Press enter to continue...");
			scan.nextLine();
			
			CheckCondition();
			if (check == 5) {
				CurrentBoard();
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				CurrentBoard();
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				CurrentBoard();
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			
			System.out.println();
			
			System.out.println("Your Turn :");
			CurrentBoard();
			while (true) {
				System.out.print("Choose [1 - 9] >> ");
				try {
					input = scan.nextInt();
				} catch (Exception e) {
				}
				scan.nextLine();
				if (arrGame[input - 1] != 'X' && arrGame[input - 1] != 'O') {
					arrGame[input - 1] = 'X';
					player1[a] = "X on " + (input);
					break;
				} else {
					System.out.println("Invalid Move");
				} 
			}
			a++;
			
			CheckCondition();
			if (check == 5) {
				System.out.println("[*] Player Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			} else if (check == 4) {
				System.out.println("[*] Computer Wins!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
			if (a == 4) {
				System.out.println("[*] Its a tie!");
				System.out.println("Press enter to continue...");
				scan.nextLine();
				break;
			}
		}
	}

	private void CheckCondition() {
		
		if (arrGame[0]=='X' && arrGame[1]=='X' && arrGame[2]=='X') {
			check = 5;
		} else if (arrGame[0]=='X' && arrGame[4]=='X' && arrGame[8]=='X') {
			check = 5;
		} else if (arrGame[0]=='X' && arrGame[3]=='X' && arrGame[6]=='X') {
			check = 5;
		} else if (arrGame[1]=='X' && arrGame[4]=='X' && arrGame[7]=='X') {
			check = 5;
		} else if (arrGame[2]=='X' && arrGame[4]=='X' && arrGame[6]=='X') {
			check = 5;
		} else if (arrGame[3]=='X' && arrGame[4]=='X' && arrGame[5]=='X') {
			check = 5;
		} else if (arrGame[6]=='X' && arrGame[7]=='X' && arrGame[8]=='X') {
			check = 5;
		} else if (arrGame[2]=='X' && arrGame[5]=='X' && arrGame[8]=='X') {
			check = 5;
		} else if (arrGame[0]=='O' && arrGame[1]=='O' && arrGame[2]=='O') { 
			check = 4;
		} else if (arrGame[0]=='O' && arrGame[4]=='O' && arrGame[8]=='O') {
			check = 4;
		} else if (arrGame[0]=='O' && arrGame[3]=='O' && arrGame[6]=='O') {
			check = 4;
		} else if (arrGame[1]=='O' && arrGame[4]=='O' && arrGame[7]=='O') {
			check = 4;
		} else if (arrGame[2]=='O' && arrGame[4]=='O' && arrGame[6]=='O') {
			check = 4;
		} else if (arrGame[3]=='O' && arrGame[4]=='O' && arrGame[5]=='O') {
			check = 4;
		} else if (arrGame[6]=='O' && arrGame[7]=='O' && arrGame[8]=='O') {
			check = 4;
		} else if (arrGame[2]=='O' && arrGame[5]=='O' && arrGame[8]=='O') {
			check = 4;
		}
		
	}

	private void CurrentBoard() {

		System.out.println("|   |   |   | Your Moves || Enemy Moves |");
		System.out.println("| "+arrGame[0]+" | "+arrGame[1]+" | "+arrGame[2]+" |"+player1[0]+"      ||"+player2[0]+"       |");
		System.out.println("|___|___|___|"+player1[1]+"      ||"+player2[1]+"       |");
		System.out.println("|   |   |   |"+player1[2]+"      ||"+player2[2]+"       |");
		System.out.println("| "+arrGame[3]+" | "+arrGame[4]+" | "+arrGame[5]+" |"+player1[3]+"      ||"+player2[3]+"       |");
		System.out.println("|___|___|___|"+player1[4]+"      ||"+player2[4]+"       |"); 
		System.out.println("|   |   |   |            ||             |");
		System.out.println("| "+arrGame[6]+" | "+arrGame[7]+" | "+arrGame[8]+" |            ||             |");
		System.out.println("|   |   |   |            ||             |");
		
	}

	private void ScoreBoardMenu() {

		QuickSort(scoreList, 0, scoreList.size());
		
		System.out.println("=================================");
		System.out.println("| Name\t\t\t| Score |");
		System.out.println("=================================");
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println("| "+nameList.get(i)+"\t\t\t| "+scoreList.get(i)+" |");
		} System.out.println("=================================");
	}

	private void QuickSort(ArrayList<Integer> score, int low, int high) {
		if (low < high) {
			int par = partition(score,low,high);
			QuickSort(score, low, par -1);
			QuickSort(score, par+1, high);
		}
	}
	
	int partition(ArrayList<Integer> score2, int low, int high) {
		int pivot = score2.get(high);
		int i = low-1;
		for (int j = low; j < high; j++) {
			if(score2.get(j) < pivot) {
				i++;
				swab(score2, i, j);
			}
			
		}
		
		swab(score2, i+1, high);
		return i+1;
		
		
	}
	
	void swab(ArrayList<Integer> score2, int i, int j) {
		
		int temp = score2.get(i);
		score2.set(i, score2.get(j));
		score2.set(j, temp);
	}

	public static void main(String[] args) {
		try {
			new Main();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
