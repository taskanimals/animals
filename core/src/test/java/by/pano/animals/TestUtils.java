package by.pano.animals;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUtils {

  private TestUtils() {}

  public static Path getFile(final String path) throws URISyntaxException {
    return Paths.get(TestUtils.class.getResource(path).toURI());
  }

}
