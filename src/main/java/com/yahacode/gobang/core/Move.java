package com.yahacode.gobang.core;

/**
 * 落子
 *
 * @author zengyongli 2019-06-14
 */
public class Move {

    private Piece piece;

    private int step;

    public Move() {
    }

    public Move(Piece piece, int step) {
        this.piece = piece;
        this.step = step;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
