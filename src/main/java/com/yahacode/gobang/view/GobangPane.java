package com.yahacode.gobang.view;

import com.yahacode.gobang.core.GobangBoard;
import com.yahacode.gobang.consts.GobangConst;
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
            graphicsContext.fillRect(90, 90, GobangConst.GRID_WIDTH * (GobangConst.GRID_NUM - 1) + 20,
                    GobangConst.GRID_WIDTH * (GobangConst.GRID_NUM - 1) + 20);

            for (int i = 0; i < GobangConst.GRID_NUM - 1; i++) {
                for (int j = 0; j < GobangConst.GRID_NUM - 1; j++) {
                    graphicsContext.strokeRect(100 + i * GobangConst.GRID_WIDTH, 100 + j * GobangConst.GRID_WIDTH,
                            GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
                }
            }
            getChildren().add(canvas);
        }
    }

    public void drawPiece(int i, int j) {
        if (canDrawPiece(i, j)) {
            char result = gobangBoard.play(i, j);
            if (result == 'B') {
                drawBlackPiece(i, j);
            } else {
                drawWhitePiece(i, j);
            }
            System.out.println(i + "," + j + " " + result);

            if (gobangBoard.isWin(i, j, result)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle(GobangConst.TITLE);
                alert.setHeaderText("提示信息");
                alert.setContentText(result + "方取得胜利！");

                alert.showAndWait();

            }
        }
    }

    private boolean canDrawPiece(int i, int j) {
        return gobangBoard.canPlay(i, j);
    }

    private void drawBlackPiece(int i, int j) {
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillOval(100 + (i - 0.5) * GobangConst.GRID_WIDTH, 100 + (j - 0.5) * GobangConst.GRID_WIDTH,
                GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
    }

    private void drawWhitePiece(int i, int j) {
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillOval(100 + (i - 0.5) * GobangConst.GRID_WIDTH, 100 + (j - 0.5) * GobangConst.GRID_WIDTH,
                GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
    }
}
