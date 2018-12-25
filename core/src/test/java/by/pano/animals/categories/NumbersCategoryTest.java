package by.pano.animals.categories;

import by.pano.animals.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersCategoryTest extends BaseTest {

  private NumbersCategory category;

  @BeforeEach
  void beforeEach() {
    category = new NumbersCategory();
  }

  @Test
  void testGetName() {
    assertEquals("NUMBERS", category.getName());
  }

  @Test
  void testAddCategoryName() {
    category.add("NUMBERS");
    category.print(newOut());
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
    category.print(newOut());
    assertEquals("NUMBERS: \n"
        + " one:1\n"
        + " three:3\n"
        + " two:2\n", getOutput());
  }

  @Test
  void testAddNull() {
    category.add(null);
    category.print(newOut());
    assertEquals("", getOutput());
  }

  @Test
  void testIs() {
    assertTrue(category.is("NUMBERS"));
    assertFalse(category.is("test"));
  }

  @Test
  void testIsForNull() {
    assertFalse(category.is(null));
  }
}