package hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    private boolean pen = true;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	Color color = null;
    	if(pen) {
    		color = Color.BLACK;
    	}
    	else {
    		color = Color.WHITE;
    	}
        Circle newCircle = new Circle(event.getX(), event.getY(), 4);
        newCircle.setFill(color);
        drawingAreaPane.getChildren().add(newCircle);
    }
    

    @FXML
    void setPen(ActionEvent event) {
    	pen = true;
    }

    @FXML
    void setEraser(ActionEvent event) {
    	pen = false;
    }
}