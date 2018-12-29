package by.pano.animals.categories;


import by.pano.animals.api.Category;
import by.pano.animals.api.Printable;
import by.pano.animals.printers.AnimalsPrinter;

@Printable(print = AnimalsPrinter.class)
public class AnimalsCategory extends Category {

  private static final String NAME = "ANIMALS";

  @Override
  public String getName() {
    return NAME;
  }
}
