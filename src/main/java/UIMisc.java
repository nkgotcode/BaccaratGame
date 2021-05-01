import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class UIMisc {

    public static void setIV(ImageView iv, Image i) {
        iv.setImage(i);
        iv.setPreserveRatio(true);
        iv.setSmooth(true);
        iv.setCache(true);
    }

    public static void createFadeTrans(FadeTransition fade, Node value, Duration time, double from, double to, int cycle, boolean reverse) {
        fade.setNode(value);
        fade.setDuration(time);
        fade.setFromValue(from);
        fade.setToValue(to);
        fade.setCycleCount(cycle);
        fade.setAutoReverse(reverse);
    }

    public static void displayAlert(String title, String message) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

}
