import java.util.ArrayList;
import java.util.ListIterator;

public class Logic {
    boolean play = true;
    int minecount = 0;
    ListIterator<Book> tobechecked = new books.ListIterator();
    ListIterator<Book> alreadychecked = new books.ListIterator();

    public void check_if_dead() {
        if (PrintBoard.mines[Player.playerVal1][Player.playerVal2] == 1 && Player.action.equals("c")) {
            System.out.println("Game Over!");
            PrintBoard.show_all_mines();
            play = false;
        }
    }
    public void check_if_won() {
        for (int i=0; i<20; i++) {
            for (int j=0; j<15; j++) {
                if (PrintBoard.mines[i][j] == 0 && !PrintBoard.board[i][j].equals("🟩")) {
                    minecount += 1;
                }
            }
        }
        if (minecount == 0) {
            System.out.println("Congratulations, you beat Minesweeper!");
            play = false;
        }
    }
    public void check_for_bombs() {
        tobechecked.add(Player.playerVal1 + " " + Player.playerVal2);
        for (int a=0; a<tobechecked.size(); a++) {
            for (int i=0; i<1; i++) {
                for (int j=0; j<1; j++) {
                }
            }
        }
    }
}
