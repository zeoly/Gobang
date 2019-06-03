package com.yahacode.gobang;

import com.yahacode.gobang.consts.GobangConst;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangApplication extends Application {

    public void start(Stage primaryStage) throws Exception {
        GobangPane gobangPane = new GobangPane();

        Scene scene = new Scene(gobangPane, GobangConst.WIDTH, GobangConst.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(GobangConst.TITLE);
        primaryStage.show();
    }
}
