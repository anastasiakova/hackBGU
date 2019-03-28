package View;

import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class orenMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

            FXMLLoader fxmlControl = new FXMLLoader();
            Parent root = fxmlControl.load(getClass().getResource(("/Reco.fxml")).openStream());
            primaryStage.setTitle("VACATION 4 U ");
            openWindow view = fxmlControl.getController();
            primaryStage.setScene(new Scene(root, 1300, 950));
            primaryStage.getScene().getStylesheets().add("/RecoCSS.css");
            primaryStage.show();



    }

//    public static void main (String [] args){
//        System.out.println("oren");
//    }
}

