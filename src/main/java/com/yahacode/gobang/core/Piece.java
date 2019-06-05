package com.yahacode.gobang.core;

public enum Piece {

    BLACK('B', "黑棋"), WHITE('W', "白棋");

    private char code;

    private String name;

    Piece(char code, String name) {
        this.code = code;
        this.name = name;
    }

    public char getCode() {
        return code;
    }

    public void setCode(char code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
