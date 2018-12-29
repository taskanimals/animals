package by.pano.animals.categories;

import by.pano.animals.api.Category;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsCategoryTest {
  private CarsCategory category;

  @BeforeEach
  void beforeEach() {
    category = new CarsCategory();
  }

  @Test
  void testGetName() {
    assertEquals("CARS", category.getName());
  }

  @Test
  void testEquals() {
    final Category category = new CarsCategory();
    assertEquals(new CarsCategory(), category);
    assertEquals(category, category);
    assertNotEquals(null, category);
    assertNotEquals(new AnimalsCategory(), category);

    final Category category1 = new CarsCategory();
    category.add("opel");
    assertNotEquals(category1, category);
  }

  @Test
  void testHasCode() {
    final Category category = new CarsCategory();
    assertEquals(new CarsCategory().hashCode(), category.hashCode());
  }

  @Test
  void testAddCategoryName() {
    category.add("CARS");
    assertTrue(category.getItems().isEmpty());
  }

  @Test
  void testAdd() {
    category.add("CARS");
    category.add("opel");
    category.add("OPEL");
    category.add("Opel");
    category.add("vw");
    category.add("BMW");
    category.add("bmw");
    category.add("audi");
    category.add("Audi");
    assertEquals(
        ImmutableList.builder()
            .add("opel")
            .add("OPEL")
            .add("Opel")
            .add("vw")
            .add("BMW")
            .add("bmw")
            .add("audi")
            .add("Audi")
        .build(), category.getItems());
  }

  @Test
  void testAddNull() {
    category.add(null);
    assertTrue(category.getItems().isEmpty());
  }

  @Test
  void testIs() {
    assertTrue(category.is("CARS"));
    assertTrue(category.is("Cars"));
    assertTrue(category.is("cars"));
    assertFalse(category.is("test"));
  }

  @Test
  void testIsForNull() {
    assertFalse(category.is(null));
  }
}