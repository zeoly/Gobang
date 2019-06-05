package com.yahacode.gobang;

import com.yahacode.gobang.consts.GobangConst;
import com.yahacode.gobang.controller.AiVersusAiPlayAction;
import com.yahacode.gobang.controller.UserAiPlayAction;
import com.yahacode.gobang.controller.UserVersusPlayAction;
import com.yahacode.gobang.core.GobangBoard;
import com.yahacode.gobang.versus.RandomDetermination;
import com.yahacode.gobang.view.GobangPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangApplication extends Application {

    public void start(Stage primaryStage) throws Exception {
        GobangBoard gobangBoard = new GobangBoard(GobangConst.GRID_NUM);
        GobangPane gobangPane = new GobangPane(gobangBoard);
//        gobangPane.setOnMouseClicked(new UserVersusPlayAction(gobangPane));
        gobangPane.setOnMouseClicked(new UserAiPlayAction(gobangPane, new RandomDetermination()));
//        gobangPane.setOnMouseClicked(new AiVersusAiPlayAction(gobangPane, new RandomDetermination(), new RandomDetermination()));

        Scene scene = new Scene(gobangPane, GobangConst.WIDTH, GobangConst.HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(GobangConst.TITLE);
        primaryStage.show();
    }
}
