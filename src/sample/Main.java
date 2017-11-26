package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayDeque;

public class Main extends Application {

    MediaSource mediaSource;
    TextFieldManager textFieldManager;
    CheckBoxManager checkBoxManager;
    Button addButton;
    Button getTaskButton;
    Button doneTaskButton;

    VBox vbox;
    ArrayDeque<String> taskQueue = new ArrayDeque<>();

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("GTA - Grand Task Auto");

        mediaSource = new MediaSource();
        mediaSource.displayImage();
        mediaSource.playMusicFile();

        Text text = new Text();

        textFieldManager = new TextFieldManager();
        textFieldManager.taskToDoTextField();

        checkBoxManager = new CheckBoxManager();
        checkBoxManager.doneTaskCheckBox();



        addButton = new Button();
        addButton.setText("Add task");
        addButton.setMaxWidth(Double.MAX_VALUE);
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                taskQueue.add(textFieldManager.getTxtField().getText());
            }
        });

        getTaskButton = new Button();
        getTaskButton.setText("Get task");
        getTaskButton.setMaxWidth(Double.MAX_VALUE);
        getTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(taskQueue.getFirst());
                checkBoxManager.getCheckBox().setText(taskQueue.getFirst());
            }
        });

        doneTaskButton = new Button();
        doneTaskButton.setText("Done");
        doneTaskButton.setMaxWidth(Double.MAX_VALUE);
        doneTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (checkBoxManager.getCheckBox().isSelected()) {
                    taskQueue.remove();
                    checkBoxManager.getCheckBox().setSelected(false);
                    doneTaskButton.setText("Done");
                } else {
                    doneTaskButton.setText("No work, no food    --Paulo Coehlo");
                }

                if (taskQueue.isEmpty()) {
                    mediaSource.iv.setImage(mediaSource.getImage());
                    mediaSource.mediaPlayer.play();
                    checkBoxManager.getCheckBox().setDisable(true);
                    doneTaskButton.setDisable(true);
                }
            }
        });

        vbox = new VBox();
        vbox.getChildren().addAll(textFieldManager.getTxtField(), addButton, getTaskButton, checkBoxManager.getCheckBox(), doneTaskButton, mediaSource.getIv());
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
