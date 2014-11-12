/**
 * @author Reuben
 * A game of Tic Tac Toe for two players
 */

import java.awt.event.*;

public class Game {

    public static void main(String[] args) {

        while (true) {

            Util.clear();
            Util.drawField();

            char[][] board = {
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},
                    {' ', ' ', ' '},

            };
            int turn = 1;
            boolean gameOver = false;
            int row = 0;
            int column = 0;
            int rowChoice = 0;
            int columnChoice = 0;

            boolean waiting = true;
            boolean moveNotValid = true;

            while (!gameOver) {

                Util.print("Player " + ((turn % 2 == 0) ? ("2") : ("1")) + (", click on desired space."));

                moveNotValid = true;
                while (moveNotValid) {
                    waiting = true;
                    while (waiting) {
                       if(StdDraw.mousePressed()){
                            if (StdDraw.mouseX() < 150) {
                                columnChoice = 0;
                            } else if (StdDraw.mouseX() < 250) {
                                columnChoice = 1;
                            } else {
                                columnChoice = 2;
                            }
                            if (StdDraw.mouseY() < 250) {
                                rowChoice = 2;
                            } else if (StdDraw.mouseY() < 350) {
                                rowChoice = 1;
                            } else {
                                rowChoice = 0;
                            }

                            waiting = false;
                        }
                    }

                    if (Util.checkEmpty(board, rowChoice, columnChoice)) {
                        row = rowChoice;
                        column = columnChoice;
                        Util.modBoard(board, row, column, turn);
                        Util.placeMove(row, column, turn);
                        moveNotValid = false;
                    } else {
                        Util.print("Space already taken! Try again!");
                    }
                }

                if (Util.checkWin(board)) {
                    Util.print("Congratulations player " + ((turn % 2 == 0) ? ("2") : ("1")) + (", you win!"));
                    gameOver = true;
                }

                if (Util.checkDraw(board)) {
                    Util.print("Draw!");
                    gameOver = true;
                }

                turn++;
            }
            return;
        }
    }
}
