package by.pano.animals.categories;

import by.pano.animals.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalsCategoryTest extends BaseTest {

  private AnimalsCategory category;

  @BeforeEach
  void beforeEach() {
    category = new AnimalsCategory();
  }

  @Test
  void testGetName() {
    assertEquals("ANIMALS", category.getName());
  }

  @Test
  void testAddCategoryName() {
    category.add("ANIMALS");
    category.print(newOut());
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
    category.print(newOut());
    assertEquals("ANIMALS:\n"
        + " cat\n"
        + " dog\n"
        + " mouse\n", getOutput());
  }

  @Test
  void testAddNull() {
    category.add(null);
    category.print(newOut());
    assertEquals("", getOutput());
  }

  @Test
  void testIs() {
    assertTrue(category.is("ANIMALS"));
    assertFalse(category.is("test"));
  }

  @Test
  void testIsForNull() {
    assertFalse(category.is(null));
  }
}