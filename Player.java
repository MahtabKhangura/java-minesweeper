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

  public static void editBoard() {
    String[] playerVal;

    while(true) {
      try {
        System.out.println("Where do you want to check? Enter the coordinates of the desired cell (row, column)");
        playerVal = sc.nextLine().split(" ", 2);
        playerVal1 = Integer.parseInt(playerVal[0]) - 1;
        playerVal2 = Integer.parseInt(playerVal[0]) - 1;
        if (playerVal1 <= 15 && playerVal2 <= 15) {
          //push values in board array
        }
      } catch (Exception e) {
        // TODO: handle exception
      }
    }
  }
}
