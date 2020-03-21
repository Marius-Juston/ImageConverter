package org.openjfx;

import java.io.File;
import org.apache.commons.io.FilenameUtils;

/**
 * @author Marius Juston
 **/
public class MyFile {

  private final File file;

  public MyFile(File file) {
    this.file = file;
  }

  public File getFile() {
    return file;
  }

  public String getName() {
    return FilenameUtils.getBaseName(file.getAbsolutePath());
  }

  public String getExtension() {
    return FilenameUtils.getExtension(file.getAbsolutePath());
  }
}
