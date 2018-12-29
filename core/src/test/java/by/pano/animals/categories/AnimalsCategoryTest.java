package by.pano.animals.categories;

import by.pano.animals.api.Category;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AnimalsCategoryTest {

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
  void testEquals() {
    final Category category = new AnimalsCategory();
    assertEquals(new AnimalsCategory(), category);
    assertEquals(category, category);
    assertNotEquals(null, category);
    assertNotEquals(new CarsCategory(), category);

    final Category category1 = new AnimalsCategory();
    category.add("mouse");
    assertNotEquals(category1, category);
  }

  @Test
  void testHasCode() {
    final AnimalsCategory category = new AnimalsCategory();
    assertEquals(new AnimalsCategory().hashCode(), category.hashCode());
  }

  @Test
  void testAddCategoryName() {
    category.add("ANIMALS");
    assertTrue(category.getItems().isEmpty());
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
    assertEquals(
        ImmutableList.builder()
            .add("cat")
            .add("cat")
            .add("dog")
            .add("dog")
            .add("mouse")
            .add("mouse")
        .build(), category.getItems());
  }

  @Test
  void testAddNull() {
    category.add(null);
    assertTrue(category.getItems().isEmpty());
  }

  @Test
  void testIs() {
    assertTrue(category.is("ANIMALS"));
    assertTrue(category.is("Animals"));
    assertTrue(category.is("animals"));
    assertFalse(category.is("test"));
  }

  @Test
  void testIsForNull() {
    assertFalse(category.is(null));
  }
}