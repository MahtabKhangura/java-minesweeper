import java.util.Scanner;

public class Player {
  static String playerName;
  static String action;
  static int playerVal1, playerVal2;
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    // PrintBoard board = new PrintBoard();
    // board.create_board();
    // board.generate_mines(10, 10);
    // board.print_board();
    // init_player();
    // edit_board();
    // board.print_board();
  }

  public static void init_player() {
    System.out.print("Welcome to minesweeper. What is your name? ");
    playerName = sc.nextLine();
    System.out.println("Hello " + playerName);
  }

  public static void edit_board() {
    String[] playerVal;

    while(true) {
      try {
        System.out.println("Where do you want to check or flag? Enter check (c) or flag (f) and the coordinates of the desired cell (row, column)");
        playerVal = sc.nextLine().split(" ", 3);
        action = playerVal[0];
        playerVal1 = Integer.parseInt(playerVal[1]) - 1;
        playerVal2 = Integer.parseInt(playerVal[2]) - 1;
        
        if ((action.equals("c") || action.equals("f")) && playerVal1 <= PrintBoard.board.length && playerVal2 <= PrintBoard.board[playerVal1].length && PrintBoard.board[playerVal1][playerVal2] == "~~") {
          if (action.equals("c")) {
            PrintBoard.replace_board_character("CC", playerVal1, playerVal2);
          } else {
            PrintBoard.replace_board_character("FF", playerVal1, playerVal2);
          }
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } catch (Exception e) {
        action = "";
        playerVal1 = playerVal2 = -1;
        playerVal = new String[2];
        System.out.println("invalid input. Please try again.");
      }
    }
  }
}
