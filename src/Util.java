import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Reuben
 * A collection of utility methods for a Tic-Tac-Toe program
 */
public class Util {

    static int numRows = 3;
    static int numColumns = 3;



    public static void drawField(){
        StdDraw.setCanvasSize(400, 500);
        StdDraw.setXscale(0, 400);
        StdDraw.setYscale(0, 500);
        StdDraw.line(-1, -50, -1, 550);
        StdDraw.line(0, 101, 500, 101);
        //vertical lines
        StdDraw.line(150, 150, 150, 450);
        StdDraw.line(250, 150, 250, 450);
        //horizontal lines
        StdDraw.line(50, 250, 350, 250);
        StdDraw.line(50, 350, 350, 350);
    }

    public void mouseClicked(java.awt.event.MouseEvent evt) {
        // called when the main mouse button is
        // clicked and released
    }

    public static void clearText(){
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledRectangle(225, 25, 225, 75);
    }

    public static void print(String string){
        clearText();
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.text(200, 50, string);
    }
    
    public static void placeMove(int row, int column, int turn){
        StdDraw.text(column * 100 + 100, 600 - (row * 100 + 200), (turn%2 == 0)?("O"):("X"));
    }

    public static void clear(){
        StdDraw.clear();
    }

    public static void startNewGame(){

    }
    public static char[][] modBoard(char[][] board, int row, int column, int turn){
        board[row][column] = (turn%2 == 0)?('O'):('X');
        return board;
    }

    public static boolean checkEmpty(char[][] board, int row, int column){
        return (board[row][column] == ' ');
    }

    public static boolean checkWin(char[][] board) {
        for(int row = 0; row < numRows; row++) {
            if (board[row][0] == board[row][1] && board[row][1] == board[row][2] && board[row][0] != ' '){
                return true;
            }
        }
        for(int column = 0; column < numColumns; column++) {
            if (board[0][column] == board[1][column] && board[1][column] == board[2][column]  && board[0][column] != ' ') {
                return true;
            }
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') || (board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[1][1] != ' ');
    }

    public static boolean checkDraw(char[][] board){
        for(int row = 0; row < numRows; row++){
            for(int column = 0; column < numColumns; column++){
                if(board[row][column] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
