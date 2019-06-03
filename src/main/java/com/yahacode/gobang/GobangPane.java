package com.yahacode.gobang;

import com.yahacode.gobang.consts.GobangConst;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangPane extends Pane {

    private Canvas canvas;

    private GraphicsContext graphicsContext;

    public GobangPane() {
        drawPane();
    }

    private void drawPane() {
        canvas = new Canvas(GobangConst.WIDTH, GobangConst.HEIGHT);
        graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        graphicsContext.setStroke(Color.BLACK);

        for (int i = 0; i < GobangConst.GRID_NUM; i++) {
            for (int j = 0; j < GobangConst.GRID_NUM; j++) {
                graphicsContext.strokeRect(100 + i * GobangConst.GRID_WIDTH, 100 + j * GobangConst.GRID_WIDTH,
                        GobangConst.GRID_WIDTH, GobangConst.GRID_WIDTH);
            }
        }

        getChildren().add(canvas);
    }
}
