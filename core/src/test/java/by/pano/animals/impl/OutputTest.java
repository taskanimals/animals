package by.pano.animals.impl;

import by.pano.animals.BaseTest;
import by.pano.animals.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OutputTest extends BaseTest {

  private Processor processor;
  private Output output;

  @BeforeEach
  void beforeEach() {
    processor = new Processor(CategorySupport.load());
    output = injector.getInstance(Output.class);
  }

  @Test
  void testSuccess() throws URISyntaxException, AnimalsException {
    output.print(newOut(), processor.process(TestUtils.getFile("/input.txt")));
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
    output.print(newOut(), processor.process(TestUtils.getFile("/input2.txt")));
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
    output.print(newOut(), processor.process(TestUtils.getFile("/inputEmpty.txt")));
    assertEquals("", getOutput());
  }

  @Test
  void testFileWithNonCategoryFirstLine() throws URISyntaxException, AnimalsException {
    output.print(newOut(), processor.process(TestUtils.getFile("/input3.txt")));
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
  void testPrintError() {
    output.print(newOut(), new Exception("Test message"));
    assertEquals("\nInterrupted due to error: Test message \n\n"
        + "usage: java -jar animals.jar -f inputFile.txt\n"
        + " -f,--file <arg>   Input file\n", getOutput());
  }

}