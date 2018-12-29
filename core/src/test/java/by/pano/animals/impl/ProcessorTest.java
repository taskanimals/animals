package by.pano.animals.impl;

import by.pano.animals.BaseTest;
import by.pano.animals.TestUtils;
import by.pano.animals.api.Category;
import by.pano.animals.categories.AnimalsCategory;
import by.pano.animals.categories.CarsCategory;
import by.pano.animals.categories.NumbersCategory;
import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.URISyntaxException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorTest extends BaseTest {

  private Processor processor;

  @BeforeEach
  void beforeEach() {
    processor = new Processor(CategorySupport.load());
  }

  @Test
  void testSuccess() throws URISyntaxException, AnimalsException {
    final List<Category> categories = processor.process(TestUtils.getFile("/input.txt"));

    final Category animals = new AnimalsCategory();
    animals.add("sheep");
    animals.add("horse");
    animals.add("cow");
    animals.add("horse");
    animals.add("moose");

    final Category cars = new CarsCategory();

    final Category numbers = new NumbersCategory();
    numbers.add("one");
    numbers.add("three");
    numbers.add("two");
    numbers.add("one");
    numbers.add("three");
    numbers.add("seven");
    numbers.add("six");
    numbers.add("six");
    assertEquals(ImmutableList.of(animals, cars, numbers), categories);
  }

  @Test
  void testSuccess2() throws URISyntaxException, AnimalsException {
    final List<Category> categories = processor.process(TestUtils.getFile("/input2.txt"));
    final Category animals = new AnimalsCategory();
    animals.add("sheep");
    animals.add("horse");
    animals.add("cow");
    animals.add("horse");
    animals.add("moose");

    final Category cars = new CarsCategory();
    cars.add("AUDI");
    cars.add("BMW");
    cars.add("Audi");
    cars.add("VW");
    cars.add("OPEL");
    cars.add("Opel");

    final Category numbers = new NumbersCategory();
    numbers.add("one");
    numbers.add("three");
    numbers.add("two");
    numbers.add("one");
    numbers.add("three");
    numbers.add("seven");
    numbers.add("six");
    numbers.add("six");
    assertEquals(ImmutableList.of(animals, cars, numbers), categories);
  }

  @Test
  void testEmptyFile() throws URISyntaxException, AnimalsException {
    final List<Category> categories = processor.process(TestUtils.getFile("/inputEmpty.txt"));
    final Category animals = new AnimalsCategory();

    final Category cars = new CarsCategory();

    final Category numbers = new NumbersCategory();

    assertEquals(ImmutableList.of(animals, cars, numbers), categories);
  }

  @Test
  void testFileWithNonCategoryFirstLine() throws URISyntaxException, AnimalsException {
    final List<Category> categories = processor.process(TestUtils.getFile("/input3.txt"));
    final Category animals = new AnimalsCategory();
    animals.add("sheep");
    animals.add("horse");
    animals.add("cow");
    animals.add("horse");
    animals.add("moose");

    final Category cars = new CarsCategory();

    final Category numbers = new NumbersCategory();
    numbers.add("seven");
    numbers.add("six");
    numbers.add("six");
    assertEquals(ImmutableList.of(animals, cars, numbers), categories);
  }

  @Test
  void testNull()  {
    assertThrows(AnimalsException.class, () -> processor.process(null));
  }

}