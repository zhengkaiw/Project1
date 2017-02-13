import java.util.Scanner;

/**
 * Created by zhengkevin on 2/12/17.
 */

public class TicTacToeTest {
    public static void main(String[] args) {

        TicTacToe ttt;
        int result = 0;

        System.out.println("----------------------------");
        System.out.println("Hello! Welcome to TicTacToe");
        System.out.println("----------------------------");

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Please tell me about the size of this NxN board:");
            int sizeofBoard = 0;
            while (true) {
                sizeofBoard = scanner.nextInt();
                if (sizeofBoard < 2) {
                    System.out.println("Input wrong! Please input a number larger than 1:");
                } else {
                    break;
                }
            }

            ttt = new TicTacToe(sizeofBoard);
            System.out.println("Succeed! Now let the game begin!");
            ttt.initializeBoard();
            ttt.setMark("X");

            while (true) {
                ttt.printBoard();
                System.out.println("Now it's time for Player " + ttt.getMark() + " to play.");
                while (true) {
                    System.out.println("Please input the number to mark:");
                    String mark = scanner.next();
                    if (ttt.placeMark(mark)) {
                        if(ttt.checkForWin(ttt.getMark())) {
                            System.out.println("-----------------------------------------");
                            System.out.println("Congratulations! Player " + ttt.getMark() + " wins the game!");
                            System.out.println("-----------------------------------------");
                            result = 1;
                            break;
                        }
                        else if (ttt.isBoardFull()) {
                            System.out.println("-------------------------");
                            System.out.println("Tie! No one win the game");
                            System.out.println("-------------------------");
                            result = 1;
                            break;
                        }
                        else{
                            ttt.changePlayer();
                            break;
                        }
                    }
                }
                if (result == 1) {
                    ttt.printBoard();
                    break;
                }
            }
            System.out.println("Game over!");
            result = 0;
        }
    }
}
