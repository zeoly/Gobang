package com.yahacode.gobang.core;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangBoard {

    private int width;

    private char[][] board;

    private char currentPiece = 'B';

    public GobangBoard(int width) {
        this.width = width;

        board = new char[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public char play(int i, int j) {
        board[i][j] = currentPiece;
        changeSide();
        return board[i][j];
    }

    public boolean isWin(int i, int j, char side) {
        if (piecesOfRow(i, j, side) >= 5) {
            System.out.println(side + " row pieces: " + piecesOfRow(i, j, side));
            return true;
        } else if (piecesOfColumn(i, j, side) >= 5) {
            System.out.println(side + " column pieces: " + piecesOfColumn(i, j, side));
            return true;
        } else if (piecesOfLeftDiagonal(i, j, side) >= 5) {
            System.out.println(side + " left diagonal pieces: " + piecesOfLeftDiagonal(i, j, side));
            return true;
        } else if (piecesOfRightDiagonal(i, j, side) >= 5) {
            System.out.println(side + " right diagonal pieces: " + piecesOfRightDiagonal(i, j, side));
            return true;
        }
        return false;
    }

    private int piecesOfRow(int i, int j, char side) {
        int counter = 1;
        for (int k = i + 1; k < width; k++) {
            if (board[k][j] == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (board[k][j] == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private int piecesOfColumn(int i, int j, char side) {
        int counter = 1;
        for (int k = j + 1; k < width; k++) {
            if (board[i][k] == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = j - 1; k >= 0; k--) {
            if (board[i][k] == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private int piecesOfLeftDiagonal(int i, int j, char side) {
        int counter = 1;
        for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
            if (board[k][l] == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = i + 1, l = j + 1; k < width && l < width; k++, l++) {
            if (board[k][l] == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private int piecesOfRightDiagonal(int i, int j, char side) {
        int counter = 1;
        for (int k = i + 1, l = j - 1; k < width && l >= 0; k++, l--) {
            if (board[k][l] == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = i - 1, l = j + 1; k >= 0 && l < width; k--, l++) {
            if (board[k][l] == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
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
