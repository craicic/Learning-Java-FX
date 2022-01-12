package me.vaalp.learningjavafx;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApplication extends javafx.application.Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, Color.GRAY);

        Image icon = new Image("icon.png");

        stage.setTitle("Stage Demo Program");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setWidth(420);
        stage.setHeight(450);
        stage.setResizable(false);
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("Haha you're stuck unless you press 'a'");
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("a"));
        stage.show();
    }
}