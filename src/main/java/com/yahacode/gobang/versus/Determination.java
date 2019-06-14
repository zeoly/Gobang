package com.yahacode.gobang.versus;

import com.yahacode.gobang.core.Move;
import com.yahacode.gobang.core.Piece;

/**
 * 决策
 *
 * @author zengyongli 2019-06-04
 */
public interface Determination {

    /**
     * 决策方法
     *
     * @param board 棋盘状态
     * @param piece 当前待下棋子
     * @return 坐标
     */
    int[] determine(Move[][] board, Piece piece);

}
