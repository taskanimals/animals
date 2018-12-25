package by.pano.animals.impl;

import by.pano.animals.BaseTest;
import by.pano.animals.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessorTest extends BaseTest {

  private Processor processor;

  @BeforeEach
  void beforeEach() {
    processor = injector.getInstance(Processor.class);
  }

  @Test
  void testSuccess() throws URISyntaxException, AnimalsException {
    processor.process(TestUtils.getFile("/input.txt"));
    processor.print(newOut());
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
  void testSuccess2() throws URISyntaxException, AnimalsException {
    processor.process(TestUtils.getFile("/input2.txt"));
    processor.print(newOut());
    assertEquals("ANIMALS:\n"
        + " cow\n"
        + " horse\n"
        + " moose\n"
        + " sheep\n"
        + "CARS:\n"
        + " vw (7336a2c49b0045fa1340bf899f785e70)\n"
        + " opel (f65b7d39472c52142ea2f4ea5e115d59)\n"
        + " bmw (71913f59e458e026d6609cdb5a7cc53d)\n"
        + " audi (4d9fa555e7c23996e99f1fb0e286aea8)\n"
        + "NUMBERS: \n"
        + " six:2\n"
        + " one:2\n"
        + " seven:1\n"
        + " two:1\n"
        + " three:2\n", getOutput());
  }

  @Test
  void testEmptyFile() throws URISyntaxException, AnimalsException {
    processor.process(TestUtils.getFile("/inputEmpty.txt"));
    processor.print(newOut());
    assertEquals("", getOutput());
  }

  @Test
  void testFileWithNonCategoryFirstLine() throws URISyntaxException, AnimalsException {
    processor.process(TestUtils.getFile("/input3.txt"));
    processor.print(newOut());
    assertEquals("ANIMALS:\n"
        + " cow\n"
        + " horse\n"
        + " moose\n"
        + " sheep\n"
        + "NUMBERS: \n"
        + " six:2\n"
        + " seven:1\n", getOutput());
  }

}