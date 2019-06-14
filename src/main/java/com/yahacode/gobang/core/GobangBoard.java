package com.yahacode.gobang.core;

import com.yahacode.gobang.consts.GobangConst;

/**
 * 棋局
 *
 * @author zengyongli 2019-06-03
 */
public class GobangBoard {

    private boolean running;

    private int step;

    private int width;

    private Move[][] board;

    private Piece currentPiece = Piece.BLACK;

    public GobangBoard(int width) {
        this.width = width;
        init();
    }

    public void init() {
        this.step = 0;

        this.board = new Move[width][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                this.board[i][j] = null;
            }
        }
        this.running = true;
    }

    public boolean canPlay(int i, int j) {
        return (this.running && this.board[i][j] == null);
    }

    public boolean canPlayWithBalanceBreaker(int i, int j) {
        if (this.board[i][j] != null) {
            return false;
        } else if (isLongConnect(i, j, this.currentPiece)) {
            return false;
        }
        return true;
    }

    /**
     * 长连
     *
     * @param i
     * @param j
     * @param side
     * @return
     */
    private boolean isLongConnect(int i, int j, Piece side) {
        if (piecesOfRow(i, j, side) > GobangConst.PIECES_OF_WIN) {
            return true;
        } else if (piecesOfColumn(i, j, side) > GobangConst.PIECES_OF_WIN) {
            return true;
        } else if (piecesOfLeftDiagonal(i, j, side) > GobangConst.PIECES_OF_WIN) {
            return true;
        } else if (piecesOfRightDiagonal(i, j, side) > GobangConst.PIECES_OF_WIN) {
            return true;
        }
        return false;
    }

    private boolean isThreeAndThree(int i, int j, char side) {
        return false;
    }

    public Piece play(int i, int j) {
        this.board[i][j] = new Move(currentPiece, ++step);
        changeSide();
        return this.board[i][j].getPiece();
    }

    public boolean isWin(int i, int j, Piece side) {
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

    private int piecesOfRow(int i, int j, Piece side) {
        int counter = 1;
        for (int k = i + 1; k < this.width; k++) {
            if (this.board[k][j] != null && this.board[k][j].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (this.board[k][j] != null && this.board[k][j].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private int piecesOfColumn(int i, int j, Piece side) {
        int counter = 1;
        for (int k = j + 1; k < this.width; k++) {
            if (this.board[i][k] != null && this.board[i][k].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = j - 1; k >= 0; k--) {
            if (this.board[i][k] != null && this.board[i][k].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private int piecesOfLeftDiagonal(int i, int j, Piece side) {
        int counter = 1;
        for (int k = i - 1, l = j - 1; k >= 0 && l >= 0; k--, l--) {
            if (this.board[k][l] != null && this.board[k][l].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = i + 1, l = j + 1; k < width && l < width; k++, l++) {
            if (this.board[k][l] != null && this.board[k][l].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private int piecesOfRightDiagonal(int i, int j, Piece side) {
        int counter = 1;
        for (int k = i + 1, l = j - 1; k < this.width && l >= 0; k++, l--) {
            if (this.board[k][l] != null && this.board[k][l].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        for (int k = i - 1, l = j + 1; k >= 0 && l < this.width; k--, l++) {
            if (this.board[k][l] != null && this.board[k][l].getPiece() == side) {
                counter++;
            } else {
                break;
            }
        }
        return counter;
    }

    private void changeSide() {
        this.currentPiece = (this.currentPiece == Piece.BLACK ? Piece.WHITE : Piece.BLACK);
    }

    public Move[][] getBoard() {
        return this.board;
    }

    public Piece getCurrentPiece() {
        return this.currentPiece;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void endBoard() {
        this.running = false;
    }

    public int getStep() {
        return this.step;
    }

    public int getWidth() {
        return width;
    }
}
