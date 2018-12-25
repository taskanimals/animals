package by.pano.animals.categories;

import by.pano.animals.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarsCategoryTest extends BaseTest {
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
  void testAddCategoryName() {
    category.add("CARS");
    category.print(newOut());
    assertEquals("", getOutput());
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
    category.print(newOut());
    assertEquals("CARS:\n"
        + " vw (7336a2c49b0045fa1340bf899f785e70)\n"
        + " opel (f65b7d39472c52142ea2f4ea5e115d59)\n"
        + " bmw (71913f59e458e026d6609cdb5a7cc53d)\n"
        + " audi (4d9fa555e7c23996e99f1fb0e286aea8)\n", getOutput());
  }

  @Test
  void testAddNull() {
    category.add(null);
    category.print(newOut());
    assertEquals("", getOutput());
  }

  @Test
  void testIs() {
    assertTrue(category.is("CARS"));
    assertFalse(category.is("test"));
  }

  @Test
  void testIsForNull() {
    assertFalse(category.is(null));
  }
}