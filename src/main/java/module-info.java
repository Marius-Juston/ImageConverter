module ImageConverter {
  requires javafx.controls;
  requires javafx.fxml;
  requires org.apache.commons.io;
  requires jmagick;

  opens org.openjfx to javafx.fxml;
  exports org.openjfx;
}