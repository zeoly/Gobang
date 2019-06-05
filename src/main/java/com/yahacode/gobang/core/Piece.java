package com.yahacode.gobang.core;

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
