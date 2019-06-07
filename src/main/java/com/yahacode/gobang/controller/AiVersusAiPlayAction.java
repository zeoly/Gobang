package com.yahacode.gobang.controller;

import com.yahacode.gobang.core.Piece;
import com.yahacode.gobang.versus.Determination;
import com.yahacode.gobang.view.GobangPane;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AiVersusAiPlayAction implements EventHandler<MouseEvent> {

    private GobangPane gobangPane;

    private Determination blackDetermination;

    private Determination whiteDetermination;

    public AiVersusAiPlayAction(GobangPane gobangPane, Determination blackDetermination, Determination whiteDetermination) {
        this.gobangPane = gobangPane;
        this.blackDetermination = blackDetermination;
        this.whiteDetermination = whiteDetermination;
    }

    @Override
    public void handle(MouseEvent event) {
        Piece[][] board = gobangPane.getGobangBoard().getBoard();
        if (gobangPane.getGobangBoard().getCurrentPiece() == Piece.BLACK) {
            int[] next = blackDetermination.determine(board, Piece.BLACK);
            gobangPane.drawPiece(next[0], next[1]);
        } else {
            int[] next = whiteDetermination.determine(board, Piece.WHITE);
            gobangPane.drawPiece(next[0], next[1]);
        }

    }
}
