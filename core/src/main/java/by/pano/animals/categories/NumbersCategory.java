package by.pano.animals.categories;

import by.pano.animals.api.Category;
import by.pano.animals.api.Printable;
import by.pano.animals.printers.NumbersPrinter;

@Printable(print = NumbersPrinter.class)
public class NumbersCategory extends Category {

  private static final String NAME = "NUMBERS";

  @Override
  public String getName() {
    return NAME;
  }
}
