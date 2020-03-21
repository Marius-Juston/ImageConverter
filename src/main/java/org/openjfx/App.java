package org.openjfx;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Marius Juston
 **/
public class App extends Application {

  private static Parent loadFXML(String fxml) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    return fxmlLoader.load();
  }

  @Override
  public void start(Stage stage) throws Exception {
    stage.setScene(new Scene(loadFXML("main_app")));
    stage.setTitle("Converter");

    stage.show();
  }
}
