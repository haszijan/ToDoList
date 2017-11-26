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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.util.ArrayDeque;

public class Main extends Application {

    Image image;
    ImageView iv;
    String musicFile;
    Media sound;
    MediaPlayer mediaPlayer;
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

        image = new Image("file:freedom.jpg");
        iv = new ImageView();

        musicFile = "fanfary.mp3";
        sound = new Media(new File(musicFile).toURI().toString());
        mediaPlayer = new MediaPlayer(sound);

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
                    iv.setImage(image);
                    mediaPlayer.play();
                    box1.setDisable(true);
                    doneTaskButton.setDisable(true);
                }
            }
        });

        vbox = new VBox();
        vbox.getChildren().addAll(txtField, addButton, getTaskButton, box1, doneTaskButton, iv);
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
