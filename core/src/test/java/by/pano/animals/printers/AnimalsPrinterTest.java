package by.pano.animals.printers;

import by.pano.animals.BaseTest;
import by.pano.animals.categories.AnimalsCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalsPrinterTest extends BaseTest {

  private AnimalsCategory category;
  private AnimalsPrinter printer;

  /**
   * Before each block.
   */
  @BeforeEach
  void beforeEach() {
    category = new AnimalsCategory();
    printer = new AnimalsPrinter(category);
  }

  @Test
  void testAddCategoryName() {
    category.add("ANIMALS");
    printer.print(newOut());
    assertEquals("", getOutput());
  }

  @Test
  void testAdd() {
    category.add("ANIMALS");
    category.add("cat");
    category.add("cat");
    category.add("dog");
    category.add("dog");
    category.add("mouse");
    category.add("mouse");
    printer.print(newOut());
    assertEquals("ANIMALS:\n"
        + " cat\n"
        + " dog\n"
        + " mouse\n", getOutput());
  }

  @Test
  void testAddNull() {
    category.add(null);
    printer.print(newOut());
    assertEquals("", getOutput());
  }
}