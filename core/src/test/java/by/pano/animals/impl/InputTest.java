package by.pano.animals.impl;

import by.pano.animals.BaseTest;
import by.pano.animals.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputTest extends BaseTest {

  private Input input;

  @BeforeEach
  void beforeEach() {
    input = injector.getInstance(Input.class);
  }

  @Test
  void testInputFileSuccess() throws AnimalsException, URISyntaxException {
    final Path actual = TestUtils.getFile("/input.txt");
    final Path path = input.inputFile(new String[]{"-f", actual.toString()});
    assertEquals(actual, path);
  }

  @Test
  void testInputFileSuccessFullParam() throws AnimalsException, URISyntaxException {
    final Path actual = TestUtils.getFile("/input.txt");
    final Path path = input.inputFile(new String[]{"--file", actual.toString()});
    assertEquals(actual, path);
  }

  @Test
  void testInputFileNotValidInput() {
    assertThrows(AnimalsException.class, () -> input.inputFile(new String[]{"-#.*"}));
  }

  @Test
  void testInputFileEmptyInput() {
    assertThrows(AnimalsException.class, () -> input.inputFile(new String[]{}));
  }

  @Test
  void testInputFileNonExistentFile() {
    assertThrows(AnimalsException.class, () -> input.inputFile(new String[]{"-f", "non-existent-file.txt"}));
  }

  @Test
  void testInputFileNull() {
    assertThrows(AnimalsException.class, () -> input.inputFile(null));
  }

}