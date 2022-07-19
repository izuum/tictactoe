import java.util.Random;
import java.util.Scanner;

public class GameProcess {

    Board board = new Board();

    void startGame() {
        Scanner scanner = new Scanner(System.in);

        while(true){
            playerTurn(scanner);
            if(isGameFinished(board.getBoard())){
                break;
            }
            computerTurn();
            if(isGameFinished(board.getBoard())){
                break;
            }
        }

//        scanner.close();
    }

    private boolean isGameFinished(char[][] board) {
        if(findWinner(board, 'X')){
            printBoard();
            System.out.println("Player Wins!");
            return true;
        }else if(findWinner(board, 'O')){
            printBoard();
            System.out.println("Computer Wins!");
            return true;
        }else {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == ' ')
                        return false;
                }
            }
            System.out.println("Игра закончилась ничьей");
            return true;
        }
    }

    private boolean findWinner(char[][] board, char symbol) {
        if((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)){
            return true;
        }else{
            return false;
        }
    }

    private void computerTurn() {
        System.out.println("Ход компьютера!");
        Random rand = new Random();
        int computerMove;
        while(true){
            computerMove = rand.nextInt(9)+1;
            if (isValidMove(board, computerMove)){
                break;
            }
        }
        placeMove(Integer.toString(computerMove), 'O');
    }

    private void playerTurn(Scanner scanner){
        System.out.println("Введи куда поставить крестик! (1-9)");
        int playerChoice;
        while(true){
            playerChoice = scanner.nextInt();
            if (isValidMove(board, playerChoice)){
                break;
            }else{
                System.out.println("Эта клетка уже занята, попробуй другую!");
                printBoard();
            }
        }
        placeMove(Integer.toString(playerChoice), 'X');
    }

    private void printBoard() {
        System.out.println(board);
    }

    private void placeMove(String playerChoice, char symbol) {
        char[][] gameBoard = board.getBoard();
        switch (playerChoice) {
            case "1" -> gameBoard[0][0] = symbol;
            case "2" -> gameBoard[0][1] = symbol;
            case "3" -> gameBoard[0][2] = symbol;
            case "4" -> gameBoard[1][0] = symbol;
            case "5" -> gameBoard[1][1] = symbol;
            case "6" -> gameBoard[1][2] = symbol;
            case "7" -> gameBoard[2][0] = symbol;
            case "8" -> gameBoard[2][1] = symbol;
            case "9" -> gameBoard[2][2] = symbol;
            default -> System.out.println("Ты ввел что-то не то:(");
        }
        board.setBoard(gameBoard);
        printBoard();
    }

    private boolean isValidMove(Board board, int position) {
        char[][] gameBoard = board.getBoard();
        if(0<position && position<10) {
            return switch (position) {
                case 1 -> (gameBoard[0][0] == ' ');
                case 2 -> (gameBoard[0][1] == ' ');
                case 3 -> (gameBoard[0][2] == ' ');
                case 4 -> (gameBoard[1][0] == ' ');
                case 5 -> (gameBoard[1][1] == ' ');
                case 6 -> (gameBoard[1][2] == ' ');
                case 7 -> (gameBoard[2][0] == ' ');
                case 8 -> (gameBoard[2][1] == ' ');
                case 9 -> (gameBoard[2][2] == ' ');
                default -> false;
            };
        }else{
            System.out.println("Ты ввел что-то не то!");
            return false;
        }
    }

}
