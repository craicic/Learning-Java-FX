package me.vaalp.learningjavafx;


import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainApplication extends javafx.application.Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 600,600, Color.GRAY);
        Image icon = new Image("icon.png");
        stage.setTitle("Stage Demo Program");
        stage.getIcons().add(icon);

        Text text = new Text();
        text.setText("WHOOOOOOO!!!");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Consolas",50));
        text.setFill(Color.GOLD);

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(500);
        line.setStrokeWidth(5);
        line.setStroke(Color.WHITE);
        line.setRotate(45);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(150);
        rectangle.setY(50);
        rectangle.setWidth(150);
        rectangle.setHeight(250);
        rectangle.setFill(Color.GOLD);
        rectangle.setStrokeWidth(5);

        Polygon triangle = new Polygon();
        triangle.getPoints().setAll(
                200.0,200.0,
                300.0,300.0,
                350.0,400.0);
        triangle.setFill(Color.DARKGREEN);

        root.getChildren().add(triangle);
        root.getChildren().add(text);
        root.getChildren().add(line);
        root.getChildren().add(rectangle);
        stage.setScene(scene);
        stage.show();
    }
}