public class Board {

    private static Board instace; // реализую паттерн Singleton
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public char[][] getBoard() {
        return board;
    }
    public void setBoard(char[][] board) {
        this.board = board;
    }

    private Board(){    }

    public static Board getInstace(){
        //метод получения одиночного обьекта Board
        if(instace == null){
            instace = new Board();
        }
        return instace;
    }
    public String toString(){
        return board[0][0] + "|" + board[0][1] + "|" + board[0][2] + "\n" +
                "-+-+-" + "\n" +
                board[1][0] + "|" + board[1][1] + "|" + board[1][2] + "\n" +
                "-+-+-" + "\n" +
                board[2][0] + "|" + board[2][1] + "|" + board[2][2];
    }
}
