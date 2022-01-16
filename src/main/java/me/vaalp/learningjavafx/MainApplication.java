package me.vaalp.learningjavafx;


import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.List;

public class MainApplication extends javafx.application.Application {


    private Rectangle rectangle;
    private Timeline timeline;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.GRAY);

        createRectangle();
        setAnimation();

        root.getChildren().add(rectangle);
        root.getChildren().add(createHBox(
                List.of(
                        createRotateBtn(),
                        createAutoRotateBtn(),
                        createStopBtn())));

        stage.setTitle("Transform Shape Program");
        stage.getIcons().add(new Image("icon.png"));
        stage.setScene(scene);
        stage.show();

    }

    private void setAnimation() {
        timeline = new Timeline(createKeyFrame());
        timeline.setOnFinished(event -> rectangle.setRotate(0));
    }

    private KeyFrame createKeyFrame() {
        return new KeyFrame(Duration.seconds(10), createKeyValue());
    }

    private KeyValue createKeyValue() {
        return new KeyValue(rectangle.rotateProperty(), rectangle.getRotate() + 1440.0);
    }

    private Button createStopBtn() {
        Button button3 = new Button("Stop this madness !");
        button3.setOnAction(event -> {
                    timeline.stop();
                    rectangle.setRotate(0);
                }
        );
        return button3;
    }

    private Button createAutoRotateBtn() {
        Button btn = new Button("Let's GO !");
        btn.setOnAction(event -> timeline.play());
        return btn;
    }

    private Button createRotateBtn() {
        Button btn = new Button("Rotate shape");
        btn.setOnAction(event -> rotate(rectangle));
        return btn;
    }

    private void createRectangle() {
        rectangle = new Rectangle();
        rectangle.setX(300);
        rectangle.setY(290);
        rectangle.setWidth(50);
        rectangle.setHeight(20);
        rectangle.setStrokeWidth(5);
        rectangle.setFill(Color.GOLD);
    }

    private HBox createHBox(List<Region> regions) {
        HBox hbox = new HBox();
        for (Region region : regions) {
            hbox.getChildren().add(region);
        }
        hbox.setSpacing(20.0);
        return hbox;
    }

    private void rotate(Rectangle box) {
        box.setRotate(box.getRotate() + 15);
    }


}