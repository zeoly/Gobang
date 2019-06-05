package com.yahacode.gobang.versus;

import com.yahacode.gobang.consts.GobangConst;
import com.yahacode.gobang.core.Piece;

public class RandomDetermination implements Determination {

    @Override
    public int[] determine(Piece[][] board) {
        int x = (int) (Math.random() * GobangConst.GRID_NUM);
        int y = (int) (Math.random() * GobangConst.GRID_NUM);
        while (board[x][y] != null) {
            x = (int) (Math.random() * GobangConst.GRID_NUM);
            y = (int) (Math.random() * GobangConst.GRID_NUM);
        }
        return new int[]{x, y};
    }
}
