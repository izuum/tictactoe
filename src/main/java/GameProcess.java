import java.util.Scanner;

public class GameProcess {

    Board board = new Board();

    void startGame() {
        printBoard();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи куда поставить крестик! (1-9)");
        playerTurn(scanner);
    }

    private void printBoard() {
        System.out.println(board);
    }

    private void playerTurn(Scanner scanner) {
        char[][] gameBoard = board.getBoard();
        String userInput = scanner.nextLine();
        switch (userInput) {
            case "1" -> gameBoard[0][0] = 'x';
            case "2" -> gameBoard[0][1] = 'x';
            case "3" -> gameBoard[0][2] = 'x';
            case "4" -> gameBoard[1][0] = 'x';
            case "5" -> gameBoard[1][1] = 'x';
            case "6" -> gameBoard[1][2] = 'x';
            case "7" -> gameBoard[2][0] = 'x';
            case "8" -> gameBoard[2][1] = 'x';
            case "9" -> gameBoard[2][2] = 'x';
            default -> System.out.println(":(");
        }
        board.setBoard(gameBoard);
        printBoard();
    }

    private boolean isValidMove(Board board, int position) {
        char[][] gameBoard = board.getBoard();
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
    }

}
