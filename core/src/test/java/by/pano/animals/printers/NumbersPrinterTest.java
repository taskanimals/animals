package by.pano.animals.printers;

import by.pano.animals.BaseTest;
import by.pano.animals.categories.NumbersCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersPrinterTest extends BaseTest {

  private NumbersCategory category;
  private NumbersPrinter printer;

  @BeforeEach
  void beforeEach() {
    category = new NumbersCategory();
    printer = new NumbersPrinter(category);
  }

  @Test
  void testAddCategoryName() {
    category.add("NUMBERS");
    printer.print(newOut());
    assertEquals("", getOutput());
  }

  @Test
  void testAdd() {
    category.add("NUMBERS");
    category.add("one");
    category.add("two");
    category.add("two");
    category.add("three");
    category.add("three");
    category.add("three");
    printer.print(newOut());
    assertEquals("NUMBERS: \n"
        + " one:1\n"
        + " three:3\n"
        + " two:2\n", getOutput());
  }

  @Test
  void testAddNull() {
    category.add(null);
    printer.print(newOut());
    assertEquals("", getOutput());
  }
}