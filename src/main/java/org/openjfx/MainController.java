package org.openjfx;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import magick.ImageInfo;
import magick.MagickException;

/**
 * @author Marius Juston
 **/
public class MainController implements Initializable {

  public static final FileChooser fileChooser = new FileChooser();
  public static final DirectoryChooser folderChooser = new DirectoryChooser();
  public Button folderButton;
  public Button fileButton;
  public Button convertButton;
  public TreeTableView<MyFile> fileLister;
  private File initialUpperFolder = null;

  private List<String> availableOptions = Arrays.asList("*.heic", "*.png");

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    fileChooser.setTitle("Select Images");
    final ExtensionFilter images = new ExtensionFilter("Images", availableOptions);
    fileChooser.getExtensionFilters().add(images);
    fileChooser.getExtensionFilters().add(new ExtensionFilter("All", "*.*"));
    fileChooser.setSelectedExtensionFilter(images);

    try {
      ImageInfo info = new ImageInfo("inputfileName");
    } catch (MagickException e) {
      e.printStackTrace();
    }
////    //Create MagickImage that converts format
//    MagickImage magick_converter = new MagickImage(info);
////    //Specify output file name
//    String outputfile = "jmagick_png2jpg.jpg";
////    //Set output format
//    magick_converter.setFileName(outputfile);
////    //Write JPG file
//    magick_converter.writeImage(info);

  }

  public void addFolder(ActionEvent actionEvent) {
    if (initialUpperFolder != null) {
      folderChooser.setInitialDirectory(initialUpperFolder);
    }

    final File folder = folderChooser.showDialog(((Button) actionEvent.getSource()).getScene().getWindow());

    if (folder != null) {
      initialUpperFolder = folder.getParentFile();
    }
  }

  public void addFiles(ActionEvent actionEvent) {
    if (initialUpperFolder != null) {
      fileChooser.setInitialDirectory(initialUpperFolder);
    }

    final List<File> files = fileChooser
        .showOpenMultipleDialog(((Button) actionEvent.getSource()).getScene().getWindow());

    if (files != null && files.size() > 0) {
      initialUpperFolder = files.get(0).getParentFile();
    }
  }
}
