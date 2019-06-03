package com.yahacode.gobang;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangBoard {

    private int width;

    private int height;

    private char[][] board;

    private char currentPiece = 'B';

    public GobangBoard(int width, int height) {
        this.width = width;
        this.height = height;

        board = new char[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char play(int i, int j) {
        board[i][j] = currentPiece;
        changeSide();
        return board[i][j];
    }

    private void changeSide() {
        currentPiece = (currentPiece == 'B' ? 'W' : 'B');
    }

    public char[][] getBoard() {
        return this.board;
    }

    public char getCurrentPiece() {
        return this.currentPiece;
    }
}
