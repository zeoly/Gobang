package com.yahacode.gobang.consts;

/**
 * 常量
 *
 * @author zengyongli 2019-06-03
 */
public class GobangConst {

    public static final String TITLE = "Gobang五子棋";

    /**
     * 棋盘大小
     */
    public static final int GRID_NUM = 19;

    /**
     * 单格宽度
     */
    public static final int GRID_WIDTH = 30;

    /**
     * 画布边距
     */
    public static final int PADDING = 100;

    /**
     * 棋盘边距
     */
    public static final int BOARD_EDGE = 30;

    /**
     * 画布宽度
     */
    public static final int WIDTH = PADDING * 2 + (GRID_NUM - 1) * GRID_WIDTH;

    /**
     * 画布高度
     */
    public static final int HEIGHT = WIDTH;

    /**
     * 获胜所需连接数
     */
    public static final int PIECES_OF_WIN = 5;
}
