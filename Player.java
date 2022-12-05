import java.util.Scanner;

public class Player {
  String playerName;
  static String action;
  static int playerVal1;
  static int playerVal2;
  boolean firstMove = true;
  boolean flagged = false;
  Scanner sc = new Scanner(System.in);

  public void init_player() {
    System.out.print("Welcome to minesweeper. What is your name? ");
    playerName = sc.nextLine();
    System.out.println("Hello " + playerName + "!");
  }
  
  public void edit_board() {
    String[] playerVal;

    while(true) {
      try {
        System.out.println("Where do you want to check or flag? Enter check (c) or flag (f) and the coordinates of the desired cell (row, column).");
        playerVal = sc.nextLine().split(" ", 3);
        action = playerVal[0];
        playerVal1 = Integer.parseInt(playerVal[1]) - 1;
        playerVal2 = Integer.parseInt(playerVal[2]) - 1;
        
        if ((action.equals("c") || action.equals("f")) && playerVal1 <= PrintBoard.board.length && playerVal2 <= PrintBoard.board[playerVal1].length && (PrintBoard.board[playerVal1][playerVal2] == "~~" || PrintBoard.board[playerVal1][playerVal2] == "⛳️")) {
          if (action.equals("c")) {
            if (firstMove) {
              for (int i=0; i<20; i++) {
                for (int j=0; j<15; j++) {
                    if (PrintBoard.board[i][j].equals("⛳️")) {
                        PrintBoard.replace_board_character("~~", i, j);
                    }
                }
            }
              PrintBoard.generate_mines(playerVal1, playerVal2);
              firstMove = false;
            }
          } else {
            if (PrintBoard.board[playerVal1][playerVal2] == "~~") {
              PrintBoard.replace_board_character("⛳️", playerVal1, playerVal2);
            } else {
              PrintBoard.replace_board_character("~~", playerVal1, playerVal2);
            }
            flagged = true;
          }
          break;
        } else {
          System.out.println("Invalid input. Please try again.");
        }
      } catch (Exception e) {
        action = "";
        playerVal1 = playerVal2 = -1;
        playerVal = new String[2];
        System.out.println("Invalid input. Please try again.");
      }
    }
  }
}
