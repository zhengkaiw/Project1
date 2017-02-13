/**
 * Created by zhengkevin on 2/12/17.
 */

public class TicTacToe {


    private int size;                                           //The size of board
    private String[][] board;
    private String mark;                                        // X or O

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public TicTacToe(int size) {                                //Structure for initialize the board
        setSize(size);
        initializeBoard();
    }

    public void initializeBoard() {                             //Initialize the board with number

        int count = 1;
        board = new String[getSize()][getSize()];

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                board[i][j] = String.valueOf(count);
                count++;
            }
        }

    }

    public void printBoard() {                                  //Print out the board

        for (int s = 0; s < (getSize() + (getSize() - 1) * 2); s++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (board[i][j].equals("X") || board[i][j].equals("O")) {   //Just for looking nice
                    System.out.print(board[i][j] + "  ");
                }
                else if(Integer.parseInt(board[i][j]) < 10){
                    System.out.print(board[i][j] + "  ");
                }
                else {
                    System.out.print(board[i][j] + " ");
                }

            }
            System.out.println();
        }
        for (int s = 0; s < (getSize() + (getSize() - 1) * 2); s++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public boolean isBoardFull() {                                          //Check if the board is full

        int count = 0;
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (board[i][j].equals("X") || board[i][j].equals("O")) {
                    count++;
                }
            }
        }
        if (count == (getSize() * getSize())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkForWin(String mark) {                              //Check if someone wins

        int count = 0;

        for (int i = 0; i < getSize(); i++) {               //For row
            for (int j = 0; j < getSize(); j++) {
                if (board[i][j].equals(mark)) {
                    count++;
                }
            }
            if (count == getSize()) {
                return true;
            } else {
                count = 0;
            }
        }

        for (int i = 0; i < getSize(); i++) {               //For column
            for (int j = 0; j < getSize(); j++) {
                if (board[j][i].equals(mark)) {
                    count++;
                }
            }
            if (count == getSize()) {
                return true;
            } else {
                count = 0;
            }
        }


        for (int i = 0; i < getSize(); i++) {               //For \
            if (board[i][i].equals(mark)) {
                count++;
            }
        }

        if (count == getSize()) {
            return true;
        } else {
            count = 0;
        }

        int j = getSize() - 1;

        for (int i = 0; i < getSize(); i++) {              //For /
            if (board[i][j].equals(mark)) {
                count++;
            }
            j--;
        }

        if (count == getSize()) {
            return true;
        } else {
            return false;
        }

    }

    public void changePlayer() {                          //Change X and O back and forth
        if (getMark().equals("X")) {
            setMark("O");
        } else {
            setMark("X");
        }
    }

    public boolean placeMark(String num) {                //For place the mark on the board

        int count = 0;

        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                if (board[i][j].equals(num)) {
                    board[i][j] = getMark();
                    count++;
                }
            }
        }

        if (count == 1) {
            return true;
        } else {
            System.out.println("Wrong move! Please place it again");
            return false;
        }
    }
}
