package com.yahacode.gobang.core;

/**
 * 棋子
 *
 * @author zengyongli 2019-06-04
 */
public enum Piece {

    BLACK("黑棋"), WHITE("白棋");

    private String name;

    Piece(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
