import java.util.ArrayList;

public class Logic {
    static boolean play = true;
    static ArrayList<String> tobechecked = new ArrayList<String>();
    static ArrayList<String> alreadychecked = new ArrayList<String>();

    public static void main(String[] args) {
        PrintBoard theboard = new PrintBoard();
        Player player = new Player();
        player.init_player();
        theboard.create_board();
        theboard.print_board();
        while (play) {
            player.edit_board();
            if (!player.flagged) {
                check_for_bombs();
                check_if_dead();
                check_if_won();
                theboard.print_board();
            } else {
                theboard.print_board();
                player.flagged = false;
            }
        }
    }

    public static void check_if_dead() {
        if (PrintBoard.mines[Player.playerVal1][Player.playerVal2] == 1 && Player.action.equals("c")) {
            System.out.println("Game Over!");
            PrintBoard.show_all_mines();
            play = false;
        }
    }

    public static void check_if_won() {
        int minecount = 0;
        for (int i=0; i<20; i++) {
            for (int j=0; j<15; j++) {
                if (PrintBoard.mines[i][j] == 0 && PrintBoard.board[i][j].equals("~~")) {
                    minecount += 1;
                }
            }
        }
        if (minecount == 0) {
            System.out.println("Congratulations, you beat Minesweeper!");
            play = false;
        }
    }

    public static void check_for_bombs() {
        tobechecked.add(Player.playerVal1 + " " + Player.playerVal2);
        while (tobechecked.size() != 0) {
            String[] temp1 = tobechecked.get(0).split(" ", 2);
            int temp2 = Integer.parseInt(temp1[0]);
            int temp3 = Integer.parseInt(temp1[1]);
            int tempcount = 0;
            for (int i=-1; i<2; i++) {
                for (int j=-1; j<2; j++) {
                    if ((temp2 + i >= 0) && (temp2 + i <= 19) && (temp3 + j >= 0) && (temp3 + j <= 14) && PrintBoard.mines[temp2 + i][temp3 + j] == 1) {
                        tempcount += 1;
                    }
                }
            }
            if (tempcount == 0) {
                PrintBoard.replace_board_character("CC", temp2, temp3);
                for (int i=-1; i<2; i++) {
                    for (int j=-1; j<2; j++) {
                        if ((temp2 + i >= 0) && (temp2 + i <= 19) && (temp3 + j >= 0) && (temp3 + j <= 14) && PrintBoard.mines[temp2 + i][temp3 + j] == 0 && !alreadychecked.contains((temp2 + i) + " " + (temp3 + j))) {
                            tobechecked.add((temp2 + i) + " " + (temp3 + j));
                            alreadychecked.add((temp2 + i) + " " + (temp3 + j));
                        }
                    }
                }
                tobechecked.remove(0);
            } else {
                PrintBoard.replace_board_character("0" + Integer.toString(tempcount), temp2, temp3);
                tobechecked.remove(0);
            }
            // System.out.println(tobechecked);
        }
    }
}
