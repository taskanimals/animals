package by.pano.animals.categories;

import by.pano.animals.api.Category;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NumbersCategoryTest {

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
  void testEquals() {
    final Category category = new NumbersCategory();
    assertEquals(new NumbersCategory(), category);
    assertEquals(category, category);
    assertNotEquals(null, category);
    assertNotEquals(new AnimalsCategory(), category);

    final Category category1 = new NumbersCategory();
    category.add("six");
    assertNotEquals(category1, category);
  }

  @Test
  void testHasCode() {
    final Category category = new NumbersCategory();
    assertEquals(new NumbersCategory().hashCode(), category.hashCode());
  }

  @Test
  void testAddCategoryName() {
    category.add("NUMBERS");
    assertTrue(category.getItems().isEmpty());
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
    assertEquals(
        ImmutableList.builder()
            .add("one")
            .add("two")
            .add("two")
            .add("three")
            .add("three")
            .add("three")
        .build(), category.getItems());
  }

  @Test
  void testAddNull() {
    category.add(null);
    assertTrue(category.getItems().isEmpty());
  }

  @Test
  void testIs() {
    assertTrue(category.is("NUMBERS"));
    assertTrue(category.is("Numbers"));
    assertTrue(category.is("numbers"));
    assertFalse(category.is("test"));
  }

  @Test
  void testIsForNull() {
    assertFalse(category.is(null));
  }
}