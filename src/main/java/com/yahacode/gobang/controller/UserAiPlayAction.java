package com.yahacode.gobang.controller;

import com.yahacode.gobang.consts.GobangConst;
import com.yahacode.gobang.versus.Determination;
import com.yahacode.gobang.view.GobangPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class UserAiPlayAction implements EventHandler<MouseEvent> {

    private GobangPane gobangPane;

    private Determination determination;

    public UserAiPlayAction(GobangPane gobangPane, Determination determination) {
        this.gobangPane = gobangPane;
        this.determination = determination;
    }

    @Override
    public void handle(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        int i = (int) ((x - GobangConst.PADDING + GobangConst.GRID_WIDTH / 2) / GobangConst.GRID_WIDTH);
        int j = (int) ((y - GobangConst.PADDING + GobangConst.GRID_WIDTH / 2) / GobangConst.GRID_WIDTH);

        gobangPane.drawPiece(i, j);

        int[] next = determination.determine(gobangPane.getGobangBoard().getBoard());
        System.out.println("ai move: " + next[0] + "," + next[1]);
        gobangPane.drawPiece(next[0], next[1]);
    }
}
