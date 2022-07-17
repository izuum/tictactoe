public class Board {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public char[][] getBoard() {
        return board;
    }
    public void setBoard(char[][] board) {
        this.board = board;
    }

//    private static void printBoard(char[][] board){
//        System.out.println(board);
//    }
    public String toString(){
        return board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" +
                "-+-+-" + "\n" +
                board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n" +
                "-+-+-" + "\n" +
                board[2][0] + "|" + board[2][1] + "|" + board[2][2];
    }
}
