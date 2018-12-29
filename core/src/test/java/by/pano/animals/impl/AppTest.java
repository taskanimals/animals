package by.pano.animals.impl;

import by.pano.animals.BaseTest;
import by.pano.animals.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest extends BaseTest {

  private App app;

  @BeforeEach
  void beforeEach() {
    final Input input = injector.getInstance(Input.class);
    final Output output = injector.getInstance(Output.class);
    app = new App(input, output, newOut());
  }

  @Test
  void testSuccess() throws URISyntaxException {
    final Path path = TestUtils.getFile("/input.txt");
    app.run(new String[]{"-f", path.toString()});
    assertEquals("ANIMALS:\n"
        + " cow\n"
        + " horse\n"
        + " moose\n"
        + " sheep\n"
        + "NUMBERS: \n"
        + " six:2\n"
        + " one:2\n"
        + " seven:1\n"
        + " two:1\n"
        + " three:2\n", getOutput());
  }

  @Test
  void testEmptyFile() throws URISyntaxException {
    final Path path = TestUtils.getFile("/inputEmpty.txt");
    app.run(new String[]{"-f", path.toString()});
    assertEquals("", getOutput());
  }

  @Test
  void testFileWithNonCategoryFirstLine() throws URISyntaxException {
    final Path path = TestUtils.getFile("/input3.txt");
    app.run(new String[]{"-f", path.toString()});
    assertEquals("ANIMALS:\n"
        + " cow\n"
        + " horse\n"
        + " moose\n"
        + " sheep\n"
        + "NUMBERS: \n"
        + " six:2\n"
        + " seven:1\n", getOutput());
  }

  @Test
  void testInputFileNotValidInput() {
    app.run(new String[]{"-#.*"});
    assertEquals("\nInterrupted due to error: Cannot parse parameters \n\n"
        + "usage: java -jar animals.jar -f inputFile.txt\n"
        + " -f,--file <arg>   Input file\n", getOutput());
  }

  @Test
  void testInputFileEmptyInput() {
    app.run(new String[]{});
    assertEquals("\nInterrupted due to error: Required argument missed \n\n"
        + "usage: java -jar animals.jar -f inputFile.txt\n"
        + " -f,--file <arg>   Input file\n", getOutput());
  }

  @Test
  void testInputFileNull() {
    app.run(null);
    assertEquals("\nInterrupted due to error: Required argument missed \n\n"
        + "usage: java -jar animals.jar -f inputFile.txt\n"
        + " -f,--file <arg>   Input file\n", getOutput());
  }
}