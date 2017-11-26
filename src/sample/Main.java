package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayDeque;

public class Main extends Application {

    MediaSource mediaSource;
    CheckBox box1;
    Button addButton;
    Button getTaskButton;
    Button doneTaskButton;
    TextField txtField;
    VBox vbox;
    ArrayDeque<String> taskQueue = new ArrayDeque<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GTA - Grand Task Auto");

        mediaSource = new MediaSource();
        mediaSource.displayImage();
        mediaSource.playMusicFile();




        Text text = new Text();

        txtField = new TextField();
        txtField.setPromptText("Enter task to do.");
        txtField.setPrefColumnCount(25);

        box1 = new CheckBox();
        box1.setAlignment(Pos.BOTTOM_LEFT);
        box1.setLayoutX(10);
        box1.setLayoutY(10);

        addButton = new Button();
        addButton.setText("Add task");
        addButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                taskQueue.add(txtField.getText());
            }
        });

        getTaskButton = new Button();
        getTaskButton.setText("Get task");
        getTaskButton.setMaxWidth(Double.MAX_VALUE);
        getTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(taskQueue.getFirst());
                box1.setText(taskQueue.getFirst());
            }
        });

        doneTaskButton = new Button();
        doneTaskButton.setText("Done");
        doneTaskButton.setMaxWidth(Double.MAX_VALUE);
        doneTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (box1.isSelected()) {
                    taskQueue.remove();
                    box1.setSelected(false);
                    doneTaskButton.setText("Done");
                } else {
                    doneTaskButton.setText("No work, no food    --Paulo Coehlo");
                }

                if (taskQueue.isEmpty()) {
                    mediaSource.iv.setImage(mediaSource.getImage());
                    mediaSource.mediaPlayer.play();
                    box1.setDisable(true);
                    doneTaskButton.setDisable(true);
                }
            }
        });

        vbox = new VBox();
        vbox.getChildren().addAll(txtField, addButton, getTaskButton, box1, doneTaskButton, mediaSource.getIv());
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(vbox, 500, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {

        launch(args);
    }

}
