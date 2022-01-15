package me.vaalp.learningjavafx;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainApplication extends javafx.application.Application {


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


        KeyValue kv = new KeyValue(rectangle.rotateProperty(), rectangle.getRotate() + 1440.0);
        KeyFrame kf = new KeyFrame(Duration.seconds(1.0), kv);
        Timeline timeline = new Timeline(kf);

        timeline.setOnFinished(event -> rectangle.setRotate(0));

        Button button1 = new Button("Rotate shape");
        button1.setOnAction(event -> rotate(rectangle));

        Button button2 = new Button("Let's GO !");
        button2.setOnAction(event -> timeline.play());

        Button button3 = new Button("Stop this madness !");
        button3.setOnAction(event -> {
                    timeline.stop();
                    rectangle.setRotate(0);
                }
        );

        Text marker = new Text(String.valueOf(timeline.getCycleCount()));

        HBox hbox = new HBox();
        hbox.getChildren().add(button1);
        hbox.getChildren().add(button2);
        hbox.getChildren().add(button3);
        hbox.getChildren().add(marker);

        hbox.setSpacing(20.0);


        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                200.0, 200.0,
                300.0, 300.0,
                350.0, 400.0);
        triangle.setFill(Color.DARKGREEN);

        root.getChildren().add(rectangle);
        root.getChildren().add(hbox);

        stage.setScene(scene);
        stage.show();

    }

    private void rotate(Rectangle box) {
        box.setRotate(box.getRotate() + 15);
    }
}