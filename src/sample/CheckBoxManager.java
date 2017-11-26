package sample;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;

public class CheckBoxManager {

    CheckBox checkBox;

    void doneTaskCheckBox() {
        checkBox = new CheckBox();
        checkBox.setAlignment(Pos.BOTTOM_LEFT);
        checkBox.setLayoutX(10);
        checkBox.setLayoutY(10);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
