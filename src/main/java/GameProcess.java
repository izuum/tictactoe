import java.util.Random;
import java.util.Scanner;

public class GameProcess {

    Board board = new Board();

    void startGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            playerTurn(scanner);
            if (isGameFinished(board.getBoard())) {
                break;
            }
            computerTurn();
            if (isGameFinished(board.getBoard())) {
                break;
            }
        }
        scanner.close();
    }

    private boolean isGameFinished(char[][] board) { // определяем закончилась ли игра
        //вызываем метод для определения победителя
        if (findWinner(board, 'X')) {
            System.out.println("Player Wins!");
            return true;
        } else if (findWinner(board, 'O')) {
            System.out.println("Computer Wins!");
            return true;
        } else {
            //если победителя нет, то проверяем все ли клетки доски заполнены
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    //если не все, то возвращаемся в игру
                    if (board[i][j] == ' ')
                        return false;
                }
            }
            //если все клетки заполнены, но победителя нет, то ничья
            System.out.println("Игра закончилась ничьей!");
            return true;
        }
    }

    private boolean findWinner(char[][] board, char symbol) {
        /*определяем победителя, сравнивая есть ли кейсы когда
        мы имеем 3 символа "Х" или 3 символа "О" подряд в ряд по вертикали,
        горизонтали или диагонали*/
        return (board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol) ||
                (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol) ||
                (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol) ||
                (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol) ||
                (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

                (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    private void computerTurn() {
        /* Компьютер ходит благодаря случайному выбору клетки.
           Ход проверяется на валидность (введена ли цифра, попадает ли она
           в диапазон нужных значений, свободна ли клетка в которую компьютер хочет поставить "О") */
        System.out.println("Ход компьютера!");
        Random rand = new Random();
        String computerMove;
        while (true) {
            computerMove = Integer.toString(rand.nextInt(9) + 1);
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
        placeMove(computerMove, 'O');
    }

    private void playerTurn(Scanner scanner) {
        /* ход игрока проверяется на валидность (введена ли цифра, попадает ли она
           в диапазон нужных значений, свободна ли клетка в которую игрок хочет поставить "Х") */
        String playerChoice;
        while (true) {
            System.out.println("Введи куда поставить крестик! (1-9)");
            playerChoice = scanner.nextLine();
            if (isValidMove(board, playerChoice)) {
                break;
            } else {
                System.out.println(playerChoice + " это недопустимый ход!");
                printBoard();
            }
        }
        placeMove(playerChoice, 'X');
    }

    private void printBoard() { //метод печатает доску
        System.out.println(board);
    }

    private void placeMove(String playerChoice, char symbol) {
        // совершаем ход путем помещения значения "Х" или "О" в выбранную клетку
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

    private boolean isValidMove(Board board, String position) { //проверяем валидность хода
        char[][] gameBoard = board.getBoard();
        if (isDigit(position)) { //проверяем введено ли число
            //проверяем, входит ли число в диапазон значение от 1 до 9
            if (0 < Integer.parseInt(position) && Integer.parseInt(position) < 10) {
                //проверяем свободна ли клетка куда игрок/компьютер хочет поставить символ
                return switch (position) {
                    case "1" -> (gameBoard[0][0] == ' ');
                    case "2" -> (gameBoard[0][1] == ' ');
                    case "3" -> (gameBoard[0][2] == ' ');
                    case "4" -> (gameBoard[1][0] == ' ');
                    case "5" -> (gameBoard[1][1] == ' ');
                    case "6" -> (gameBoard[1][2] == ' ');
                    case "7" -> (gameBoard[2][0] == ' ');
                    case "8" -> (gameBoard[2][1] == ' ');
                    case "9" -> (gameBoard[2][2] == ' ');
                    default -> false;
                };
            } else {
                return false;
            }
        }else{
            return false;
        }
    }

    private boolean isDigit(String position) { //проверка введена ли цифра
        try {
            int digit = Integer.parseInt(position);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}