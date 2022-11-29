import java.util.Scanner;

public class Player {
  static String playerName;
  static int playerVal1, playerVal2;
  static Scanner sc = new Scanner(System.in);

  public static void initPlayer() {
    System.out.print("Welcome to minesweeper. What is your name? ");
    playerName = sc.nextLine();
    System.out.println("Hello " + playerName);
  }
}
