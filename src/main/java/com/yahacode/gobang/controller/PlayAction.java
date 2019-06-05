package com.yahacode.gobang.controller;

import com.yahacode.gobang.consts.GobangConst;
import com.yahacode.gobang.view.GobangPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * @author zengyongli 2019-06-03
 */
public class PlayAction implements EventHandler<MouseEvent> {

    private GobangPane gobangPane;

    public PlayAction(GobangPane gobangPane) {
        this.gobangPane = gobangPane;
    }

    public void handle(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        int i = (int) ((x - GobangConst.PADDING + GobangConst.GRID_WIDTH / 2) / GobangConst.GRID_WIDTH);
        int j = (int) ((y - GobangConst.PADDING + GobangConst.GRID_WIDTH / 2) / GobangConst.GRID_WIDTH);

        gobangPane.drawPiece(i, j);
    }
}
