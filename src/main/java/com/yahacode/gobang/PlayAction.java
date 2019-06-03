package com.yahacode.gobang;

import com.yahacode.gobang.consts.GobangConst;
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

        int i = (int) ((x - 100 + GobangConst.GRID_WIDTH / 2) / GobangConst.GRID_WIDTH);
        int j = (int) ((y - 100 + GobangConst.GRID_WIDTH / 2) / GobangConst.GRID_WIDTH);

        gobangPane.drawPiece(i, j);
    }
}
