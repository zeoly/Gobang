package com.yahacode.gobang;

import com.yahacode.gobang.consts.GobangConst;
import com.yahacode.gobang.controller.AiVersusAiPlayAction;
import com.yahacode.gobang.controller.UserAiPlayAction;
import com.yahacode.gobang.controller.UserVersusPlayAction;
import com.yahacode.gobang.core.GobangBoard;
import com.yahacode.gobang.versus.RandomDetermination;
import com.yahacode.gobang.view.GobangPane;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author zengyongli 2019-06-03
 */
public class GobangApplication extends Application {

    public void start(Stage primaryStage) throws Exception {
        GobangBoard gobangBoard = new GobangBoard(GobangConst.GRID_NUM);
        GobangPane gobangPane = new GobangPane(gobangBoard);
        gobangPane.setOnMouseClicked(new UserVersusPlayAction(gobangPane));
//        gobangPane.setOnMouseClicked(new UserAiPlayAction(gobangPane, new RandomDetermination()));
//        gobangPane.setOnMouseClicked(new AiVersusAiPlayAction(gobangPane, new RandomDetermination(), new
// RandomDetermination()));

        Scene scene = new Scene(gobangPane, GobangConst.WIDTH, GobangConst.HEIGHT);

        Menu fileMenu = new Menu("开始");
        MenuItem newMenuItem = new MenuItem("新局");
        MenuItem exitMenuItem = new MenuItem("退出");
        newMenuItem.setOnAction(event -> gobangPane.reset());
        exitMenuItem.setOnAction(event -> Platform.exit());
        fileMenu.getItems().addAll(newMenuItem, exitMenuItem);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        ((Pane) scene.getRoot()).getChildren().addAll(menuBar);

        primaryStage.setScene(scene);
        primaryStage.setTitle(GobangConst.TITLE);
        primaryStage.show();
    }
}
