public class PrintBoard {
    static String[][] board = new String[20][15];
    public static void main(String[] args) {
        // create_board();
        // print_board();
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
}