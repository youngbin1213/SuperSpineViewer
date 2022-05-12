package com.SoarCraft.SuperSpineViewer;

import com.SoarCraft.SuperSpineViewer.Controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ResourcesLoader.LoadURL("main.fxml"));
        loader.setControllerFactory(x -> new MainController(primaryStage));

        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SuperSpineViewer v2 - Aloento");
        primaryStage.show();
    }
}
