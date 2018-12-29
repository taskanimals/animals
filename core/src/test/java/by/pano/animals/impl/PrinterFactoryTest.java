package by.pano.animals.impl;

import by.pano.animals.BaseTest;
import by.pano.animals.api.Category;
import by.pano.animals.api.Printer;
import by.pano.animals.categories.AnimalsCategory;
import by.pano.animals.categories.CarsCategory;
import by.pano.animals.categories.NumbersCategory;
import by.pano.animals.printers.AnimalsPrinter;
import by.pano.animals.printers.CarsPrinter;
import by.pano.animals.printers.NumbersPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PrinterFactoryTest extends BaseTest {

  private PrinterFactory factory;

  @BeforeEach
  void beforeEach() {
    factory = injector.getInstance(PrinterFactory.class);
  }

  @Test
  void testCreateForAnimalsCategory() {
    final Printer printer = factory.createFor(new AnimalsCategory());
    assertNotNull(printer);
    assertTrue(printer instanceof AnimalsPrinter);
  }

  @Test
  void testCreateForNumbersCategory() {
    final Printer printer = factory.createFor(new NumbersCategory());
    assertNotNull(printer);
    assertTrue(printer instanceof NumbersPrinter);
  }

  @Test
  void testCreateForCarsCategory() {
    final Printer printer = factory.createFor(new CarsCategory());
    assertNotNull(printer);
    assertTrue(printer instanceof CarsPrinter);
  }

  @Test
  void testCreateForNull() {
    final Printer printer = factory.createFor(null);
    assertNull(printer);
  }

  @Test
  void testCreateForNotConfiguredCategory() {
    final Printer printer = factory.createFor(new Category() {
      @Override
      public String getName() {
        return null;
      }
    });
    assertNull(printer);
  }
}