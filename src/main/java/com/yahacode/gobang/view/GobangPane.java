package com.yahacode.gobang.view;

import com.yahacode.gobang.core.GobangBoard;
import com.yahacode.gobang.consts.GobangConst;
import com.yahacode.gobang.core.Piece;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangPane extends Pane {

    private Canvas canvas;

    private GraphicsContext graphicsContext;

    private GobangBoard gobangBoard;

    public GobangPane(GobangBoard gobangBoard) {
        this.gobangBoard = gobangBoard;
        drawPane();
    }

    private void drawPane() {
        if (gobangBoard.isRunning()) {
            canvas = new Canvas(GobangConst.WIDTH, GobangConst.HEIGHT);
            graphicsContext = canvas.getGraphicsContext2D();

            graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            graphicsContext.setStroke(Color.BLACK);
            graphicsContext.setFill(Color.rgb(213, 176, 146));
            graphicsContext.fillRect(GobangConst.PADDING - GobangConst.BOARD_EDGE, GobangConst.PADDING - GobangConst.BOARD_EDGE, GobangConst.GRID_WIDTH * (GobangConst.GRID_NUM - 1) + 2 * GobangConst.BOARD_EDGE,
                    GobangConst.GRID_WIDTH * (GobangConst.GRID_NUM - 1) + 2 * GobangConst.BOARD_EDGE);

            for (int i = 0; i < GobangConst.GRID_NUM - 1; i++) {
                for (int j = 0; j < GobangConst.GRID_NUM - 1; j++) {
                    graphicsContext.strokeRect(GobangConst.PADDING + i * GobangConst.GRID_WIDTH, GobangConst.PADDING + j * GobangConst.GRID_WIDTH,
                            GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
                }
            }

            graphicsContext.setFill(Color.BLACK);
            for (int i = 3; i <= 15; i = i + 6) {
                for (int j = 3; j <= 15; j = j + 6) {
                    graphicsContext.fillOval(GobangConst.PADDING + i * GobangConst.GRID_WIDTH - GobangConst.GRID_WIDTH / 3 / 2, GobangConst.PADDING + j * GobangConst.GRID_WIDTH - GobangConst.GRID_WIDTH / 3 / 2,
                            GobangConst.GRID_WIDTH / 3, GobangConst.GRID_WIDTH / 3);
                }
            }
            getChildren().add(canvas);
        }
    }

    public void drawPiece(int i, int j) {
        if (canDrawPiece(i, j)) {
            Piece result = gobangBoard.play(i, j);
            if (result == Piece.BLACK) {
                drawBlackPiece(i, j);
            } else {
                drawWhitePiece(i, j);
            }
            System.out.println(i + "," + j + " " + result);

            if (gobangBoard.isWin(i, j, result)) {
                gobangBoard.endBoard();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(GobangConst.TITLE);
                alert.setHeaderText("游戏结束");
                alert.setContentText(result.getName() + "取得胜利！");
                alert.showAndWait();
            }
        }
    }

    private boolean canDrawPiece(int i, int j) {
        if (i < 0 || j < 0 || i >= GobangConst.GRID_NUM || j >= GobangConst.GRID_NUM) {
            return false;
        }
        return gobangBoard.canPlay(i, j);
    }

    private void drawBlackPiece(int i, int j) {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(GobangConst.PADDING + (i - 0.5) * GobangConst.GRID_WIDTH, GobangConst.PADDING + (j - 0.5) * GobangConst.GRID_WIDTH,
                GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
    }

    private void drawWhitePiece(int i, int j) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(GobangConst.PADDING + (i - 0.5) * GobangConst.GRID_WIDTH, GobangConst.PADDING + (j - 0.5) * GobangConst.GRID_WIDTH,
                GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
    }
}
