// Board functions: Creating, printing, replacing a displayed character, mine generation, showing all mines.

public class PrintBoard {
    static String[][] board = new String[20][15];
    static int[][] mines = new int[20][15];
    static int minecount = 0;
    public static void main(String[] args) {
        create_board();
        generate_mines(10, 10);
        show_all_mines("💣");
        print_board();
    }
    public static void create_board() {
        for (int x=0; x<20; x++) {
            for (int y=0; y<15; y++) {
                board[x][y] = "~~";
            }
        }
    }
    public static void print_board() {
        System.out.println();
        System.out.println("    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15");
        for (int x=0; x<20; x++) {
            System.out.print(" ");
            if (x<9) {
                System.out.print(" " + (x+1));
            } else {
                System.out.print((x+1));
            }
            for (int y=0; y<15; y++) {
                System.out.print(" " + board[x][y]);
            }
            System.out.print(" " + (x+1));
            System.out.println();
        }
        System.out.println("    1  2  3  4  5  6  7  8  9  10 11 12 13 14 15");
        System.out.println();
    }
    public static void replace_board_character(String newcharacter, int x, int y) {
        board[x][y] = newcharacter;
    }
    public static void generate_mines(int xstart, int ystart) {
        while (minecount < 60) {
            int x = 1 + (int)(19*Math.random());
            int y = 1 + (int)(14*Math.random());
            if (x != xstart && y != ystart && mines[x][y] != 1) {
                mines[x][y] = 1;
                minecount += 1;
            }
        }
    }
    public static void show_all_mines(String character) {
        for (int x=0; x<20; x++) {
            for (int y=0; y<15; y++) {
                if (mines[x][y] == 1) {
                    replace_board_character(character, x, y);
                }
            }
        }
    }
}