package me.vaalp.learningjavafx;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.RecursiveAction;

public class MainApplication extends javafx.application.Application {

    private boolean onStopButtonPressed;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.GRAY);
        Image icon = new Image("icon.png");
        stage.setTitle("Transform Shape Program");
        stage.getIcons().add(icon);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(400);
        rectangle.setY(290);
        rectangle.setWidth(50);
        rectangle.setHeight(20);
        rectangle.setFill(Color.GOLD);
        rectangle.setStrokeWidth(5);


        KeyValue kv = new KeyValue(rectangle.rotateProperty(), 360);

        Button button1 = new Button("Rotate shape");
        button1.setOnAction(event -> { rotate(rectangle);});

        KeyFrame kf = new KeyFrame(Duration.seconds(1), kv);
        Timeline timeline = new Timeline(kf);

        Button button2 = new Button("Letzgoo !");

        button2.setOnAction(event -> {
            timeline.play();
        });



        Button button3 = new Button("Stop this madness !");
        button3.setOnAction(event -> { timeline.stop();});

        button2.setLayoutX(100.0 );

        button3.setLayoutX(200.0);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                200.0, 200.0,
                300.0, 300.0,
                350.0, 400.0);
        triangle.setFill(Color.DARKGREEN);

        root.getChildren().add(rectangle);
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(button3);

        stage.setScene(scene);
        stage.show();


    }

    private void rotate(Rectangle box) {
        box.setRotate(box.getRotate() + 15);
    }
}