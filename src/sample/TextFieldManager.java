package sample;

import javafx.scene.control.TextField;

public class TextFieldManager {

    TextField txtField;

    public void taskToDoTextField() {
        txtField = new TextField();
        txtField.setPromptText("Enter task to do.");
        txtField.setPrefColumnCount(25);
    }

    public TextField getTxtField() {
        return txtField;
    }

    public void setTxtField(TextField txtField) {
        this.txtField = txtField;
    }
}
